(ns clubhouse-metrics2.resource-reader
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))


(defn readr [filename]
  (edn/read-string (slurp (io/resource filename))))
