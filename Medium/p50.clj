;http://www.4clojure.com/problem/50

(fn [v]
  (map second (group-by class v))
  )