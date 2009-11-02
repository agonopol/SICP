(ns sicp.1.3.1_41
  (:use clojure.test))


(defn doublecompose [f]
    (comp f f))

(deftest expressions
  (are [expression expected] (= expression expected)
   7 ((doublecompose inc) 5)
   9 (((doublecompose doublecompose) inc) 5)
   21 (((doublecompose (doublecompose doublecompose)) inc) 5)
   ))