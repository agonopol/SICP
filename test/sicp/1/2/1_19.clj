(ns sicp.1.2.1_19
  (:use clojure.test))



(defn even [x]
  (= (rem x 2) 0))

(defn fib-iter [a b p q count]
  (if (= count 0)
      b
      (if (even? count)
          (recur a  b  (+ (* q q) (* p p)) (+ (* 2 (* p q)) (* q q)) (/ count 2))
          (recur (+ (* b q) (* a q) (* a p)) (+ (* b p) (* a q)) p  q  (- count 1)))))

(defn fib [n]
  (fib-iter 1 0 0 1 n))

(deftest expressions
  (are [expression expected] (= expression expected)
    2 (fib 3)
    5 (fib 5)
    8 (fib 6)
   ))