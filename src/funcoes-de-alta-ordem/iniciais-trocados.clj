(defn pega-iniciais-invertido [lista] ([(second lista), (first lista)]))
(defn iniciais-trocados [lista] ( #(conj (pega-iniciais-invertido lista) %) lista))

(assert (= (iniciais-trocados '(1 2 3 4)) '(2 1 3 4)))
(assert (= (iniciais-trocados '(1 2)) '(2 1)))
