;http://www.4clojure.com/problem/101

(fn levenshtein [c1 c2]
  (let [m (count c1) n (count c2)
        lv-dis (fn [mtx-for-last newchar newchar-pos thestr]
      (loop [result [newchar-pos]
             data   thestr
             cnt 1 ]
        (if (empty? data)
          result
          (let [char-to-compare (first data)]
            (if (= newchar char-to-compare)
              (recur (conj result (nth mtx-for-last (dec cnt)))
                (rest data)
                (inc cnt))
              (recur (conj result
                       (inc (min  (nth mtx-for-last (dec cnt))
                              (nth result  (dec cnt))
                              (nth mtx-for-last  cnt))))
                (rest data)
                (inc cnt)))))))
        ]
    (loop [mtx (range (inc n)) data c1 cnt 1]
      (if (empty? data)
        (last mtx)
        (let [c (first data)]
          (recur (lv-dis mtx c cnt c2) (rest data) (inc cnt)))  ))))