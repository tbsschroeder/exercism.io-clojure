(ns armstrong-numbers)

(defn digits [number] (map #(Character/digit % 10) (str number)))

(defn exp [x n]
      (reduce * (repeat n x)))

(defn armstrong?
      [number]
      (= number (apply + (for [digit (digits number)] (exp digit (count (digits number)))))))