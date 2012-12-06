;http://www.4clojure.com/problem/91

(fn
  connectivity [col]
  (let [find_connection (fn [rest-edges current-grah]
    (filter #(or (contains? current-grah (first %))
               (contains? current-grah (last %)))
      rest-edges))
        find_non_connection (fn [rest-edges current-grah]
      (filter #(and (not (contains? current-grah (first %)))
                 (not (contains? current-grah (last %))))
        rest-edges))]

    (loop [initset (set (first col))
           data (rest col)]
      (if (empty? data)
        (not (empty? initset))
        (let [connected-edges (find_connection data initset)
              non-connected-edges (find_non_connection data initset)]
          (if (empty? connected-edges)
            false
            (recur (reduce #(clojure.set/union %1 (set %2)) initset connected-edges)
              non-connected-edges
              )))))))