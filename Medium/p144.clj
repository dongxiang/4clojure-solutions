; http://www.4clojure.com/problem/144

(fn p144 [v & f]
  (cons v (lazy-seq (apply p144 (cons  ((first f) v)  (conj  (vec (rest f)  )  (first f) )   ))))
  )