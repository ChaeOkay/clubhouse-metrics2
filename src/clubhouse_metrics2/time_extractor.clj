(ns clubhouse-metrics2.time-extractor
  (:require [clojure.java.io :as io]
            [clubhouse-metrics2.story-mapper :as smapper]
            [clj-time.core :as t]
            [clj-time.coerce :as c]))


(defn parse-times [story-body]
  "Given a story body, def its start and end time in hash map"
  (hash-map
    :start_time (c/to-date-time (get-in story-body [:body :started_at])),
    :end_time (c/to-date-time (get-in story-body [:body :completed_at]))))
