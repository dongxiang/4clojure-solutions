;http://www.4clojure.com/problem/58

(fn [& col]
  (fn [& params]
    (loop [flist (rest (reverse col)) newparams (apply (first (reverse col)) params)]
      (if (empty? flist)
        newparams
        (recur (rest flist) ((first flist) newparams)))
      )))