(ns clojurerest.routes.document
      (:use compojure.core)
      (:use cheshire.core)
      (:use ring.util.response)
      (:use clojurerest.models.document)
      (:require [compojure.handler :as handler]
                [ring.middleware.json :as middleware]
                [compojure.route :as route]))

    (defroutes document-routes
      (context "/documents" [] (defroutes documents-routes
        (GET  "/" [] (get-all-documents))
        (POST "/" {body :body} (create-new-document body))
        (context "/:id" [id] (defroutes document-routes
          (GET    "/" [] (get-document id))
          (PUT    "/" {body :body} (update-document id body))
          (DELETE "/" [] (delete-document id))))))
      )
