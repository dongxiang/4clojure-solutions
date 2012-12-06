;http://www.4clojure.com/problem/106

(fn nm [n1 n2]
  (let [newvalue (fn [oldvalue] (if (even? oldvalue)
                                  [(/ oldvalue 2) (+ oldvalue 2) (* oldvalue 2)]
                                  [(+ oldvalue 2) (* oldvalue 2)]
                                  ))

        find-path (fn find-path [steps lastvalues]
      (if (some #(= n2 %) lastvalues)
        steps
        (find-path (inc steps) (mapcat newvalue lastvalues))
        ))
        ]
    (find-path 1 [n1])
    )
  )