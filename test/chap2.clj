(ns test
  (:use clojure.test))

(def tests
     ['sicp.2.1.2_1 'sicp.2.1.2_2 'sicp.2.1.2_3 'sicp.2.1.2_4 'sicp.2.1.2_5])

(doseq [test tests] (require test))

(apply run-tests tests)

(shutdown-agents)