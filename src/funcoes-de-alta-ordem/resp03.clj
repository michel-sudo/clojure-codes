(defn conta ([operacao valor] 
    (println valor)
    (conta operacao (operacao valor)))
    ([] (conta #(+ % 1) 0)))

(conta)
