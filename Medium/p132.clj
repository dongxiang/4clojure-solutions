; http://www.4clojure.com/problem/132

(fn p132 [f s col]
  (let [lz (fn lz [pv last_time_is_symbol data]
    (lazy-seq
      (if (empty? data)
        []
        (cons
          (if last_time_is_symbol
            (first data)
            (if (f pv (first data)) s (first data))
            )
          (lz
            (first data)
            (if last_time_is_symbol false (f pv (first data)))
            (if last_time_is_symbol (rest data) (if (f pv (first data)) data (rest data))))
          ))))
        ]
    (lz nil true col)))