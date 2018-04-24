(ns clubhouse-metrics2.story-timer
  (:require [clj-time.core :as t]
            [clj-time.coerce :as c]
            [clubhouse-metrics2.story-mapper :as smapper]
            [clubhouse-metrics2.time-extractor :as textract]
            [clubhouse-metrics2.tictoc :as tictoc]))


(defn duration [id]
  (tictoc/days-between (textract/parse-times (smapper/story id)))
  )
