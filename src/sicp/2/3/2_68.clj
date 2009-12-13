(ns sicp.2.3.2_68
  (:use clojure.test))


(defn leaf? [object]
  (= (first object) `leaf))

(defn make-leaf [sym weight]
  (list `leaf sym weight))

(defn symbol-leaf [x] (nth x 1))

(defn weight-leaf [x] (nth x 2))

(defn symbols [tree]
   (if (leaf? tree)
     (list (symbol-leaf tree))
     (nth tree 2)))

(defn weight [tree]
  (if (leaf? tree)
      (weight-leaf tree)
      (nth tree 3)))

(defn make-code-tree [left right]
  (list
      left
      right
      (concat (symbols left) (symbols right))
      (+ (weight left) (weight right))))


(defn in [x l]
  (reduce (fn [a b] (or a b)) false (map (fn [y] (= y x)) l)))


(deftest test-in
  (is (in `a `(b c d a)))
  (is (not (in `a `(b c d)))))


(defn left-branch [tree ] (first tree))

(defn right-branch [tree] (first (rest tree)))

(defn encode-symbol [sym t]
  (cond (leaf? t)
       `()
        (in sym (symbols (left-branch t)))
         (cons 0 (encode-symbol sym (left-branch t)))
        (in sym (symbols (right-branch t)))
         (cons 1 (encode-symbol sym (right-branch t)))
        (:else ) (throw "Symbol not in Map")))


(deftest encode-symbol-test
  (is (= `(0) (encode-symbol `A (make-code-tree (make-leaf `A 0) (make-leaf `B 0)))))
  (is (= `(1) (encode-symbol `B (make-code-tree (make-leaf `A 0) (make-leaf `B 0)))))
  (is (= `(1 0) (encode-symbol `B (make-code-tree (make-leaf `A 0) (make-code-tree (make-leaf `B 0) (make-leaf `C 0))))))
  )

(defn encode [message tree]
  (if (empty? message)
     `()
      (concat (encode-symbol (first message) tree)
            (encode (rest message) tree))))


(def sample-tree (make-code-tree (make-leaf `A 4) (make-code-tree (make-leaf `B 2) (make-code-tree (make-leaf `D 1) (make-leaf `C 1)))))

(def sample-message `(0 1 1 0 0 1 0 1 0 1 1 1 0))



(deftest encode-test
  ;;(is (= sample-message (encode `(A C B B A D A) sample-tree))
  )