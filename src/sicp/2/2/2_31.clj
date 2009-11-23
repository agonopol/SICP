(ns sicp.2.2.2_31
  (:use clojure.test))


(defn square [x]
  (* x x))

(defn map-tree [f x]
  (if (list? x)
    (if (empty? x)
      x
      (cons (map-tree f (first x)) (map-tree f (rest x))))
    (f x)))

(defn square-tree [x] (map-tree square x))

(deftest threemap
  (are [expression expected] (= expression expected)
    (list 4 (list 9 16)) (square-tree (list 2 (list 3 4)))
    (list 1 (list 4 (list 9 16) 25) (list 36 49)) (square-tree  (list 1 (list 2 (list 3 4) 5) (list 6 7)))
    ))