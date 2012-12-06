;http://www.4clojure.com/problem/79

(fn path [col]
  (let [get_min_next (fn [current_lvl previous_pos]
    (let [data current_lvl next_pos (inc previous_pos)]
      (if (< (nth data previous_pos) (nth data next_pos))
        (nth data previous_pos)
        (nth data next_pos))
      ))
        data (reverse (seq col))
        ]

    (loop [result (first data) loopdata (rest data)]
      (if (empty? loopdata)
        (first result)
        (let [sum_for_each
              (map-indexed
                (fn [idx itm] (+ (get_min_next result idx) (nth (first loopdata) idx))) (first loopdata))]
          (recur sum_for_each (rest loopdata)))
        ))))