;  http://www.4clojure.com/problem/75

(fn [v]
  (let [gcd (fn [x y]
    (loop [a (max x y) b (min x y)]
      (if (= b 0)
        a
        (recur b (mod a b)))))]
    (if (= v 1)
      1
      (count (filter #(= 1 (gcd % v)) (range v))
        ))))

