    (defproject clojure-rest "0.1.0-SNAPSHOT"
      :description "REST service for documents"
      :url "http://blog.interlinked.org"
      :dependencies [[org.clojure/clojure "1.6.0"]
                     [compojure "1.1.6"]
                     [ring/ring-json "0.3.1"]
                     [c3p0/c3p0 "0.9.1.2"]
                     [cheshire "5.3.1"]
                     [com.novemberain/monger "2.0.0"]]
      :plugins [[lein-ring "0.8.10"]]
      :ring {:handler clojure-rest.handler/app
      :auto-reload? true
       :auto-refresh? true}
      :profiles
      {:dev {:dependencies [[ring-mock "0.1.3"]]}})
