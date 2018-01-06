(ns run-length-encoding)
(require '[clojure.string :as str])

(defn encode-helper
      [s]
      (if (< (count s) 2)
        (str (nth s 0))
        (str (count s) (nth s 0))))

(defn run-length-encode
      "encodes a string with run-length-encoding"
      [s]
      (apply str (map encode-helper (partition-by identity s))))

;; (defn decode-helper
;;       [s]
;;       (if (integer? (nth s 0))
;;         (str (apply str (repeat (nth s 0) (nth s 1))))
;;         (str (nth s 1))))

(defn decode-group [[_ n letter]]
      (str/join (repeat (Integer/parseInt n) letter)))

(defn run-length-decode
      "decodes a run-length-encoded string"
      [s]
      (str/replace s #"(\d{1,2})(.)" decode-group))


(defn -main
      "This should be pretty simple."
      []
      (println (partition-by identity "2A3B4CD"))
      (println (partition-by identity "12A3B4CDe5f"))
      (println (str/split "12A3B4CDe5f" #"[0-9]+"))
      (println (str/split "12A3B4CDe5f" #"\d+"))
      (println (partition 2 (flatten (partition-by identity "12A3B4CD")))))
