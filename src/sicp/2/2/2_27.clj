(ns sicp.2.2.2_27
  (:use clojure.test))

(defn deepreverse [x]
  (let [dr (fn [l r]
    (if (empty? l)
    r
    (if (list? (first l))
        (recur (rest l) (conj r (deepreverse (first l))))
        (recur  (rest l) (conj r (first l))))))]
    (dr x (list))))

(deftest reversethese
  (are [expression expected] (= expression expected)
    (list 1 2 3 4) (deepreverse (list 4 3 2 1))
   (list 1 2 (list 1 2 3 4) 3 4) (deepreverse (list 4 3 (list 4 3 2 1) 2 1))))