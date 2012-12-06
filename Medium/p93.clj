; http://www.4clojure.com/problem/93

(fn [v]
  (filter #(and (sequential? %) (not (sequential? (first %)))) (rest (tree-seq sequential? seq v))))