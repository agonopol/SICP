(ns sicp.2.2.2_35
  (:use clojure.test))


(defn accumulate [op init seq]
  (if (empty? seq)
      init
     (op (first seq) (accumulate op init (rest seq)))))


(defn leaves [x] (if (list? x) (if (empty? x) 0 (+ (leaves (first x)) (leaves (last x)))) 1))

(defn count-leaves [t]
  (accumulate (fn [x y] (+ y x)) nil (map leaves t)))

(deftest leaf-tests
  (are [expression expected] (= expression expected)

    ))