;http://www.4clojure.com/problem/74

(fn [strv]
  (let [checkrt (fn [v]
    (let [rt (int (Math/sqrt v))]
      (= (* rt rt) v)))
        cs
        (fn cs [str]
          (map #(Integer/parseInt %) (.split str ","))
          )
        ]
    (reduce #(.concat %1 %2) "" (map str (interpose "," (filter checkrt (cs strv)))))
    ))