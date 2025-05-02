(defn conta [] 
    (loop [valorAtual 0]
        (println valorAtual)
        (recur (inc valorAtual))))

(conta)

# Nessa situação temos uma recursão de cauda, 
# logo com a estrutura loop recur,podemos realizar uma recursão muito 
# extensa sem estourar a pilha de execução.