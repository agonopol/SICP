(ns sicp.1.3.1_29
  (:use clojure.test))



(defn sum [term a next b]
      (if (> a b)
       0
        (+ (term a) (sum term (next a) next b))))

(defn cube [n]
      (* n n n))


(defn y [f a k h]
      (f (+ a (* k h))))

(defn simpson [f a b n]
      (let [h (/ (- b a) n)
            s (fn [k]
             (cond (= k n) (y f a k h)
                   (= k 0) (y f a k h)
                   (even? k) (* 2 (y f a k h))
                   (odd? k) (* 4 (y f a k h))))]
        (* (/ h 3) (sum s 0 inc n))))


(println (simpson cube 0 1 1000))
(println (simpson cube 0 1 100))