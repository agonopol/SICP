(ns test
  (:use clojure.test))

(def tests
     ['sicp.1.2.1_11 'sicp.1.2.1_12 'sicp.1.2.1_16 'sicp.1.2.1_17 'sicp.1.2.1_19 'sicp.1.2.1_23
      'sicp.1.3.1_29 'sicp.1.3.1_30 'sicp.1.3.1_31 'sicp.1.3.1_36 'sicp.1.3.1_41 'sicp.1.3.1_42 'sicp.1.3.1_43])

(doseq [test tests] (require test))

(apply run-tests tests)

(shutdown-agents)