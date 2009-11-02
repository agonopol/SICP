(ns sicp.1.3.1_36
  (:use clojure.test
   :require clojure.contrib.generic.math-functions))


(defn fixed-point [f g]
      (let [close-enough? (fn [v1 v2]
                            (< (abs (- v1 v2)) 0.00001))
            fixed-iter (fn [guess]
                 (let [next (f guess)]
                   (println next)
                   (if (close-enough? guess next)
                       next
                       (recur next))))]
        (fixed-iter g)))

(println (fixed-point cos 1.0))