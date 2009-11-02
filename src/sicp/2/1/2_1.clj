(ns sicp.2.1.2_1
  (:use clojure.test
    :require clojure.contrib.generic.math-functions))


(defn gcd [a b]
  (if (= b 0)
    a
    (gcd b (mod a b))))

(defn make-rat [n d]
   (let [g (gcd (abs n) (abs d))]
   (if (< 0 (* n d))
       (list (/ (abs n) g) (/ (abs d) g))
       (list (/ (* -1 (abs n)) g) (/ (abs d) g)))))


(println (make-rat -2 -4))

(println (make-rat 2 -4))

(println (make-rat -2 4))

(println (make-rat 2 4))