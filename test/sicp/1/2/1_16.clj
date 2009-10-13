(ns sicp.1.2.1_16
  (:use clojure.test))



(defn even [x]
  (= (rem x 2) 0))

(defn f [x n]
  (let [f-iter (fn [e x n]
    (if (= 0 n)
      e
      (if (even n)
        (recur e (* x x) (/ n 2))
        (recur (* x e) x (- n 1)))))]
  (f-iter 1 x n)))


(deftest expressions
  (are [expression expected] (= expression expected)
    true (even 6)
    false (even 5)
    4 (f 2 2)
    8 (f 2 3)
    9 (f 3 2)
    16 (f 2 4)
    32 (f 2 5)
    64 (f 2 6)
    128 (f 2 7)
    ))