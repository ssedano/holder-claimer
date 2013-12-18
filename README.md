# holder-claimer

I want a twitter screen name that is inactive, but I'm too lazy to check periodically. Lazy but resourceful.

## Usage

Do not use this software. When missused it might get your Twitter account banned.

But if you want to still use it you will be needing some environment options. And [leiningen](https://github.com/technomancy/leiningen).

```
CLAIMER_CONSUMER_KEY -> Twitter application consumer key
CLAIMER_CONSUMER_SECRET -> Twitter application consumer secret
CLAIMER_ACCESS_TOKEN -> Twitter user access token
CLAIMER_ACCESS_TOKEN_SECRET -> Twitter user access token secret

GMAIL_USER -> Gmail username
GMAIL_PASS -> Gmail password
GMAIL_FROM -> Gmail "sent from" address
CLAIMS -> Comma separated list of Twitter usernames

NOTIFY -> Address to send email if a username is available
```

Once that is done, simply grab the code and either execute it once, or create a jar and schedule its execution in you OS.

    $ git clone https://github.com/ssedano/holder-claimer
    $ lein run

## Options

See `Usage` section

## License

[Beerware](http://en.wikipedia.org/wiki/Beerware).

    --------------------------------------------------------------------------------
    "THE BEER-WARE LICENSE" (Revision 42):
    serafin.sedano@gmail.com wrote this software. As long as you retain this notice
    you can do whatever you want with this stuff. If we meet some day, and you think
    this stuff is worth it, you can buy me a beer in return. Serafin Sedano
    --------------------------------------------------------------------------------

Use this software at your own risk. If your twitter account gets banned for using this software it is very much your problem. But you can still buy me that beer.

