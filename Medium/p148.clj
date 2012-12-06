; http://www.4clojure.com/problem/148
(fn p148 [a b c]
  (let [subfun
        (fn subfun [n m]
          (let [d (bigint (quot (dec n) m))]
            (/ (* m (* d (+ d 1))) 2)))
        ]
    (if (or (< a b) (< a b)) 0
      (- (+ (subfun a b) (subfun a c)) (subfun a (* b c)))
      )))