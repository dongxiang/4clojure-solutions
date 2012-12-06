; http://www.4clojure.com/problem/84

(fn [col]
  (let [generate-pair (fn generate-pair [values]
    (if (= (count values) 2)
      (set [values])
      (clojure.set/union (set (for [x (rest values)] [(first values) x]))
        (generate-pair (rest values)))))
        merge-pair (fn merge-pair [init-v values]
      (loop [result init-v data values]
        (if (empty? data) result
          (let [itm (first data)]
            (cond (= (first itm) (last result)) (recur (conj result (last itm)) (rest data))
              (= (first result) (last itm)) (recur (concat itm (rest result)) (rest data))
              :else (recur result (rest data)))))))
        merge-all (fn merge-all [values]
      (set (map #(merge-pair % values) values)))
        ]
    (reduce clojure.set/union (map #(generate-pair %) (merge-all col)))
    )
  )
