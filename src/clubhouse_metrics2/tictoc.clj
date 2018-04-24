(ns clubhouse-metrics2.tictoc
  (:require [clj-time.core :as t]
            [clj-time.coerce :as c]
            [clojure.java.io :as io]))

(defn days-between [times-hash]
  (t/in-days (t/interval (:start_time times-hash) (:end_time times-hash))))
