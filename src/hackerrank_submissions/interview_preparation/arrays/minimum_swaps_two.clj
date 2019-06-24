(ns hackerrank-submissions.interview-preparation.arrays.minimum-swaps-two)

;Given an unordered array consisting of consecutive integers
;You are allowed to swap any two elements. 


;Return the minimum number of swaps required to sort the array in ascending order. 

;Sample Input 
;4 3 1 2

;Sample Output
;3

(defn minimumSwaps [arr]
    (let [counter (atom 0)
          swap-fn (fn [num-arr [pos1 pos2]]
                    (swap! counter inc)
                    (assoc num-arr pos1 (num-arr pos2) pos2 (num-arr pos1)))]
      (loop [curr-pos 0
             num-seq arr]
        (if (> curr-pos (dec (count arr)))
          @counter
          (if (= (inc curr-pos) (num-seq curr-pos))
            (recur (inc curr-pos) num-seq)
            (let [curr-val (num-seq curr-pos)
                  val-pos (num-seq (dec curr-val))]
                (if (= curr-pos (dec (num-seq (dec curr-val))))
                  (recur (inc curr-pos) (swap-fn num-seq [curr-pos (dec curr-val)]))
                  (recur curr-pos
                    (-> num-seq
                     (swap-fn [(dec curr-val) (dec val-pos)])
                     (swap-fn [curr-pos (dec curr-val)]))))))))))