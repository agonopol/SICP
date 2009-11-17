(ns sicp.2.1.2_5
  (:use clojure.test
    :require clojure.contrib.generic.math-functions))


(defn exponent [b e]
  (if (= 0 e)
  1
  (* b (exponent b (dec e)))))

(defn icons [x y]
  (* (exponent 2 x) (exponent 3 y)))

(defn car [x]
  (if (not (= (mod 2 x) 0))
    1
    (+ 1 (/ x 2))))

(defn cdr [x]
  (if (not (= (mod 3 x) 0))
    1
    (+ 1 (/ x 3))))


(println (car (icons 4 9)))

(deftest expressions
  (are [expression expected] (= expression expected)
  ))




