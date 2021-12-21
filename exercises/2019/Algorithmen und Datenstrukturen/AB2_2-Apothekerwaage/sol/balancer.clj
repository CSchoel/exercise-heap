(ns fpclj.balancer
  (:require [clojure.string :as s]
            [clojure.java.io :as io]))

(defn sum [xs]
  (reduce + xs))

(defn weights
  "Generates the weights sequence: (1 2 7 10 20 70..)"
  ([] (weights '(1 2 7)))
  ([init-lst] (lazy-seq (concat init-lst (apply weights init-lst))))
  ([one two seven]
   (let [seven2 (* 10 seven)
         two2 (* 10 two)
         one2 (* 10 one)]
     (lazy-seq (concat [one2 two2 seven2] (weights  one2 two2 seven2))))))

(defn find-weights [target-weight found-weights weights]
  (let [found-weight (sum found-weights)]
    (cond
      (= found-weight target-weight) (reverse found-weights)
      (< found-weight target-weight)
        (let [solution (find-weights target-weight (cons (first weights)
                                                         found-weights)
                                     (rest weights))]
          (if-not solution ;backtrack if solution is nil
            (do
              (find-weights target-weight
                            (cons (first weights)
                                  (rest found-weights))
                            (rest  weights)))
            solution) ;return found solution
          )
      :else nil))) ;couldn't find a solution; return nil


(defn find-weights-for-file [file]
  (let [content (slurp file :encoding "UTF-8")
        file-weights (map read-string (s/split content #"\n"))
        weight-list (map #(find-weights %1 [] (weights)) file-weights)]
    (doseq [string (map #(s/join "," %1) weight-list)]
      (println string))
    )
  )

(defn -main [& args]
  (println "running balancer")
  (find-weights-for-file "input.txt"))
