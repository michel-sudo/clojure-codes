(defn conta-recursivo [operacao num] 
    (println num)
    (conta-recursivo operacao (operacao num)))

(defn conta [] (conta-recursivo #(+ % 1) 0))

(conta)