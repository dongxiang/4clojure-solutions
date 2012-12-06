; http://www.4clojure.com/problem/131
(fn [& cop]
  (let [ps (fn [oldv]
    (let [v (vec oldv)
          genset (fn [n orgset]
        (loop [result [] cnt n time 0]
          (if (= cnt 0)
            result
            (recur (if (= (mod cnt 2) 1) (conj result (nth orgset time)) result) (quot cnt 2) (inc time)))))

          ]
      (set (map set (map #(genset % v) (drop 1 (range (Math/pow 2 (count v)))))))
      )
    )
        possiblesum (fn [oldset]
      (map #(reduce + 0 %) oldset)
      )

        ]
    (not (empty? (apply clojure.set/intersection (map set (map #(possiblesum (ps %)) cop)))))
    )

  )