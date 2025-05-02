(defn rec-func [func] (func) (rec-func func))

(defn main [] 
    (let [msg (read)]
        (rec-func #(println msg))))

(main)
