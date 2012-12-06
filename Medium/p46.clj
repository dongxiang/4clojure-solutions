;http://www.4clojure.com/problem/46

(fn rf [f]
  (fn x [& params]
    (apply f (reverse params))
    ))