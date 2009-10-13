(ns test
  (:use clojure.test))

(def tests
     ['clojure.test_koans 'sicp.week_one 'sicp.1.2.1_11 'sicp.1.2.1_12 'sicp.1.2.1_16 'sicp.1.2.1_17 'sicp.1.2.1_19 'sicp.1.2.1_23])

(doseq [test tests] (require test))

(apply run-tests tests)

(shutdown-agents)