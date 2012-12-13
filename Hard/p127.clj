;; http://www.4clojure.com/problem/127

;; Note:
;; 1. Just ignore the case if there is a hole inside a triangle
;; 2. macro "for" could not be used here, see https://github.com/4clojure/4clojure/issues/211, then some workaround used

(defn lt [cols]
  (let [row-num (dec (count cols))
        col-num (loop [acc -1 cur (apply max cols)]
      (if (= 0 cur) acc
        (recur (inc acc) (quot cur 2))
        )
      )
        is-mine (fn [r c]
      (if (or (nil? r) (nil? c) (> c col-num) (> r row-num)) false
        (let [
               validate-v (bit-shift-left 1 (- col-num c))
               candidate-v (nth cols r)]
          (> (bit-and validate-v candidate-v) 0)
          ))
      )
        line-from (fn [r c fr fc] (if (is-mine r c)
                                    (loop [acc [] next-col (fc c) next-row (fr r) l 2]
                                      (if (or (> next-col col-num) (> next-row row-num) (not (is-mine next-row next-col)))
                                        acc
                                        (recur (concat acc [{:r1 r :c1 c :r2 next-row :c2 next-col :l l :fr fr :fc fc}])
                                          (fc next-col)
                                          (fr next-row)
                                          (inc l))
                                        )
                                      )
                                    [])
      )

        mix-cols (fn [col1 col2] (mapcat (fn [e] (map (fn [e1] [e e1]) col1)) col2))
        all-line-from (fn [r c] (concat (line-from r c inc inc)
                                  (line-from r c inc identity)
                                  (line-from r c identity inc)
                                  (line-from r c inc dec)))

        size1 (fn [a b c] (let [mxl (max a b c) mnl (min a b c)] (/ (* (inc mxl) mnl) 2)))

        validate-tr (fn [l1 l2] (and (= (l1 :r2 ) (l2 :r2 )) (= (l1 :c2 ) (l2 :c2 ))
                                  (not (and (= (l1 :fr ) (l2 :fr )) (= (l1 :fc ) (l2 :fc ))))
                                  ))

        triangle-from-line (fn [line] (let [lines1 (all-line-from (line :r1 ) (line :c1 ))
                                            lines2 (all-line-from (line :r2 ) (line :c2 ))
                                            line-combines (mix-cols lines1 lines2)
                                            validate-combines (filter #(validate-tr (first %) (second %)) line-combines)
                                            ]
                                        (map #(size1 (line :l ) ((first %) :l ) ((second %) :l )) validate-combines)

                                        ))


        all-lines (flatten (let [points (mix-cols (range (inc row-num)) (range (inc col-num)))]
                             (mapcat #(apply all-line-from %) points)
                             ))

        all-size (flatten (map triangle-from-line all-lines))

        ]
    (if (empty? all-size) nil (apply max all-size))
    
    ))