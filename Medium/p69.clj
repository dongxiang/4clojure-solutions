;http://www.4clojure.com/problem/69

(fn [f & maps]
  (when (some identity maps)
    (let [
           merge-entry
          (fn [m e] (let [k (key e) v (val e)]
                      (if (contains? m k)
                        (assoc m k (f (get m k) v))
                        (assoc m k v))))
          merge2
          (fn [m1 m2]
            (reduce merge-entry (or m1 {}) (seq m2)))]
      (reduce merge2 maps))))