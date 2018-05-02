(ns clubhouse-metrics2.caller
  (:require [clj-http.client :as client]
            ))

(defn get-url [url]
  "Given a url, calls that url and returns json result"
  (client/get url {:as :json}))
