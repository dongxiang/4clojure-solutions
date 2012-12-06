;http://www.4clojure.com/problem/116

(fn p116 [n]
  (let [pn? (fn [v]
    (if (< v 2) false
      (let [rt (int (Math/sqrt v)) tmp (drop 2 (range (inc rt)))]
        (= (count tmp) (count (filter #(not= 0 %) (map #(mod v %) tmp))))
        )))
        next-pn (fn [v direction]
      (loop [cnt (direction v)]
        (if (pn? cnt)
          cnt
          (recur (direction cnt))
          )))
        ]
    (if (and (pn? n) (not= 2 n))
      (= (+ n n) (+ (next-pn n inc) (next-pn n dec)))

      false
      )
    )
  )
