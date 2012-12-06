;http://www.4clojure.com/problem/73

(fn analysis-ttt [col]
  (let [cell-vaule (fn [m n] (nth (nth col n) m))
        h-line (for [x (range 3)] [[x 0] [x 1] [x 2]])
        v-line (for [y (range 3)] [[0 y] [1 y] [2 y]])
        d-line [[[0 0] [1 1] [2 2]] [[2 0] [1 1] [0 2]]]
        all-lines (concat h-line v-line d-line)
        check-line (fn [theline]
      (let [line-values (map (fn [[x y]] (cell-vaule x y)) theline)]
        (cond (every? #(= :o %) line-values) :o (every? #(= :x %) line-values) :x :else nil
          )))
        ]
    (first (filter identity (map check-line all-lines))))
  )