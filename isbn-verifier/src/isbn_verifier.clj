(ns isbn-verifier)
(use '[clojure.string :as str])

(defn isbn-str-to-digits
      [isbn]
      (map #(Character/digit % 10) (str (read-string (str/replace isbn "-" "")))))

(defn isbn-x-str-to-digits
      [isbn]
      (map #(Character/digit % 10) (str (read-string (join "" (drop-last (str/replace isbn "-" "")))))))



(defn isbn?
      [isbn]
      (if (re-matches #"\d\-?\d{3}\-?\d{5}\-?\d" isbn)
          (= 0 (mod (reduce + (map * (range 10 0 -1) (isbn-str-to-digits isbn))) 11))
          (if (re-matches #"\d\-?\d{3}\-?\d{5}\-?X" isbn)
              (= 0 (mod (+ 10 (reduce + (map * (range 10 1 -1) (isbn-x-str-to-digits isbn )))) 11))
              false)))

(defn -main
      []
      (println (isbn? "3598215088"))
      (println (isbn? "359821508X"))
      (println (isbn? "359821508A"))
      (println (isbn? "3-598-21508-8"))
      (println (isbn? "3-598-21507-X")))
