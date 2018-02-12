(ns beer-song
  (:require [clojure.string :as string]))

(defn verse
      "Returns the nth verse of the song."
      [n]
      (cond
        (> n 2) (str (format "%s bottles of beer on the wall, %s bottles of beer.\nTake one down and pass it around, %s bottles of beer on the wall.\n" n n (dec n)))
        (> n 1) (str (format "%s bottles of beer on the wall, %s bottles of beer.\nTake one down and pass it around, %s bottle of beer on the wall.\n" n n (dec n)))
        (> n 0) (str (format "%s bottle of beer on the wall, %s bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n" n n))
        :else (str "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end] (string/join "\n" (map verse (range start (- end 1) -1)))))




(defn -main
      "This is da main"
      []
      (print (sing 3 0))
      (print (sing 8 6)))
