(ns sicp.1.2.1_11
  (:use clojure.test))

(defn f
  [n]
   (if (< n 3)
    n
    (+ (f (- n 1)) (+ (* 2 (f (- n 2))) (* 3 (f (- n 3)))))))


(defn f-iter
  [n]
  (let [f-iter-helper
        (fn
          [n c x y z]
          (if (= n c) z
          (recur n (+ 1 c) y z (+ (* 3 x) (+ (* 2 y) z)))))]
  (if (< n 3) n
    (f-iter-helper n 2 0 1 2))))

(deftest expressions
  (are [expression expected] (= expression expected)
    2 (f 2)
    4 (f 3)
    11 (f 4)
    4 (f-iter 3)
    2 (f-iter 2)
    11 (f-iter 4)))