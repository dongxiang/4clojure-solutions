;http://www.4clojure.com/problem/86
(fn [x]
  (loop [n x]
    (cond
      (= n 1) true
      (= n 2) false
      (= n 3) false
      (= n 4) false
      (= 5 n) false
      (= 6 n) false
      (= 7 n) true
      (= 8 n) false
      (= 9 n) false
      :else (recur ((fn [m]
                      (loop [sum 0 r (quot m 10) module (mod m 10)]
                        (if (= r 0)
                          (+ sum (* module module))
                          (recur (+ sum (* module module)) (quot r 10) (mod r 10))
                          )
                        )
                      ) n))
      )
    )
  )