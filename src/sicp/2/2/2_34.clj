(ns sicp.2.2.2_34
  (:use clojure.test))


(defn accumulate [op init seq]
  (if (empty? seq)
      init
     (op (first seq) (accumulate op init (rest seq)))))

(defn ipoly [x coefficients]
  (accumulate  (fn [coef terms] (+ (* x terms) coef))  0 coefficients))

(deftest ipoly-tests
  (are [expression expected] (= expression expected)
    15 (accumulate + 0 (list 1 2 3 4 5))
    79 (ipoly 2 (list 1 3 0 5 0 1))
    ))