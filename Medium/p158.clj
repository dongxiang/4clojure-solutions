;http://www.4clojure.com/problem/158

(fn t158 [f]
  (fn [& list]
    (loop [accu (f (first list)) prams (rest list)]
      (if (empty? prams)
        accu
        (recur (accu (first prams)) (rest prams))
        ))
    )
  )