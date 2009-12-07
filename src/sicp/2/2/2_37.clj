(ns sicp.2.2.2_37
  (:use clojure.test))



(deftest matrix-tests
  (are [expression expected] (= expression expected)
    (list 22 26 30) (accumulate-n + 0 (list (list 1 2 3) (list 4 5 6) (list 7 8 9) (list 10 11 12)))
    ))