(defn elemento-central [lista] (nth lista (quot (count lista) 2)))

(assert (= (elemento-central '(1 2 3)) 2))
(assert (= (elemento-central '(1 2 3 4)) 3))
(assert (= (elemento-central '(1)) 1))
