(ns reverse-string)

(defn reverse-string
      [s]
      (apply str (reverse s)))

(defn -main
      "This should be pretty simple."
      []
      (println (reverse-string "asd")))