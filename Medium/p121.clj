;http://www.4clojure.com/problem/121

(fn p121 [exp]
  (fn [col]
    (let [check_symbol (fn [s]
      (if (symbol? s)
        (cond (= (symbol "/") s) /
          (= (symbol "+") s) +
          (= (symbol "-") s) -
          (= (symbol "*") s) *
          :else (get col s))
        s))
          execute (fn execute [sub_exp]
        (loop [f (check_symbol (first sub_exp)) parameters [] data (rest sub_exp)]
          (let [firstp (first data)]
            (if (empty? data)
              (apply f parameters)
              (recur f (if (sequential? firstp)
                         (conj parameters (execute firstp))
                         (conj parameters (check_symbol firstp))
                         ) (rest data)
                )))))

          ]
      (execute exp)
      )
    )
  )