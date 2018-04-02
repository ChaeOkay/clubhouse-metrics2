(ns clubhouse-metrics2.core
  (:require [clj-http.client :as client])
  (:require [clojure.java.io :as io])
  (:gen-class))


(defn -main
  "To be described"
  [& args]
  (def access (slurp (io/file ".secrets.clj")))
  (def story-call (client/get (str "https://api.clubhouse.io/api/v2/stories/8022?token=" access)))
  (println "Hello, World!")
)
