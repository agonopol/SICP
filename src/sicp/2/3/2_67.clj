(ns sicp.2.3.2_67
  (:use clojure.test))


(defn leaf? [object]
  (= (first object) `leaf))

(defn make-leaf [sym weight]
  (list `leaf sym weight))

(defn symbol-leaf [x] (nth x 1))

(defn weight-leaf [x] (nth x 2))

(deftest weight-leaf-test
  (is (= 0 (weight-leaf (make-leaf `A 0)))))

(defn symbols [tree]
   (if (leaf? tree)
     (list (symbol-leaf tree))
     (nth tree 2)))


(deftest is-leaf-test
  (is (leaf? (make-leaf `A 0))))

(defn weight [tree]
  (if (leaf? tree)
      (weight-leaf tree)
      (nth tree 3)))

(deftest weight-test
  (is (= 3 (weight (make-leaf `A 3)))))


(defn make-code-tree [left right]
  (list
      left
      right
      (concat (symbols left) (symbols right))
      (+ (weight left) (weight right))))


(deftest symbol-concat
  (is (= `(A B) (concat (symbols (make-leaf `A 0)) (symbols (make-leaf `B 0)))))
  (is (= `(A B C) (concat (symbols (make-leaf `A 0)) (symbols (make-code-tree (make-leaf `B 0) (make-leaf `C 0)))))))

(defn left-branch [tree ] (first tree))

(defn right-branch [tree] (first (rest tree)))

(defn choose-branch [bit branch]
  (cond (= bit 0) (left-branch branch)
        (= bit 1) (right-branch branch)))

(defn decode [bits tree]
  (let [decode-1 (fn [bits current-branch msg]
                  (if (empty? bits)
                     msg
                     (let [next-branch (choose-branch (first bits) current-branch)]
                          (if (leaf? next-branch)
                            (recur (rest bits) tree (conj msg (symbol-leaf next-branch)))
                            (recur (rest bits) next-branch msg)))))]
    (decode-1 bits tree (list ))))

(def sample-tree (make-code-tree (make-leaf `A 4) (make-code-tree (make-leaf `B 2) (make-code-tree (make-leaf `D 1) (make-leaf `C 1)))))

(def sample-message `(0 1 1 0 0 1 0 1 0 1 1 1 0))

(print (decode sample-message sample-tree))