; http://www.4clojure.com/problem/112

(fn p112 [v col]
  (let [check_sum (fn check_sum [v current_sum data]
    (loop [new_sum current_sum current_v (first data) restdata (rest data) result []]
      (if (empty? restdata)
        (if (sequential? current_v)
          (concat result [(check_sum v new_sum current_v)])
          (if (> (+ current_v new_sum) v)
            result
            (conj result current_v)))
        (if (sequential? current_v)
          (concat result [(check_sum v new_sum current_v)])
          (if (> (+ current_v new_sum) v)
            result
            (recur (+ current_v new_sum) (first restdata) (rest restdata) (conj result current_v))
            )))))]
    (check_sum v 0 col)
    ))