(ns sicp.2.1.2_6
  (:use clojure.test))


(defn one []
  (fn [f x] (f x)))

(defn two []
  (fn [f x] (f (f x))))

(defn add [f g]
  (fn [f x] (f (g f x))))

(deftest expressions
  (are [expression expected] (= expression expected)
    1 ((one) inc 0)
    2 ((two) inc 0)
    3 ((add (one) (two)) inc 0)
    ))