(ns sicp.2.2.2_25
  (:use clojure.test))

(deftest expressions
  (are [expression expected] (= expression expected)
  7 (first (rest (first (rest (rest (list 1 3 (list 5 7) 9))))))))