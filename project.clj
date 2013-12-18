(defproject holder-claimer "0.1.0-SNAPSHOT"
  :description "A twitter holder claimer, sort of."
  :url "http://github.com/ssedano/holder-claimer"
  :license {:name "Beerware"
            :url "http://en.wikipedia.org/wiki/Beerware"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [twitter-api "0.7.4"]
                 [environ "0.4.0"]
                 [com.draines/postal "1.11.1"]
                 [com.taoensso/timbre "3.0.0-RC2"]]
  :main ^:skip-aot holder-claimer.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
