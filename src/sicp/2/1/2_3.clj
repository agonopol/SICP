(ns sicp.2.1.2_3
  (:use clojure.test
    :require clojure.contrib.generic.math-functions))


(defn make-point [x y]
  (list x y))

(defn get-x [point]
  (first point))

(defn get-y [point]
  (last point))

(defn make-rec [point-a point-b]
  (list point-a point-b))

(defn area [rec]
  (* (abs (- (get-x (first rec)) (get-x (last rec))))
     (abs (- (get-y (first rec)) (get-y (last rec))))))

(defn perminiter [rec]
  (* (+ (abs (- (get-x (first rec)) (get-x (last rec))))
        (abs (- (get-y (first rec)) (get-y (last rec)))))
      2))


(println (area (make-rec (make-point 0 0) (make-point 5 5))))
(println (perminiter (make-rec (make-point 0 0) (make-point 5 5))))



(defn make-rec-line [x y]
  (list (abs (- (get-x  x) (get-x  y)))
        (abs (- (get-y  x) (get-y  y)))))

(defn rec-line-area [rec]
  (* (first rec) (last rec)))

(defn rec-line-per [rec]
  (* (+ (first rec) (last rec)) 2))

(println (rec-line-area (make-rec-line (make-point 0 0) (make-point 5 5))))
(println (rec-line-per (make-rec-line (make-point 0 0) (make-point 5 5))))