(ns sicp.2.2.2_18
  (:use clojure.test))


(defn parity-filter [filter x]
         (if (empty? x)
           (x)
           (:else (if (filter (first x)) (list (first x) (parity-filter filter (rest x)))
                  (parity-filter filter (rest x))))))
(defn same-parity
  [x]

    (if (even? (first x))
      (list (first x) (parity-filter even? (rest x)))
      (list (first x) (parity-filter odd? (rest x)))))

(println (same-parity (list 1 2 3 4 5 6)))
(println (same-parity (list 2 3 4 5 6 7)))
