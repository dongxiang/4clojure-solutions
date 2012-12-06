;http://www.4clojure.com/problem/43

(fn [col n]
  (map (fn [v] (map second (second v)))
    (group-by first (map-indexed (fn [idx itm] [(mod idx n) itm]) col)))
  )