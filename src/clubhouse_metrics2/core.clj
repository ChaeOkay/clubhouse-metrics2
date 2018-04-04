(ns clubhouse-metrics2.core
  (:require [clj-http.client :as client]
            [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clojure.data.json :as json]
            [clojure.string :as string])
           ; [cheshire.core :refer :all])
  (:gen-class))


(defn -main
  "To be described"
  [& args]
  ;; validate clubhouse access
  (def access
   (with-open [r (io/reader ".secrets.edn")]
    (edn/read (java.io.PushbackReader. r))))
  ;;take in story
  ;;make api call
  (def storycall (client/get (apply str "https://api.clubhouse.io/api/v2/stories/6236?token=" (access :token)) {:as :json}))
  ;;parse/save call output to file
  (clojure.pprint/pprint storycall (clojure.java.io/writer "output.json"))
  ;;perform story calculations, output to file
  (def timer 
    (with-open [r (io/reader "output.json")]
      (edn/read (java.io.PushbackReader. r))))
  (def starttime (get-in timer [:body :started_at]))
  (def endtime (get-in timer [:body :completed_at]))
  (println "Hello, World!"))
