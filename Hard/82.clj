;http://www.4clojure.com/problem/82

(fn chains [col]
  (let [chain? (fn [v1 v2]
    (let [c1 (count v1) c2 (count v2) str1 (if (< c1 c2) v2 v1) str2 (if (< c1 c2) v1 v2)]
      (if (<= (- (count str1) (count str2)) 1)
        (loop [char1 (first str1) char2 (first str2) substr1 (rest str1) substr2 (rest str2) mismatch 0 shifted false]
          (let [same-char (= char1 char2)]
            (if (empty? substr1)
              (< mismatch 2)
              (if same-char
                (recur (first substr1) (first substr2) (rest substr1) (rest substr2) mismatch shifted)
                (if (and (not= c1 c2) (not shifted))
                  (recur (first substr1) char2 (rest substr1) substr2 (inc mismatch) true)
                  (recur (first substr1) (first substr2) (rest substr1) (rest substr2) (inc mismatch) shifted)
                  )
                )
              )
            ))
        false
        )))

        has_chain? (fn [v subcol]
      (filter #(first %) (map (fn [v1] [(chain? v v1) v1]) subcol)))


        make-chain (fn make-chain [chain-seq rest-set]
      (if (empty? rest-set)
        chain-seq
        (let [next_chain_tuple (has_chain? (last chain-seq) rest-set)]
          (if (empty? next_chain_tuple)
            []
            (loop [possible_tuple (first next_chain_tuple) data (rest next_chain_tuple)]
              (let [possible_chain (make-chain
                (conj chain-seq (second possible_tuple))
                (disj rest-set (second possible_tuple)))]
                (if (and (empty? data) (empty? possible_chain))
                  []
                  (if (not (empty? possible_chain))
                    possible_chain
                    (recur (first data) (rest data))
                    ))
                ))))))
        ]
    (not (empty? (filter #(= (count col) %) (map (fn [v] (count (make-chain [v] (disj col v)))) col))))

    )
  )