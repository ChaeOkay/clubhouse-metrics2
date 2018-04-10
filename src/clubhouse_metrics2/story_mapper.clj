(ns clubhouse-metrics2.story-mapper
  (:require [clojure.java.io :as io]
            [clj-http.client :as client]
            [clojure.edn :as edn]
            [clojure.data.json :as json]
            [clojure.string :as string]
            [clj-time.coerce :as c]
            [clojure.data.csv :as csv]
            [clj-time.core :as t]))


(defn storymapping [id]
  "TODO: describe this, extract out functionality"
  ;; validate clubhouse access
  (def access
   (with-open [r (io/reader ".secrets.edn")]
    (edn/read (java.io.PushbackReader. r))))
  ;;Take in project ID - output collection of stories
  ;;take in story - TODO: edit to read story ids from project
  (def storyaccess
    (with-open [r (io/reader "stories.edn")]
      (edn/read (java.io.PushbackReader. r))))
  ;;make api call
  (def storycall (client/get (apply str "https://api.clubhouse.io/api/v2/stories/" (storyaccess :story-id) "?token=" (access :token)) {:as :json}))
  ;;parse/save call output to file
  (clojure.pprint/pprint storycall (clojure.java.io/writer "output.json"))
  ;;perform story calculations, output to csv for g-drive opening
  (def timer
    (with-open [r (io/reader "output.json")]
      (edn/read (java.io.PushbackReader. r))))
  (def starttime (get-in timer [:body :started_at]))
  (def endtime (get-in timer [:body :completed_at]))
  (def startdt (c/to-date-time starttime))
  (def enddt (c/to-date-time endtime))
  (def duration (t/in-hours (t/interval startdt enddt)))
  (with-open [w (clojure.java.io/writer  "storydur.csv" :append true)]
    (.write w (println-str duration (apply str ", " (storyaccess :story-id))))))