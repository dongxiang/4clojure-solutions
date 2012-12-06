;http://www.4clojure.com/problem/54

(fn [n col]
  (let [indexcol (map-indexed (fn [idx itm] [(quot idx n) itm]) col)]
    (filter #(= (count %) n) (map (fn [v] (map second (second v))) (group-by first indexcol))
      ))
  )