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

; 1. Get story function working in repl
; 1.5 rename stuff to relevant actions
; 2. Add duration in days to output (in addition to hours)


(defn story [id]
  "Given a clubhouse story id, return story data."
    (caller/get-url (clubhouse/story-url id)))

