(ns sicp.week_one
  (:use clojure.test))

; Week One: 1.1 - 1.8 - http://groups.google.com/group/wizardbookstudy/web/weekly-assignments

; 1.1  The Elements of Programming - http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-10.html

; Exercise 1.1.  Below is a sequence of expressions. 
; What is the result printed by the interpreter in response to each expression? 
; Assume that the sequence is to be evaluated in the order in which it is presented.

(deftest expressions
  (are [expression expected] (= expression expected)
    10                                  10
    (+ 5 3 4)                           12
    (- 9 1)                             8
    (/ 6 2)                             3
    (+ (* 2 4) (- 4 6))                 6

    (def a 3)                           #'sicp.week_one/a
    (def b (+ a 1))                     #'sicp.week_one/b

    (+ a b (* a b))                     19
    (= a b)                             false
    
    (if (and (> b a) (< b (* a b)))
      b
      a)                                4

    (cond (= a 4) 6
          (= b 4) (+ 6 7 a)
          :else 25)                     16

    (+ 2 (if (> b a) b a))              6

    (* (cond (> a b) a
             (< a b) b
             :else -1)
       (+ a 1))                         16
    ))
