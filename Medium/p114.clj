;http://www.4clojure.com/problem/114
(fn p114 [n pred coll]
  (lazy-seq
    (when-let [s (seq coll)]
      (let [m (if (pred (first s)) (dec n) n)]
        (when (or (> m 0) (not (pred (first s))))
          (cons (first s)
            (p114 m pred (rest s))))))))