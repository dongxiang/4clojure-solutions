;http://www.4clojure.com/problem/65

(fn p65 [col]
  (let [v (empty col)]
    (if (get (conj v [:test :test1 ]) :test )
      :map
      (cond
             (= (count (conj v :testv :testv )) (count (conj v :testv :testv :testv :testv ))) :set
             (= (first (conj v :testv :testv1 )) :testv1 ) :list
             (= (last (conj v :testv :testv1 )) :testv1 )  :vector
             :else :no )))
  )