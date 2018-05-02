(ns clubhouse-metrics2.story-timer
  (:require [clj-time.core :as t]
            [clj-time.coerce :as c]
            [clojure.java.io :as io]))

(defn duration-days [times-hash]
  "Takes in start and end time and delivers days between"
  (t/in-days (t/interval (:start_time times-hash) (:end_time times-hash))))

(defn duration-hours [times-hash]
  "Takes in start and end time and delivers hours between"
  (t/in-hours (t/interval (:start_time times-hash) (:end_time times-hash))))


