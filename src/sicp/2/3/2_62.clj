(ns sicp.2.3.2_62
  (:use clojure.test))

(defn union-set [x y]
  (cond (empty? x) y
        (empty? y) x
        (= (first x) (first y)) (cons (first x) (union-set (rest x) (rest y)))
        (> (first x) (first y)) (cons (first y) (union-set x (rest y)))
        (< (first x) (first y))  (cons (first x) (union-set (rest x) y))))

(deftest union-works
  (is (= '(1 2 3 4 5 6) (union-set '(1 4 6) '(1 2 3 5)))))