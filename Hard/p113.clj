;http://www.4clojure.com/problem/113

(fn p113 ([& col]
           (let [sorted-col (sort col)
                 deduce (fn deduce [col]
               (loop [result [] data col]
                 (if (empty? data)
                   result
                   (let [item (first data)]
                     (if (not (some #(= item %) result))
                       (recur (conj result item) (rest data))
                       (recur result (rest data))
                       )))))
                 insert-order-col (deduce col)
                 ]
             (reify clojure.lang.Seqable
               (toString [this] (apply str (interpose ", " sorted-col)))
               (seq [this] (seq insert-order-col))
               ))
           )
  ([] (reify clojure.lang.Seqable
        (toString [this] "")
        (seq [this] nil)))
  )