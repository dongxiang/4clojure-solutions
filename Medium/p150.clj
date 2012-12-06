;; http://www.4clojure.com/problem/150
;; It's stupid to implement function such as pow, parse. But seems the java parseInt will cause timeout error.


(fn p150 [n]
  (let [tempstr (seq (str n))
        len (count tempstr)
        isPal (= tempstr (reverse tempstr))
        mid (if (even? len) (/ len 2) (/ (inc len) 2))
        halfStr (take mid tempstr)
        pow (fn pow [n] (loop [acc 1 cnt n]
                          (if (zero? cnt) acc
                            (recur (* acc 10) (dec cnt))
                            )))
        half (int (quot n (pow (if (odd? len) (dec mid) mid))))
        newHalf (seq (str (inc half)))
        lengthChanged (not= mid (count newHalf))

        encode (fn encode [k] (let [m {\0 0, \1 1, \2 2,\3 3, \4 4, \5 5, \6 6 ,\7 7, \8 8, \9 9}]
                                (get m k)
                                ))

        parse (fn parse [cols] (reduce #(+ (* % 10) %2) (map encode cols)))

        newpal (parse (if (odd? len)
                        (concat halfStr (reverse (drop-last halfStr)))
                        (concat halfStr (reverse halfStr))
                        ))
        nextPal
        (
          cond
          (< n 9) n
          (= n 9) 11
          :else (if (> newpal n) newpal (parse
                                          (if (or lengthChanged (odd? len))
                                            (concat newHalf (reverse (drop-last newHalf)))
                                            (concat newHalf (reverse newHalf))
                                            ))))
        ]

    (cons (if isPal n nextPal) (lazy-seq (p150 (if isPal (inc n) (inc nextPal)))))

    )
  )