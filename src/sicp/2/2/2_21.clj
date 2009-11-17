(ns sicp.2.2.2_21
  (:use clojure.test))

(defn imap [proc items]
  (if (empty? items)
      items
      (cons (proc (first items))
            (imap proc (rest items)))))


(defn square [x]
  (* x x))

(defn listsquare [x]
  (if (empty? x)
    x
  (cons (square (first x)) (listsquare (rest x)))))

(defn mapsquare [x]
  (imap square x))

(deftest expressions
  (are [expression expected] (= expression expected)
  (list 4 9 16 25) (listsquare (list 2 3 4 5))
    (list 4 9 16 25) (mapsquare (list 2 3 4 5))))


