cleanup() {
  stty sane
}

trap cleanup EXIT
stty -icanon -echo
clojure snake.clj

