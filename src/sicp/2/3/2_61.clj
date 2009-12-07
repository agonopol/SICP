(ns sicp.2.3.2_61
  (:use clojure.test))


(defn adjoin-set [x set]
  (cond
        (empty? set) (list x)
        (= x (first set)) set
        (> x (first set)) (cons (first set) (adjoin-set x (rest set)))
        (< x (first set)) (cons x set)))


(deftest adjoin-set-works
  (is (= '(1 2 3 4 5 6)) (adjoin-set 1 '(2 3 4 5 6)))
  (is (= '(1 2 3) (adjoin-set 1 '(1 2 3))))
  (is (= '(1 2 3) (adjoin-set 2 '(1 3))))
  (is (= '(1 2 3) (adjoin-set 3 '(1 2)))))
