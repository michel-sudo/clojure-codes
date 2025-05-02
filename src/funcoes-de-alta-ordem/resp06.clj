(defn conta [limite] (doseq [valorAtual (range limite)] (println valorAtual)))

(conta (inc (read)))