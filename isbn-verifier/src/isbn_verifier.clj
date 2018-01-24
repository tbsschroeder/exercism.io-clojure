(ns isbn-verifier)
(use '[clojure.string :as str])

(defn digits [number] (map #(Character/digit % 10) (str number)))

(defn isbn_bak?
      [isbn]
      (if (= 10 (count (str/replace isbn "-" "")))
        (if (= "X" (nth (str/replace isbn "-" "") 9))
          (= 0 (mod (+ 10 (reduce + (map * (range 10 1 -1) (digits (read-string (join "" (drop-last (str/replace isbn "-" "")))))))) 11))
          (= 0 (mod (reduce + (map * (range 10 0 -1) (digits (read-string (str/replace isbn "-" ""))))) 11)))))


(defn isbn?
      [isbn]
      (if (re-matches #"[0-9]\-?[0-9]{3}\-?[0-9]{5}\-?[0-9]" isbn)
          (= 0 (mod (reduce + (map * (range 10 0 -1) (digits (read-string (str/replace isbn "-" ""))))) 11))
          (if (re-matches #"[0-9]\-?[0-9]{3}\-?[0-9]{5}\-?X" isbn)
              (= 0 (mod (+ 10 (reduce + (map * (range 10 1 -1)
                                               (digits (read-string (join "" (drop-last (str/replace isbn "-" "")))))))) 11))
              false)))

(defn -main
      []
      (println (isbn? "3598215088"))
      (println (isbn? "359821508X"))
      (println (isbn? "359821508A"))
      (println (isbn? "3-598-21508-8"))
      (println (isbn? "3-598-21507-X")))
