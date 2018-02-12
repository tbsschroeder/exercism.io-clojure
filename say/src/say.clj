(ns say)

(defn- digit [n]
       (case n
             0 "zero"
             1 "one"
             2 "two"
             3 "three"
             4 "four"
             5 "five"
             6 "six"
             7 "seven"
             8 "eight"
             9 "nine"))

(defn- teen [n]
       (case n
             0 "ten"
             1 "eleven"
             2 "twelve"
             3 "thirteen"
             4 "fourteen"
             5 "fifteen"
             6 "sixteen"
             7 "seventeen"
             8 "eighteen"
             9 "nineteen"))

(defn- tens [n]
       (case n
             2 "twenty"
             3 "thirty"
             4 "forty"
             5 "fifty"
             6 "sixty"
             7 "seventy"
             8 "eighty"
             9 "ninety"))

(defn- decompose [n]
       (condp > n
              0             (throw (IllegalArgumentException. "negative numbers are not supported!"))
              1             []
              10            [(digit n)]
              20            [(teen (mod n 10))]
              21            [(tens (quot n 10))]
              100           [(str (tens (quot n 10)) \- (digit (mod n 10)))]
              1000          (concat (decompose (quot n 100)) ["hundred"] (decompose (mod n 100)))
              1000000       (concat (decompose (quot n 1000)) ["thousand"] (decompose (mod n 1000)))
              1000000000    (concat (decompose (quot n 1000000)) ["million"] (decompose (mod n 1000000)))
              1000000000000 (concat (decompose (quot n 1000000000)) ["billion"] (decompose (mod n 1000000000)))
              (throw (IllegalArgumentException. "trillions and larger are not supported!"))))

(defn number [n]
      (if (zero? n)
        (str (digit n))
        (clojure.string/join " " (decompose n))))