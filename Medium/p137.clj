; http://www.4clojure.com/problem/137

(fn [v base]
  (if (= v 0) [0]
    (reverse (loop [result [] restv v]
               (if (= restv 0)
                 result
                 (recur (conj result (mod restv base)) (quot restv base))
                 )))))