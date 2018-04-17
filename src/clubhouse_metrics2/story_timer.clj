(ns clubhouse-metrics2.story-timer
  (:require [clj-time.core :as t]
            [clj-time.coerce :as c]))


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

(defn storytiming [])
