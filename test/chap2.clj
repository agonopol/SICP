(ns test
  (:use clojure.test))

(def tests
     ['sicp.2.1.2_1 'sicp.2.1.2_2 'sicp.2.1.2_3 'sicp.2.1.2_4 'sicp.2.1.2_5 'sicp.2.1.2_6 'sicp.2.2.2_17
      'sicp.2.2.2_18 'sicp.2.2.2_21 'sicp.2.2.2_23 'sicp.2.2.2_25 'sicp.2.2.2_27 'sicp.2.2.2_28 'sicp.2.2.2_29
      'sicp.2.2.2_30 'sicp.2.2.2_31 'sicp.2.2.2_33 'sicp.2.2.2_34 'sicp.2.2.2_35 'sicp.2.2.2_36])

(doseq [test tests] (require test))

(apply run-tests tests)

(shutdown-agents)