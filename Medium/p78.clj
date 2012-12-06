;http://www.4clojure.com/problem/78

(fn p78
  ([f]
    (let [ret (f)]
      (if (fn? ret)
        (recur ret)
        ret)))

  ([f & args]
    (p78 #(apply f args)))
  )