(ns sicp.2.1.2_2
  (:use clojure.test
    :require clojure.contrib.generic.math-functions))


(defn make-point [x y]
  (list x y))

(defn get-x [point]
  (first point))

(defn get-y [point]
  (last point))

(defn make-segment [start end]
  (list start end))

(defn start-segment [segment]
  (first segment))

(defn end-segment [segment]
  (last segment))

(defn mid-point [segment]
  (make-point (/ (+ (get-x (start-segment segment)) (get-x (end-segment segment))) 2)
    (/ (+ (get-y (start-segment segment)) (get-y (end-segment segment))) 2)))



(println (mid-point (make-segment (make-point 0 0) (make-point 4 4))))