(ns clojure-rest.models.document
      (:import com.mchange.v2.c3p0.ComboPooledDataSource)
      (:use ring.util.response)
    (:require [cheshire.core :refer :all]
            [cheshire.generate :refer [add-encoder encode-str remove-encoder]])
    (:require [monger.core :as mg]
            [monger.collection :as mc])
            (:require monger.json)
      (:import org.bson.types.ObjectId)
      (:require
                [compojure.route :as route]))

(cheshire.generate/add-encoder org.bson.types.ObjectId cheshire.generate/encode-str)

    (defn get-all-documents []
      (response
        (let [conn (mg/connect)
         db (mg/get-db conn "monger-test")]
         (generate-string
        (mc/find-maps db "documents")))))

    (defn get-document [id]
    (let [conn (mg/connect)
      db   (mg/get-db conn "monger-test")
      coll "documents"]
   (generate-string (mc/find-map-by-id db coll (ObjectId. id)))))

    (defn create-new-document [doc]
      (let [conn (mg/connect)
      db   (mg/get-db conn "monger-test")
      oid  (ObjectId.)
      document  (assoc {} "title" (doc "title") "text" (doc "text"))]
      (mc/insert db "documents" (merge document {:_id oid})))
      {:status 200}
      )

    (defn update-document [id doc]
      {:status 200}
)
    (defn delete-document [id]
      {:status 204})
