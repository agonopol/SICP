(ns sicp.2.1.2_4
  (:use clojure.test
    :require clojure.contrib.generic.math-functions))

(defn icons [x y]
  (fn [n] (n x y)))

(defn car [z]
  (z (fn [p q] p)))

(deftest expressions
  (are [expression expected] (= expression expected)
    4 (car (icons 4 9))))
