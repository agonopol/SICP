(ns sicp.2.2.2_17
  (:use clojure.test))

(defn last-pair
    [x]
  (if (empty? (rest x))
    (list (first x))
    (last-pair (rest x))))


(deftest expressions
  (are [expression expected] (= expression expected)
     (list 5) (last-pair (list 1 2 3 4 5))
    ))