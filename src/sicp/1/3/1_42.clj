(ns sicp.1.3.1_42
  (:use clojure.test))


(defn compose [f g]
     (comp f g))

(defn square [x]
  (* x x))

(deftest expressions
  (are [expression expected] (= expression expected)
   49 ((compose square inc) 6)
   ))