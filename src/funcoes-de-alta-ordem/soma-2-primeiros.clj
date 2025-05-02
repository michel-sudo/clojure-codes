(defn soma-2-primeiros [nums]
  (apply + (take 2 nums)))

(assert (= (soma-2-primeiros '(1 2)) 3))
(assert (= (soma-2-primeiros '(2)) 2))
(assert (= (soma-2-primeiros '()) 0))

(assert (= (soma-2-primeiros [1 2]) 3))
(assert (= (soma-2-primeiros [2]) 2))
(assert (= (soma-2-primeiros []) 0))
