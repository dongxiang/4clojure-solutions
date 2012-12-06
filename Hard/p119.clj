;http://www.4clojure.com/problem/119

(fn Tic-Tac-Toe [nextmove col]
  (let [cell-vaule (fn [n m] (nth (nth col n) m))
        h-line (for [x (range 3) ]  [[x 0] [x 1] [x 2]])
        v-line (for [y (range 3) ]  [[0 y] [1 y] [2 y]])
        d-line [  [[0 0] [1 1] [ 2 2] ]    [[2 0] [1 1] [0 2]]  ]
        all-lines (concat h-line  v-line d-line)


        check-move (fn [theline]
      (let [line-values (map-indexed (fn [idx item] [idx (cell-vaule (first item) (last item))])  theline )
            empty-pos (count (filter #(= :e (last %)) line-values))
            used-pos  (count (filter #(= nextmove  (last %)) line-values))]

        (if (and  (= 1 empty-pos) (= 2 used-pos) )
          (nth theline (first (first (filter #(= :e (last %)) line-values)) ))
          nil)))]

    (set (filter identity (map check-move all-lines))) ))