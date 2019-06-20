(ns hackerrank-submissions.interview-preperation.new-year-chaos)


;Print an integer denoting the minimum number of bribes needed 
;;to get the queue into its final state. 

;Print Too chaotic if the state is invalid, 
;;i.e. it requires a person to have bribed more than people.

;Sample Input
;2 1 5 3 4
;2 5 1 3 4

;Sample Output
;3
;Too chaotic

(defn minimumBribes [q]
  (let [acc (atom {:counter 0 :too-chaotic false})]
    (doseq [x (range (dec (count q)) -1 -1)
            :while (false? (:too-chaotic @acc))]
      (if (> (- (get q x) (inc x)) 2)
        (swap! acc assoc :too-chaotic true)
        (doseq [y (range (max (- (get q x) 2) 0) x)]
          (if (> (get q y) (get q x))
          (swap! acc update :counter inc)))))
      (if (true? (:too-chaotic @acc))
        (println "Too chaotic")
        (println (:counter @acc)))))  