; http://www.4clojure.com/problem/125

(fn que [](let [q (char 34) sp (char 32) l ["(fn que []" "(let [q (char 34) sp (char 32)" "l [" "]]" "(apply str (concat (interpose sp (take 3 l)) (interpose sp (map (fn [s] (str q s q)) l)) (interpose sp (take 2 (drop 3 l))) [(last l)]))" "))"]] (apply str (concat (interpose sp (take 3 l)) (interpose sp (map (fn [s] (str q s q)) l)) (interpose sp (take 2 (drop 3 l))) [(last l)]))))
