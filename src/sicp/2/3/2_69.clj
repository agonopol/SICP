(ns sicp.2.3.2_69
  (:use clojure.test))

(defn leaf? [object]
  (= (first object) `leaf))

(defn weight-leaf [x] (nth x 2))


(defn weight [tree]
  (if (leaf? tree)
      (weight-leaf tree)
      (nth tree 3)))


(defn make-leaf [sym weight]
  (list `leaf sym weight))

(defn adjoin-set [x set]
  (cond (empty? set)
          (list x)
        (< (weight x) (weight (first set)))
          (cons x set)
        :else
          (cons (first set) (adjoin-set x (rest set)))))

(defn make-leaf-set [pairs]
  (if (empty? pairs)
    `()
     (let [pair (first pairs)]
          (adjoin-set (make-leaf (first pair) (first (rest pair)))
                      (make-leaf-set (rest pairs))))))



(defn symbol-leaf [x] (nth x 1))



(defn symbols [tree]
   (if (leaf? tree)
     (list (symbol-leaf tree))
     (nth tree 2)))

(defn make-code-tree [left right]
  (list
      left
      right
      (concat (symbols left) (symbols right))
      (+ (weight left) (weight right))))

(defn successive-merge [pairs]
  (cond (empty? pairs)
        `()
        (= 2 (count pairs))
        (make-code-tree (first pairs) (second pairs))
        :else (make-code-tree (make-code-tree (first pairs) (second pairs)) (successive-merge (rest (rest pairs))))))

(defn generate-huffman-tree [pairs]
  (successive-merge (make-leaf-set pairs)))

(println (generate-huffman-tree `((A 4) (B 2) (D 1) (C 1))))
(deftest generate-works
  ;(is (= sample-tree (generate-huffman-tree `((A 4) (B 2) (D 1) (C 1)))))
 )
