(ns clubhouse-metrics2.caller
  (:require [clj-http.client :as client]
           ; [clubhouse-metrics2.story-accessor :as saccess]
           ; [clubhouse-metrics2.clubhouse-accessor :as caccess]
            ))

(defn get-url [url]
  (client/get url {:as :json}))
