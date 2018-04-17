(ns clubhouse-metrics2.clubhouse
  (:require [clubhouse-metrics2.resource-reader :as reader]
            [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clubhouse-metrics2.authenticator :as auther]))

(defn story-url [story-id]
  (apply str "https://api.clubhouse.io/api/v2/stories/" story-id "?token=" auther/configuration))
