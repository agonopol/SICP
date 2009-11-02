(ns sicp.1.3.1_43
  (:use clojure.test))


(defn ncompose [f n]
    (if (= 1 n )
      f
      (comp f (ncompose f (- n 1)))))

(defn square [x]
  (* x x))

(deftest expressions
  (are [expression expected] (= expression expected)
   625 ((ncompose square 2) 5)
   ))