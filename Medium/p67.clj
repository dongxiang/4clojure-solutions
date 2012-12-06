;http://www.4clojure.com/problem/67

(fn [len]

  (loop [v 3 col [2]]
    (if (= (count col) len)
      col
      (recur (inc v)
        (if (loop [firstp (first col) restp (rest col)]
              (cond
                (= (mod v firstp) 0) false
                (and (> (mod v firstp) 0) (empty? restp)) true
                :else (recur (first restp) (rest restp))
                ))
          (conj col v)
          col
          )))))