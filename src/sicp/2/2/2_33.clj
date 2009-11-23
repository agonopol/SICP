(ns sicp.2.2.2_33
  (:use clojure.test))

(defn accumulate [op init seq]
  (if (empty? seq)
      init
     (op (first seq) (accumulate op init (rest seq)))))

(defn imap [p sequence]
  (accumulate (fn [x y] (list* (p x) y))) nil sequence)

(defn iappend [seq-one seq-two]
  (accumulate (fn [x y] (list* x y)) seq-two seq-one ))

(defn ilength [seq]
  (accumulate (fn [x y] (+ y 1)) 0 seq))
(deftest accumulate-tests
  (are [expression expected] (= expression expected)
    (list 1 2 3 4 5) (iappend (list 1 2 3 ) (list 4 5))
    5 (ilength (list 1 2 3 4 5))
    ))