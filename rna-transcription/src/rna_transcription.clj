(ns rna-transcription)
(require '[clojure.string :refer [join]])

(defn replace-dna [c]
      (cond
            (= c \G) \C
            (= c \C) \G
            (= c \T) \A
            (= c \A) \U
            :else (throw (AssertionError. "Wrong input."))))

(defn to-rna
      [dna]
      (join "" (map replace-dna dna)))

(defn -main
      "This should be pretty simple."
      []
      (println (to-rna "C"))
      (println (to-rna "G"))
      (println (to-rna "A"))
      (println (to-rna "T"))
      (println (to-rna "ACGT"))
      (println (to-rna "GGTC"))
      (println (to-rna "TTAA")))