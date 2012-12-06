;http://www.4clojure.com/problem/85
(fn [oldv]
  (let [v (vec oldv)
        genset (fn [n orgset]
      (loop [result [] cnt n time 0]
        (if (= cnt 0)
          result
          (recur (if (= (mod cnt 2) 1) (conj result (nth orgset time)) result) (quot cnt 2) (inc time)))))
        ]
    (set (map set (map #(genset % v) (range (Math/pow 2 (count v))))))
    )
  )