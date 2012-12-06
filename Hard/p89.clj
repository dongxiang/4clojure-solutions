;http://www.4clojure.com/problem/89

(fn graphTour [col]
  (let [connected? (fn [chain-seq vb]
    (let [h (first (first chain-seq)) t (last (last chain-seq))]
      (or (= h (first vb))
        (= h (second vb))
        (= t (first vb))
        (= t (second vb)))))

        find_next_edge (fn [v subcol]
      (filter  #(first %)  (map (fn [v1] [(connected? v v1) v1 ] )  subcol)))

        visit-graph (fn visit-graph [chain-seq rest-set]
      (if (empty? rest-set)
        chain-seq
        (let [next_chain_tuple (find_next_edge  chain-seq rest-set)]
          (if (empty? next_chain_tuple)
            []
            (loop [possible_tuple (first next_chain_tuple) data (rest next_chain_tuple) ]
              (let [possible_chain (visit-graph
                (conj chain-seq (second  possible_tuple))
                (disj rest-set   (second possible_tuple)  )    )]
                (if (and (empty? data) (empty? possible_chain))
                  []
                  (if (not (empty? possible_chain))
                    possible_chain
                    (recur (first data) (rest data))
                    ))
                ))))))


        ]
    (= (count (visit-graph [(first col)] (set (rest col))))  (count col) (count (set col)) )
    )


  )