;http://www.4clojure.com/problem/59

(fn [& col]
  (fn [& params] (map #(apply % params) col))
  )