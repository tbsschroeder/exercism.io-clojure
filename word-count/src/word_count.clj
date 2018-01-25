(ns word-count)
(require '[clojure.string :as str])

(defn rm-symbols
      [words]
      (str/replace words #"[\.:,;\-_!\"§$%&/\(\)=?^@<>]" ""))

(defn rm-double-whites
      [words]
      (str/replace words #"\s\s+" " "))

(defn word-count
      [words]
      (frequencies (str/split (str/lower-case (rm-double-whites (rm-symbols words))) #" ")))