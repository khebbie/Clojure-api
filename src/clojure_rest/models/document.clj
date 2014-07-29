(ns clojure-rest.models.document
      (:import com.mchange.v2.c3p0.ComboPooledDataSource)
      (:use ring.util.response)
    (:require [monger.core :as mg]
            [monger.collection :as mc])
      (:import org.bson.types.ObjectId)
      (:require
                [compojure.route :as route]))

    (defn get-all-documents []
      (response
        (let [conn (mg/connect)
         db (mg/get-db conn "monger-test")]
        (mc/find-maps db "documents"))))

    (defn get-document [id]
    (let [conn (mg/connect)
      db   (mg/get-db conn "monger-test")
      coll "documents"]
  ;; find one document by id, as Clojure map
  (mc/find-map-by-id db coll (ObjectId. id))))

    (defn create-new-document [doc]
      (let [conn (mg/connect)
      db   (mg/get-db conn "monger-test")
      oid  (ObjectId.)
      document  (assoc doc "source" "post")]
      (mc/insert db "documents" (merge document {:_id oid})))
      {:status 200}
      )

    (defn update-document [id doc]
      {:status 200}
)
    (defn delete-document [id]
      {:status 204})
