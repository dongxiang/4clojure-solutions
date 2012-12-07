; http://www.4clojure.com/problem/130

(defn tr [key tree]

  (let [allnodes (tree-seq seq? identity tree)
        haschild (fn [node] (some #(= key %) (flatten node)))
        node_parents (reverse (filter #(haschild %) allnodes))
        remove-node (fn [p c] (apply list (filter #(not= c %) p)))
        cleaned (map-indexed (fn [idx value]
                               (if (= 0 idx) value
                                 (remove-node value (nth node_parents (dec idx)))))
      node_parents)
        ]
    (loop [acc (last cleaned) r (drop-last cleaned)]
      (if (empty? r) acc
        (recur (concat (last r) (list acc)) (drop-last r))
        ))))

(println (tr 'a '(a)))

(println (tr 'e '(a (t (e))))) ;'(e (t (a))

(println (tr 'c
           '(a
              (b
                (c
                  (d)
                  (e))
                (f
                  (g)
                  (h)))
              (i
                (j
                  (k)
                  (l))
                (m
                  (n)
                  (o))))))
