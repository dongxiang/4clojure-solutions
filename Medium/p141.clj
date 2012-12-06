;; http://www.4clojure.com/problem/141

(fn p141 [s]
  (let [card-suits-order {:spade 4 :diamond 3 :heart 2 :club 1}]
    (fn [col] (if (nil? s)
                (last (sort-by (fn [v] [(get card-suits-order (:suit v)) (:rank v)]) col))
                (last (sort-by (fn [v] [(if (= s (:suit v)) 1 -1) (:rank v)]) col))
                ))))