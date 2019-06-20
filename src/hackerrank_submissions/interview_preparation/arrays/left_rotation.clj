(ns hackerrank-submissions.interview-preperation.left-rotation)


; Given an array 'a' of 'n' integers and a number, 'd',
; perform 'd' left rotations on the array. 

; Return the updated array to be printed 
; as a single line of space-separated integers.

;Sample Input
;5 4
;1 2 3 4 5

;Sample Output
;5 1 2 3 4

(defn rotLeft [a d]
  (let [rotation (subvec a 0 d)
        new-begin (subvec a d)]
    (into new-begin rotation)))

