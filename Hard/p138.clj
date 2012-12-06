;http://www.4clojure.com/problem/138

(fn ss [s e]
  (let [number-str (apply str (take-while #(<= % e) (iterate #(* % %) s)))
        old-len (count number-str)
        sqrt-len (int (Math/ceil (Math/sqrt old-len)))
        real-len (* sqrt-len sqrt-len)
        whole-str (concat number-str (repeat (- real-len old-len) "*"))
        output-squre (- (* 2 sqrt-len) 1)
        start-pos [(if (even? sqrt-len) (- sqrt-len 2) (- sqrt-len 1)) (- sqrt-len 1)]
        smallest-sqrt (fn [v] (int (Math/floor (Math/sqrt v))))

        next-step-fy (fn [currntfx cnt]
      (if (and (> cnt 0) (= cnt (* (smallest-sqrt cnt) (smallest-sqrt cnt))))
        (if (= currntfx inc) dec inc)
        currntfx))

        next-step-fx (fn [currntfy cnt]
      (let [t1 (smallest-sqrt cnt)
            t2 (* (+ t1 1) t1)]
        (if (and (> cnt 0) (= cnt t2))
          (if (= currntfy inc) dec inc)
          currntfy)))
        all-valid-char ((fn []
                          (loop [char-map {} cnt 0 current-pos start-pos fx inc fy inc]
                            (if (= cnt real-len)
                              char-map
                              (let [nextfx (next-step-fx fx cnt)
                                    nextfy (next-step-fy fy cnt)]
                                (recur (assoc char-map current-pos (nth whole-str cnt))
                                  (inc cnt)
                                  [(nextfx (first current-pos)) (nextfy (second current-pos))]
                                  nextfx nextfy
                                  ))))))
        get-char (fn [pos] (get all-valid-char pos (char 32)))
        ]
    (map #(apply str %) (for [x (range output-squre)] (for [y (range output-squre)] (get-char [x y]))))

    )
  )