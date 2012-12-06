;http://www.4clojure.com/problem/56

(fn [v]
  (map first (sort-by last (let [indexedv (map-indexed (fn [idx itm] [itm idx]) v)]
                             (loop [result {} col indexedv]
                               (if (empty? col)
                                 result
                                 (recur (if (contains? result (first (first col)))
                                          result
                                          (conj result (first col)))
                                   (rest col))
                                 ))))))