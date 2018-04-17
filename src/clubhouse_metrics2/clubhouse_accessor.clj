(ns clubhouse-metrics2.authenticator
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clubhouse-metrics2.resource-reader :as reader]))

(def configuration (reader/readr ".secrets.edn"))

(defn thisisnothing [])
