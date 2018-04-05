(defproject clubhouse-metrics2 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "3.8.0"]
                 [cheshire "5.8.0"]
                 [clj-time "0.14.2"]
                 [org.clojure/data.csv "0.1.4"]
                 [org.clojure/data.json "0.2.6"]]
  :main ^:skip-aot clubhouse-metrics2.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
