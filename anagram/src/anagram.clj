(ns anagram)
(use '[clojure.string :as str])

(defn anagrams-for
      [word anagrams]
      (let [filters [#(not= (str/lower-case %)
                           (str/lower-case word))
                     #(= (frequencies(str/lower-case %))
                         (frequencies (str/lower-case word)))]]
        (into [] (filter (apply every-pred filters) anagrams))))


(defn -main
      []
      (println (anagrams-for "banana" ["banana"]))
      (println (anagrams-for "ant" ["nat"])))