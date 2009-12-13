(ns sicp.2.3.2_70
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

(defn in [x l]
  (reduce (fn [a b] (or a b)) false (map (fn [y] (= y x)) l)))

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

(defn encode [message tree]
  (if (empty? message)
     `()
      (concat (encode-symbol (first message) tree)
            (encode (rest message) tree))))

(def tree (generate-huffman-tree `((A 2) (BOOM 1) (GET 2) (JOB 2) (NA 16) (SHA 3) (YIP 9) (WAH 1))))

(def song `(GET A JOB SHA NA NA NA NA NA NA NA NA GET A JOB SHA NA NA NA NA NA NA NA NA WAH YIP YIP YIP YIP YIP YIP YIP YIP YIP SHA BOOM))


(println (* 4 (count song)))
(println (count (encode song tree)))