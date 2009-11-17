(ns sicp.2.2.2_28
  (:use clojure.test))


(defn fringe [x]
  (if (list? x)
    (if (empty? x)
      x
     (concat (fringe (first x)) (fringe (rest x))))
    (list x)))

(deftest frigetests
  (are [expression expected] (= expression expected)
    (list 1 2) (fringe (list 1 2))
    (list 1 2 3 4) (fringe (list (list 1 2) (list 3 4)))
    ))