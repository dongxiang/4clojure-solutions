;http://www.4clojure.com/problem/77

(fn [col]
  (set (map #(set (second %)) (filter #(> (count (second %)) 1) (group-by #(sort (seq %)) col)))))