;http://www.4clojure.com/problem/98

(fn [f s]
  (set (map #(set (second %)) (group-by f s)))
  )