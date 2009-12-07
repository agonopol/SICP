(ns sicp.2.3.2_56
  (:use clojure.test))





(defn variable?
  [x]
  (symbol? x))

(defn same-variable?
  [v1 v2]
  (and (variable? v1) (variable? v2) (== v1 v2)))


(defn =number? [exp num]
  (and (number? exp) (= exp num)))

(defn make-sum [a1 a2]
  (cond (=number? a1 0)
          a2
        (=number? a2 0)
          a1
        (and (number? a1) (number? a2))
          (+ a1 a2)
        :else (list '+ a1 a2)))

(defn make-product [m1 m2]
  (cond (or (=number? m1 0)
            (=number? m2 0))
              0
        (=number? m1 1)
          m2         
        (=number? m2 1)
          m1
        (and (number? m1) (number? m2))
            (* m1 m2)
        :else (list '* m1 m2)))


(defn exp?
  [x]
  (and (list? x) (== (first x) 'exp)))

(defn sum?
  [x]
  (and (list? x) (== (first x) '+)))

(defn addend [s] (second s))

(defn augend [s] (second (rest s)))

(defn product? [x]
  (and (list? x) (== (first x) '*)))

(defn multiplier [p]
  (second p))

(defn multiplicand
  [p]
  (second (rest p)))


(defn deriv [exp var]
  (cond (number? exp) 0
        (variable? exp)
         (if (same-variable? exp var)
              1
              0)
         (sum? exp)
              (make-sum (deriv (addend exp) var)
                   (deriv (augend exp) var))

        (product? exp)
          (make-sum
           (make-product (multiplier exp)
                         (deriv (multiplicand exp) var))
           (make-product (deriv (multiplier exp) var)
                         (multiplicand exp)))))


(deftest test-deriv
  (is (= ('y (deriv '(* x y) 'x)))))
