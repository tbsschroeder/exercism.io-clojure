(ns bob)
(use 'clojure.string)

(defn response-for
      ;; 'Sure.' -> question
      ;; 'Whoa, chill out!' -> uppercase
      ;; 'Fine. Be that way!' -> empty msg
      ;; 'Whatever.' -> else
      [input]
      (cond
        (blank? input)
        (str "Fine. Be that way!")
        (and (= input (upper-case input)) (re-seq #"[A-z]" input))
        (str "Whoa, chill out!")
        (ends-with? input "?")
        (str "Sure.")
        :else
        (str "Whatever.")))
