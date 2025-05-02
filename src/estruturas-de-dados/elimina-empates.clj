(defn swap [nums x]
  (concat (take x nums) (cons (+ (nth nums x) 1) (drop (+ x 1) nums))))

(defn elimina-recur [nums x]
    (let [n2 (nth nums x) n1 (nth nums (- x 1))]
      (if (< (+ x 1) (count nums))
        ((if (= n1 n2)
           (elimina-recur (swap nums x) (+ x 1)))
         (elimina-recur nums (+ x 1))))))

(defn elimina-empates [nums]
  (elimina-recur nums 1))


(println (elimina-empates [1 1 2 2 3 3]))
