(ns hello-world)

(defn hello
  ([] (hello "World"))
  ([name] (str "Hello, " name "!"))
)


(defn -main
      [&args]
      (hello "Hans"))