(ns sicp.2.2.2_35
  (:use clojure.test))


(defn accumulate [op init seq]
  (if (empty? seq)
      init
     (op (first seq) (accumulate op init (rest seq)))))




(defn count-leaves [t]
  (accumulate (fn [x y] (+ x y)) 0 (map (fn [x] (if (seq? x) (count-leaves x) 1)) t)))

(deftest leaf-tests
  (are [expression expected] (= expression expected)
    3 (count-leaves '(2 (1 2)))
    5 (count-leaves '((2 3 4) (1 2)))
    ))