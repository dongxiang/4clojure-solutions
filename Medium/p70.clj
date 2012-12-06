;http://www.4clojure.com/problem/70


(fn [v]
  (let [newv (.replaceAll  v "[!.]" "" )]
    (sort #(compare (.toUpperCase %1 ) (.toUpperCase %2 )) (.split  newv " "))
    )
  )