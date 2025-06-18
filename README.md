# Gesture-Detection system:
## Google ML Kit (Pose detection)
Google ML kit provies functionality to detect 33 landmakrs on human body. 
1) Input : We need to provide image of nv21 format to the posedetector
2) Pose dector provides with Pose objects
3) each pose consist of 33 landmarks that is joints, facial points
4) To create visualization of this joints and facial points we can create own  paint  class extending with CustomPaint class
5) CustomPaint class have methods 1) dopaint 2)shouldRepaint
6) shouldRepaint cheks previous position of the human if it is same then return false means dont need to repaint
7) dopaint is used to implat coordinate of the joints on the screen
8) pose.landmark provides coordinates of joints and accourding to orientation of the camera or depending upon camera(front, back or external) we can decide where to plot the points
9) Every pose.landmark has confidence i.e. probability of being correct which lies between 0.0 to 1.0

   ## Approach 1 to detect particular exercise
   1)Calculating angles between differenc joints and feeding it to logic(if else ladder initially) and detecting the exercise or counting reps
   2)e.g. if(angle near knee is less than 180 and torso is still straight) => potentially a squat
   3) if(elbows are infront of shoulder makeing 180 angle and body is horizontal) => potentially a initial position of pushup/plank/mountain climbing
   ## Approach 2 by using KNN algorithm for classification


