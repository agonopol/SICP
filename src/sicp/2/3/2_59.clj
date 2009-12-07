(ns sicp.2.3.2_59
  (:use clojure.test))


(defn element-of-set? [x set]
  (cond (empty? set) false
        (= x (first set)) true
        :else (element-of-set? x (rest set))))

(deftest element-of-set-works
 (is (= true (element-of-set? 3 '(1 2 3 4 5)))))

(defn adjoin-set [x set]
  (if (not (element-of-set? x set))
    (cons x set)
    set))

(defn union-set [x y]
  (if (empty? x)
    y
    (union-set (rest x) (adjoin-set (first x) y))))

(deftest union-works
  (is (= '(3 2 1 4 5) (union-set '(1 2 3) '(4 5))))
  (is (= '(3 2 1 4 5) (union-set '(1 2 3 4 5) '(4 5)))))



