(ns sicp.2.2.2_36
  (:use clojure.test))


(defn accumulate [op init seq]
  (if (empty? seq)
      init
     (op (first seq) (accumulate op init (rest seq)))))


(defn accumulate-n [op init seqs]
  (if (empty? (first seqs))
      nil
      (list* (accumulate op init (map (fn [x] (first x)) seqs))
             (accumulate-n op init (map (fn [x] (rest x)) seqs)))))

(deftest accum-n-tests
  (are [expression expected] (= expression expected)
    (list 22 26 30) (accumulate-n + 0 (list (list 1 2 3) (list 4 5 6) (list 7 8 9) (list 10 11 12)))
    ))