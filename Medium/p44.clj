;http://www.4clojure.com/problem/44
(fn [x col]
  (let [h (mod x (count col))]
    (flatten (conj (take h col) (drop h col)))
    ))