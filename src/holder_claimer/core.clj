(ns holder-claimer.core
  (:gen-class)
  (:use
    [twitter.oauth]
    [environ.core]
    [twitter.api.restful]
    [clojure.string :only (split trim)]
    [postal.core]
    [taoensso.timbre :as timbre
     :refer (log  debug  info  error)]))

(defn send-mail [screen-name]
  (debug "sending email for" screen-name)
  (try
    (send-message ^{:host "smtp.gmail.com"
                    :user (env :gmail-user)
                    :pass (env :gmail-pass)
                    :ssl :yes}
                  {:from (env :gmail-from)
                   :to (env :notify)
                   :subject (str "Holder available! " screen-name)
                   :body screen-name})
    (catch Exception e
      (error "mail not sent" e))))

(defn holder-free [screen-name]
  (debug "lookup screen name" screen-name)
  (try
    (let [creds (twitter.oauth/make-oauth-creds
                  (env :claimer-consumer-key)
                  (env :claimer-consumer-secret)
                  (env :claimer-access-token)
                  (env :claimer-access-token-secret))]
      (users-lookup :oauth-creds creds :params {:screen_name screen-name})
      false)
    (catch Exception e
      (if (.contains (.getMessage e) "that page does not exist")
        true
        (error "Twitter error" e)))))

(defn -main
  "Try to grab that username!"
  [& args]
  (try
    (let [screen-names (map trim (split (env :claims) #","))]
      (info "trying to claim my precious" screen-names)
      (doall (map send-mail (filter holder-free screen-names))))
    (catch Exception e
      (error e)))
  (System/exit 0))

