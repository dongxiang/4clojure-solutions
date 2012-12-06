;http://www.4clojure.com/problem/80

(fn [v]
  (let [possibledv (take (dec v) (map inc (range v)))]
    (= v (reduce + (filter #(= (mod v %1) 0) possibledv)))
    )
  )