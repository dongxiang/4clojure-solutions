; http://www.4clojure.com/problem/115

(fn p115 [x]
  (let [col (map (fn [x] (- (int x) 48)) (str x))
        total_len (count col)
        half_len (if (odd? total_len) (quot (+ total_len 1) 2) (/ total_len 2))
        ]
    (= (reduce + (take half_len col))
      (reduce + (drop (- total_len half_len) col))
      )
    )
  )