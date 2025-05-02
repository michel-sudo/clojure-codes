(ns snake
  (:import [java.io BufferedReader InputStreamReader]))

(def directions
  {\w {:x 0 :y -1}
   \s {:x 0 :y 1}
   \a {:x -1 :y 0}
   \d {:x 1 :y 0}})

(def opposite-direction
  {\w \s, \s \w, \a \d, \d \a})

(defn random-food [width height snake]
  (let [food {:x (rand-int width)
              :y (rand-int height)}]
    (if (some #(= % food) snake)
      (recur width height snake)
      food)))

(defn init-state [width height]
  {:board-size {:width width :height height}
   :snake [{:x (quot width 2) :y (quot height 2)}]
   :food (random-food width height [])
   :direction {:x 1 :y 0}})

(defn render [state]
  (let [{:keys [board-size snake food]} state
        {:keys [width height]} board-size
        snake-set (set snake)]
    (print (str (char 27) "[H" (char 27) "[2J")) ;; limpa terminal
    (doseq [y (range height)]
      (doseq [x (range width)]
        (cond
          (= {:x x :y y} food) (print "◉")
          (some #(= {:x x :y y} %) snake) (print "0")
          :else (print "·")))
      (println))))

(defn update-state [state]
  (let [{:keys [snake direction food board-size]} state
        head (first snake)
        new-head {:x (+ (:x head) (:x direction))
                  :y (+ (:y head) (:y direction))}
        wall? (or (< (:x new-head) 0)
                  (>= (:x new-head) (:width board-size))
                  (< (:y new-head) 0)
                  (>= (:y new-head) (:height board-size)))
        self? (some #(= new-head %) snake)
        ate? (= new-head food)
        new-snake (if ate?
                    (cons new-head snake)
                    (cons new-head (butlast snake)))
        new-food (if ate?
                   (random-food (:width board-size) (:height board-size) new-snake)
                   food)]
    (if (or wall? self?)
      (do (println "Game Over!") (System/exit 0))
      (assoc state :snake new-snake :food new-food))))

(defn read-key []
  (let [rdr (BufferedReader. (InputStreamReader. System/in))]
    (.read rdr)))

(defn game-loop []
  (let [state (atom (init-state 20 20))
        last-key (atom \d)]
    (future
      (while true
        (let [key (char (read-key))]
          (when (= key \u0003) (System/exit 0))
          (when (and (contains? directions key)
                     (not= key (opposite-direction @last-key)))
            (swap! state assoc :direction (directions key))
            (reset! last-key key)))))
    (while true
      (swap! state update-state)
      (render @state)
      (Thread/sleep 200))))

(game-loop)

