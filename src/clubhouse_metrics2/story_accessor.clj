(ns clubhouse-metrics2.story-accessor
  (require [clojure.java.io :as io]
           [clojure.edn :as edn]))



(def storyaccess (edn/read-string (slurp (io/resource "stories.edn"))))

(defn storyaccessing []
  )
