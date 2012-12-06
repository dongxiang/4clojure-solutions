; http://www.4clojure.com/problem/110

(fn [thevalue]
  (let [listname (fn [v]
    (loop [result [] currentkey (first v) currentcount 1 data (rest v)]
      (if (empty? data)
        (concat result [currentcount currentkey])
        (let [changed (not= (first data) currentkey)]
          (recur (if changed
                   (concat result [currentcount currentkey])
                   result)
            (if changed (first data) currentkey)
            (if changed 1 (inc currentcount))
            (rest data)
            )))))]
    (iterate listname (listname thevalue))))