;http://www.4clojure.com/problem/92

(fn rrn [col]
  (let [str-symbol-map {"M" :m ,"D" :d, "C" :c , "L" :l ,"X" :x "V" :v "I" :i}
        symbo-v-map {:m 1000 , :d , 500 :c 100, :l 50 , :x 10 :v 5 :i 1}
        to-symbol (fn [c] (get str-symbol-map (str c)))
        parse-roma (fn [col]
      (let [symbol-list (reverse col)]
        (loop [result (symbo-v-map (first symbol-list)) lastv (symbo-v-map (first symbol-list)) data (rest symbol-list)]
          (let [current-v (symbo-v-map (first data))]
            (if (empty? data)
              result
              (recur (if (< current-v lastv) (- result current-v) (+ result current-v))
                current-v
                (rest data)
                ))))))
        ]
    (parse-roma (map to-symbol col)))
  )