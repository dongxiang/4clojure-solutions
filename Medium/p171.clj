;; http://www.4clojure.com/problem/171

(fn p171 [col]
  (let [sorted-col (sort col)]
    (loop [accu [] start (first sorted-col) end (first sorted-col) subcol (rest sorted-col)]
      (if (empty? subcol)
        (if (nil? start) accu (conj accu [start end]))
        (cond
          (= end (first subcol)) (recur accu start end (rest subcol))
          (= (inc end) (first subcol)) (recur accu start (inc end) (rest subcol))
          :else (recur (conj accu [start end]) (first subcol) (first subcol) (rest subcol))
          )
        )
      )))