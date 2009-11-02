(ns sicp.1.3.1_31
  (:use clojure.test))

(defn product [term a next b]
      (if (> a b)
          1
          (* a (product term (next a) next b))))

(defn prod-tail [term a next b]
     (println b)

     (let [prod-iter (fn [n result]
                      (if (> n b)
                        result
                        (recur (next n) (* result (term n)))))]
     (prod-iter a 1)))

(defn ident [x]
      x)

(defn fact [n]
  (product ident 1 inc n))

(defn fact-tail [n]
  (prod-tail ident 1 inc n))

(defn square [n]
  (* n n))

(defn pi [n]
  (let [pi-next (fn [n] (+ n 2))]

    (* 2 (/ (/ (prod-tail square 4 pi-next n) n) (prod-tail square 3 pi-next n)))))

(println (pi 10))

(deftest expressions
  (are [expression expected] (= expression expected)
   6 (fact 3)
   24 (fact 4)
   (fact 5) (fact-tail 5)
   ))
