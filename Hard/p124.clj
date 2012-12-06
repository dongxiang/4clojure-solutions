;http://www.4clojure.com/problem/124

(fn ar [bd color]
  (let [com-color (if (= color 'b) 'w 'b)
        all-pos (for [x (range 4) y (range 4)] [x y])
        all-possible-pos (filter #(= 'e (get-in bd %)) all-pos)
        possible-line (fn [[x y]]
      (let [fx (if (< x 2) inc dec)
            fy (if (< y 2) inc dec)
            stepx (if (< x 2) (- 4 x) (inc x))
            stepy (if (< y 2) (- 4 y) (inc y))
            next-d-pos (fn [[x y]] [(fx x) (fy y)])
            x-line (map (fn [v] [x v]) (take stepy (iterate fy y)))
            y-line (map (fn [v] [v y]) (take stepx (iterate fx x)))
            d-line (take (min stepx stepy) (iterate next-d-pos [x y]))]
        (list x-line y-line d-line)))
        result-for-line (fn [line]
      (if (= (get-in bd (second line)) com-color)
        (loop [result #{} restline (rest line) hasvalue false]
          (if (empty? restline)
            (if hasvalue result #{})
            (if (= (get-in bd (first restline)) com-color)
              (recur (conj result (first restline)) (rest restline) hasvalue)
              (recur result (rest restline) (if hasvalue hasvalue (= (get-in bd (first restline)) color)))
              )))
          #{}
        ))
        move (fn [pos]
      (map result-for-line (possible-line pos)))
        ]

    (apply merge (filter identity (map (fn [pos] (let [rt (first (filter not-empty (move pos)))] (if rt {pos rt} nil))) all-possible-pos)))

    ))