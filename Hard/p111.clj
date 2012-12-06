;http://www.4clojure.com/problem/111

(fn corssword [str-to-match board]
  (let [sharp (char 35) underscore (char 95)
        clean-board (fn [col] (map #(filter (fn [c] (not= 32 (int c))) %) col))
        compact-boad (clean-board board)
        r-num (count compact-boad) c-num (count (first compact-boad))
        h-lines (for [r (range r-num)] (map (fn [v] [r v]) (range c-num)))
        v-lines (for [c (range c-num)] (map (fn [v] [v c]) (range r-num)))
        all-lines (concat h-lines v-lines)
        my-get-in (fn [bd [r c]] (nth (nth bd r) c))
        matchline (fn [line str-to-try]
      (loop [linedata line strdata str-to-try]
        (if (empty? strdata)
          (if (empty? linedata)
            true
            (= (my-get-in compact-boad (first linedata)) sharp))
          (if (empty? linedata) false
            (let [char-in-board (my-get-in compact-boad (first linedata))]
              (if (= char-in-board sharp)
                (recur (rest linedata) str-to-try)
                (if (or (= char-in-board underscore)
                      (= char-in-board (first strdata)))
                  (recur (rest linedata) (rest strdata))
                  false
                  )))))))]
    (< 0 (count (filter #(matchline % str-to-match) all-lines)))))