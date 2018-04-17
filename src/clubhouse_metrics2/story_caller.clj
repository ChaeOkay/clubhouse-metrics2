(ns clubhouse-metrics2.story-caller
  (:require [clj-http.client :as client]
            [clubhouse-metrics2.story-accessor :as saccess]
            [clubhouse-metrics2.clubhouse-accessor :as caccess]))

(def storycall (client/get (apply str "https://api.clubhouse.io/api/v2/stories/" (saccess/storyaccess :story-id) "?token=" (caccess/access :token)) {:as :json}))

(defn storycalling []
  (clojure.pprint/pprint storycall (clojure.java.io/writer "output.json")))
