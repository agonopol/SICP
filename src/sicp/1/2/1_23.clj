(ns sicp.1.2.1_23
  (:use clojure.test))

(defn square [x]
  (* x x))

(defn divides? [a b]
  (= (rem b a) 0))

(defn next-divisor [n]
  (if (= 2 n)
  3
  (+ n 2)))

(defn find-divisor [n test-divisor]
  (if (> (square test-divisor) n)
      n
      (if(divides? test-divisor n)
        test-divisor
        (find-divisor n (next-divisor test-divisor)))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))



(deftest expressions
  (are [expression expected] (= expression expected)
    2 (smallest-divisor 2)
    3 (smallest-divisor 9)
    true (prime? 3)
    false (prime? 4)
    true (prime? 17)
    false (prime? 21)
   ))