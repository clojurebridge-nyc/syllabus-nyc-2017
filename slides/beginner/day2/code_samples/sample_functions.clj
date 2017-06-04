;;
;; A few sample functions for the Turtles project that can be used for drawing art
;;

(defn draw-square
  [size]
  ;; assume we are facing the correct direction, so make four lines and 4 right turns
  (forward size)
  (right 90)
  (forward size)
  (right 90)
  (forward size)
  (right 90)
  (forward size)
  ;; at this point we are done with the squuare, but should reset our
  ;; direction to the original direction
  (right 90))

(defn draw-rect
  [width height]
  ;; draww 4 lines, 2 of them of size 'height' and 2 of size 'width'
  (forward height)
  (right 90)
  (forward width)
  (right 90)
  (forward height)
  (right 90)
  (forward width)
  (right 90))

(defn draw-pillar
  [width height]
  ;; draw a veritcal pillar which is essentially a 3-sided rectangle
  (forward height)
  (right 90)
  (forward width)
  (right 90)
  (forward height)
  ;; reset our 'facing' back to starting value
  (left 180))

(defn draw-line-rect
  [w h]
  ;; draws a 'filled' rectangle as a series of lines with 1 pixel between them
  ;; Note: currently not guaranteed to end up facing the same direction
  (let [num-passes (/ w 4)]
    (doseq [i (range num-passes)]
      (forward h)
      (right 90)
      (forward 2)
      (right 90)
      (forward h)
      (left 90)
      (forward 2)
      (left 90))))
