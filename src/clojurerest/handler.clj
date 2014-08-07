(ns clojurerest.handler
      (:use compojure.core)
      (:use cheshire.core)
      (:use ring.util.response)
      (:use clojurerest.routes.document)
      (:require [compojure.handler :as handler]
                [ring.middleware.json :as middleware]
                [compojure.route :as route]))
(defroutes app-routes
  (route/not-found "Not Found"))

    (def app
        (-> (handler/api (routes document-routes app-routes))
            (middleware/wrap-json-body)
            (middleware/wrap-json-response)))
