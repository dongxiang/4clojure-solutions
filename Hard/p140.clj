;http://www.4clojure.com/problem/140

(fn kmap [col]
  (let [subset (fn [col1] (reduce concat (for [m col1] (for [n (disj col1 m)] [m n]))))
        check_symbol (fn [s1 s2]
      (let [symbol_map {'A 'a 'a 'A 'B 'b 'b 'B 'C 'c 'c 'C 'D 'd 'd 'D}]
        (= s1 (get symbol_map s2))
        )
      )
        combine_set (fn [s1 s2]
      (let [comset (clojure.set/intersection s1 s2)
            rest_s1 (clojure.set/difference s1 comset)
            rest_s2 (clojure.set/difference s2 comset)
            ]
        (if (and (= 1 (count rest_s1)) (= 1 (count rest_s2)) (check_symbol (first rest_s1) (first rest_s2)))
          comset
            #{}
          )))
        combine_sets (fn [col1]
      (set (filter #(not-empty %) (map (fn [[s1 s2]] (combine_set s1 s2)) (subset col1))))
      )
        ; remove all the super set of s2 from s1
        filter_super_set (fn [s1 s2]
      (loop [result #{} data s1])
      (if (empty? s1)
        s1
        (set (filter (fn [elt] (not (some #(clojure.set/superset? elt %) s2))) s1))
        ))

        get-possible-combine (fn [col1]
      (loop [result #{} data col combined (combine_sets data)]
        (let [minimumed (clojure.set/intersection data combined)
              filtered (filter_super_set result combined)
              ]
          (if (empty? data)
            result
            (recur (clojure.set/union minimumed filtered) combined (combine_sets data))
            )
          ))
      )
        possible-combine (get-possible-combine col)
        ]
    (if (= 0 (count possible-combine))
      col
      (loop [result #{} data col combines possible-combine]
        (if (empty? data)
          result
          (recur (conj result (first combines)) (filter_super_set data (conj #{} (first combines))) (rest combines))
          ))
      )

    ))