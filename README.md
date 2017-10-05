# Feedback Component

![](http://snappyimages.nextwavesrl.netdna-cdn.com/img/56af0490e144fcbad47dea57185eebec.png)

A simple Feedback component written in ClojureScript.

![](http://snappyimages.nextwavesrl.netdna-cdn.com/img/097f821a0d8b3b9906f5a15eb63ea95e.png)

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
