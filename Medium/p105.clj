;http://www.4clojure.com/problem/105

(fn [v]
  (let [iskey (fn [v] (= clojure.lang.Keyword  (class v)) )]
    (loop [result {} currentkey (first v) currentv [] data (rest v) ]
      (if (empty? data)
        (if currentkey (conj result [currentkey currentv]) result)
        (let [next_is_key (iskey (first data))]
          (recur (if next_is_key
                   (conj result [currentkey currentv])
                   result)
            (if next_is_key  (first data) currentkey)
            (if next_is_key  [] (conj currentv (first data) ))
            (rest data)
            ))))))