(ns sicp.2.2.2_23
  (:use clojure.test))

(defn for-each [proc x]
  (if (empty? x)
    x
    (:else (proc (first x))
    (for-each proc (rest x)))))

(for-each print (list 1 2 3 4 5))