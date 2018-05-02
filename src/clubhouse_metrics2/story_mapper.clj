(ns clubhouse-metrics2.story-mapper
  (:require [clojure.java.io :as io]
            [clj-http.client :as client]
            [clojure.edn :as edn]
            [clojure.data.json :as json]
            [clojure.string :as string]
            [clj-time.coerce :as c]
            [clojure.data.csv :as csv]
            [clj-time.core :as t]
            [clubhouse-metrics2.caller :as caller]
            [clubhouse-metrics2.clubhouse :as clubhouse]))

(defn story-body [id]
  "Given a clubhouse story id, return story data."
    (caller/get-url (clubhouse/story-url id)))

(defn story-times [id]
  "Given a story id, return its start and end time in hash map"
  (hash-map
    :start_time (c/to-date-time (get-in (story-body id) [:body :started_at])),
    :end_time (c/to-date-time (get-in (story-body id) [:body :completed_at]))))

(defn story-authors [id]
  )

