(ns sicp.2.2.2_29
  (:use clojure.test))

(defn mobile [left right]
  (list left right))

(defn branch [length structure]
  (list length structure))

(defn left-branch [x]
  (first x))

(defn right-branch [x]
  (last x))

(defn branch-length [x]
  (first x))

(defn branch-structure [x]
  (last x))


(defn total-weight [x]
  (if (list? x)
      (+ (total-weight (branch-structure (left-branch x))) (total-weight (branch-structure (right-branch x))))
      x))

(defn total-length [x]
  (if (not (list? x))
      0
      (+ (branch-length (left-branch x)) (total-length (branch-structure (left-branch x))) (branch-length (right-branch x)) (total-length (branch-structure (right-branch x))))))

(defn balanced? [x]
  (= (* (total-weight (branch-structure (left-branch x))) (total-length (branch-structure (left-branch x))))
     (* (total-weight (branch-structure (right-branch x))) (total-length (branch-structure (right-branch x))))))

(deftest mobiletests
  (are [expression expected] (= expression expected)
    10 (total-weight (mobile (branch 1 (mobile (branch 1 3) (branch 1 4))) (branch 1 3)))
    4  (total-length (mobile (branch 1 (mobile (branch 1 3) (branch 1 4))) (branch 1 3)))
    false (balanced?  (mobile (branch 1 (mobile (branch 1 3) (branch 1 4))) (branch 1 3)))
    true (balanced?  (mobile (branch 1 (mobile (branch 1 3) (branch 1 4))) (branch 1 (mobile (branch 1 3) (branch 1 4)))))
    ))