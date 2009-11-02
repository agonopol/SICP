(ns sicp.1.2.1_12
  (:use clojure.test))


(defn expand-row [row]
  (cond (> (count row) 2)
        (list*  (+ (first row) (second row)) (expand-row (rest row)))
        (= (count row) 2)
        (list (+ (first row) (second row)))))


(defn p-triangle-helper [n row]  
  (if (not (= n 0))
    (let [iter (fn [n row]
      (println row)
      (p-triangle-helper (- n 1) (concat (list* 1 (expand-row row)) (list 1))))]
      (iter n row))))

(defn p-triangle
  [n]
  (println (list 1))
  (p-triangle-helper (- n 1) (list 1 1)))

(p-triangle 5)


