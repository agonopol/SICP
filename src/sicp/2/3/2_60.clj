(ns sicp.2.3.2_60
  (:use clojure.test))


;; Big 0 of n
(defn element-of-set? [x set]
  (cond (empty? set) false
        (= x (first set)) true
        :else (element-of-set? x (rest set))))

;;Big O of 1
(defn adjoin-set [x set]
  (cons x set))


;;Big O of n
(defn union-set [x y]
  (if (empty? x)
    y
    (union-set (rest x) (adjoin-set (first x) y))))



(deftest union-works
  (is (= '(3 2 1 4 5) (union-set '(1 2 3) '(4 5))))
  (is (= '(5 4 3 2 1 4 5) (union-set '(1 2 3 4 5) '(4 5)))))


;;Big 0 of n^2
(defn intersect-set [x y]
  (cond (empty? x) ()
    (element-of-set? (first x) y) (cons (first x) (intersect-set (rest x) y))
    :else (intersect-set (rest x) y)))

(deftest intersect-works
  (is (= '(1 3 4 2) (intersect-set '(1 5 3 5 6 4 2) '(1 2 3 4)))))




