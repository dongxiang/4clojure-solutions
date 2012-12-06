;http://www.4clojure.com/problem/102

(fn [s]
  (let [news (.split s "-")]
    (reduce str (cons (first news) (map #(str (.toUpperCase (str (first %1))) (reduce str (rest %1))) (rest news))))
    )
  )