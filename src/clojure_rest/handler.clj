(ns clojure-rest.handler
      (:import com.mchange.v2.c3p0.ComboPooledDataSource)
      (:use compojure.core)
      (:use cheshire.core)
      (:use ring.util.response)
      (:use clojure-rest.routes.document)
      (:require [compojure.handler :as handler]
                [ring.middleware.json :as middleware]
                [clojure.java.jdbc :as sql]
                [compojure.route :as route]))
(defroutes app-routes
  (route/not-found "Not Found"))

    (def app
        (-> (handler/api (routes document-routes app-routes))
            (middleware/wrap-json-body)
            (middleware/wrap-json-response)))
