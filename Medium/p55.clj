;http://www.4clojure.com/problem/55

(fn [v]
  (let [col (group-by identity v)]
    (loop [result {} newcol col]
      (let [itm (first newcol)]
        (if (empty? newcol)
          result
          (recur (conj result [(first itm) (count (second itm))]) (rest newcol))
          )))))