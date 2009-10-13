(ns sicp.1.2.1_17
  (:use clojure.test))



(defn even [x]
  (= (rem x 2) 0))

(defn double-num [x]
  (* x 2))

(defn half [x]
  (/ x 2 ))


(defn fast-mult-helper [a b n]
  (if (= n 1)
      (+ a b)
      (if (even n)
          (recur a (double-num b) (half n))
          (recur (+ a b) b (- n 1)))))

(defn fast-mult
  [x n]
  (fast-mult-helper 0 x n))

(deftest expressions
  (are [expression expected] (= expression expected)
    4 (fast-mult 2 2)
    6 (fast-mult 2 3)
    8 (fast-mult 2 4)
    20 (fast-mult 2 10))
    25 (fast-mult 5 5))