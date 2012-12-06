; http://www.4clojure.com/problem/117

(fn p117 [col]
  (let [row-num (count col) column-num (count (first col))
        all-cell (for [r (range row-num) c (range column-num)] [r c])
        M-pos (first (filter #(= 77 (int (get-in col %))) all-cell))
        C-pos (first (filter #(= 67 (int (get-in col %))) all-cell))
        possible-move (fn [[r c]]
      (let [surround [[r (inc c)] [r (dec c)] [(inc r) c] [(dec r) c]]
            valid-move (filter (fn [[r c]] (and (< -1 r row-num)
                                             (< -1 c column-num)
                                             (not= 35 (int (get-in col [r c]))))) surround)]
        valid-move))
        walk (fn [start-pos]
      (loop [all-steps (set [start-pos]) last-steps [start-pos]]
        (let [next-steps (mapcat possible-move last-steps)
              new-steps (clojure.set/difference (set next-steps) all-steps)
              ]
          (if (some #(= C-pos %) next-steps)
            true
            (if (empty? new-steps)
              false
              (recur (clojure.set/union all-steps new-steps) new-steps))
            ))))
        ]
    (walk M-pos)
    )
  )