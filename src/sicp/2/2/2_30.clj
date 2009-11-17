(ns sicp.2.2.2_30
  (:use clojure.test))


(defn square [x]
  (* x x))

(defn square-tree [x]
  (if (list? x)
    (if (empty? x)
      x
      (cons (square-tree (first x)) (square-tree (rest x))))
    (square x)))

(deftest squaretreetests
  (are [expression expected] (= expression expected)
    (list 4 (list 9 16)) (square-tree (list 2 (list 3 4)))
    (list 1 (list 4 (list 9 16) 25) (list 36 49)) (square-tree  (list 1 (list 2 (list 3 4) 5) (list 6 7)))
    ))