;http://www.4clojure.com/problem/53

(fn increasingSubSeq [col]
  (let [validate_col (fn [c] (if (< (count c) 2) [] c))]
    (loop [s1 [] s2 [(first col)] lastv (first col) data (rest col)]
      (if (empty? data)
        (if (< (count s1) (count s2))
          (validate_col s2)
          (validate_col s1))
        (let [is-inc (< lastv (first data))]
          (recur (if is-inc
                   s1
                   (if (< (count s1) (count s2))
                     s2
                     s1))
            (if is-inc (conj s2 (first data)) [(first data)])
            (first data)
            (rest data)))))))