(ns sicp.2.2.2_18
  (:use clojure.test))

(defn ireverse
  [x]
  (if (empty? x)
    x
    (conj  (list (first x)) (ireverse (rest x)))))


(println (ireverse (list 1 2 3 4)))