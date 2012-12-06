;http://www.4clojure.com/problem/46

(fn p46 [f]
  (fn x [& params]
    (apply f (reverse params))
    ))