; http://www.4clojure.com/problem/104
; and also check http://www.4clojure.com/problem/92
(fn p104 [n]
  (let [m (quot n 1000) c (quot (mod n 1000) 100) x (quot (mod n 100) 10) i (mod n 10)
        single-rrm (fn [v small middle end]
      (cond (< v 4) (vec (repeat v small))
        (= v 4) [small middle]
        (= v 5) [middle]
        (< 5 v 9) (concat [middle] (vec (repeat (- v 5) small)))
        (= v 9) [small end]
        ))]
    (reduce #(.concat %1 %2) "" (concat (single-rrm m "M" "" "") (single-rrm c "C" "D" "M") (single-rrm x "X" "L" "C") (single-rrm i "I" "V" "X"))
      )))