; http://www.4clojure.com/problem/60

(fn p60
  ([f coll]
    (lazy-seq
      (if-let [s (seq coll)]
        (p60 f (first s) (rest s))
        (list (f)))))
  ([f init coll]
    (cons init
      (lazy-seq
        (when-let [s (seq coll)]
          (p60 f (f init (first s)) (rest s)))))))