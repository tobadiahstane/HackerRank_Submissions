(ns hackerrank-submissions.interview-preparation.arrays.two-d-arrays)

;Print the largest (maximum) hourglass sum found in 6x6 arr.

; Sample Input
;;[[1 1 1 0 0 0]
;; [0 1 0 0 0 0]
;; [1 1 1 0 0 0]
;; [0 0 2 4 4 0]
;; [0 0 0 2 0 0]
;; [0 0 1 2 4 0]]

;Sample Output
;19

(defn hourglassSum [arr]
  (let [hourglass (fn [arr1 arr2 arr3]
                    (loop [pos 0
                           hg #{}]
                      (if (> (+ 2 pos) (dec (count arr1)))
                        hg
                        (let [next-hg (+ (arr1 pos) (arr1 (+ 1 pos)) (arr1 (+ 2 pos)) 
                                         (arr2 (+ 1 pos))
                                         (arr3 pos) (arr3 (+ 1 pos)) (arr3 (+ 2 pos)))]
                          (recur (inc pos) (conj hg next-hg))))))]
    (loop [pos 0
           hgs []]
      (if (> (+ 2 pos) (dec (count arr)))
        (first (sort > hgs))
        (recur (inc pos) (into hgs (hourglass (arr pos) (arr (+ 1 pos)) (arr (+ 2 pos)))))))))