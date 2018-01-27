# Feedback Component

![](https://s3.eu-central-1.amazonaws.com/sms-composer.wefarm.org/img/screener.jpg)

A simple Feedback component written in ClojureScript.

![](https://s3.eu-central-1.amazonaws.com/sms-composer.wefarm.org/img/screener2.jpg)

[Running example here](https://s3.eu-central-1.amazonaws.com/sms-composer.wefarm.org/feedback/index.html)


## Development Mode

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build

```
lein clean
lein cljsbuild once min
```
