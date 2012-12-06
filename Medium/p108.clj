;http://www.4clojure.com/problem/108

(fn ([col] (first col))
  ([col0 & col]
    (loop [itm (first col0) item-data (rest col0) col-data col]
      (let [new-col-data (map #(drop-while (fn [v] (< v itm)) %) col-data)
            is-find (every? #(= itm (first %)) new-col-data)]
        (if is-find
          itm
          (recur (first item-data) (rest item-data) new-col-data)
          )))))