(ns clubhouse-metrics2.core
  (:require [clj-http.client :as client]
            [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clojure.data.json :as json])
           ; [cheshire.core :refer :all])
  (:gen-class))


(defn -main
  "To be described"
  [& args]
  ;;this will be a func
  (def access
   (with-open [r (io/reader ".secrets.edn")]
    (edn/read (java.io.PushbackReader. r))))
  ;;this will be a parsing function
  (def storycall (client/get (apply str "https://api.clubhouse.io/api/v2/stories/8022?token=" (access :token)) {:as :json}))
  ;;this will be a calculation
  ;;this will be an output function
  (println "Hello, World!"))
