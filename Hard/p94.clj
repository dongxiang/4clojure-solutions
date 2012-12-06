;http://www.4clojure.com/problem/94

(fn life [col]
  (let [ h (count col) w (count (first col))
         all-cell (for [y (range h) ] (for [x (range w)] [x y] ) )
         neighbours-pos [-1 0 1]
         cell-vaule (fn [m n] (nth (nth col n) m))
         neighbours (fn [m n]
      (filter (fn [[x y]] (and (< -1 x w) (<  -1 y h) (not (and  (= x m ) (= n y ) )  ) ))
        (for [x neighbours-pos  y neighbours-pos] [(+ m x) (+ n y)])))
         next-cell-v (fn [m n]
      (let[neighbours-value (map (fn [[x y]] (cell-vaule x y) )  (neighbours m n)   )
           v (cell-vaule m n)
           life-num (count (filter #(= 35 (int %) ) neighbours-value))
           empty-num (count (filter #(= 32 (int %) ) neighbours-value))
           ]
        (if (= 35 (int v))
          (if (and (<= 2 life-num) (<= life-num 3)) "#" " ")
          (if (= life-num 3) "#" " "))))]

    (map (fn [row]
           (reduce #(.concat %1 %2) ""
             (map (fn [[x y]] (next-cell-v x y))  row) ))
      all-cell)
    ))