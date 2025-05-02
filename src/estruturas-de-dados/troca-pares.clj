(defn troca-pares3 [sequencia]
  (->> sequencia
       (partition 2 2 nil)  ; Divide em pares de 2 elementos
       (mapcat reverse)     ; Inverte cada par e concatena
       (filter some?)))     ; Remove nils se houver número ímpar de elementos

(assert (= (troca-pares3 [1 2 3 4]) [2 1 4 3]))
(assert (= (troca-pares3 [1 2 3]) [2 1 3]))
(assert (= (troca-pares3 [1]) [1]))
(assert (= (troca-pares3 []) []))