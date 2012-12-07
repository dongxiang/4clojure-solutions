; http://www.4clojure.com/problem/168

(defn im [f & cols]
  (let [[m n] (if (empty? cols) [0 0] (take 2 cols))
        [s t] (if (or (empty? cols)  (not= 4 (count cols) )  ) [-1 -1] (take-last 2 cols))
        make-inner (fn make-inner [l c]
                    (lazy-seq (cons (f l c)  (make-inner l (inc c)))))
        make-outter (fn make-outter [l1 c1]
                        (lazy-seq (cons (make-inner l1 c1)  (make-outter (inc l1) c1))))
        ]
    (if (> s 0)
      (take s (map #(take t %)  (make-outter m n)  ))
      (make-outter m n)
      ))
  )