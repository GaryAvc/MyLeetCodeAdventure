class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        /** Invirance:
         *1. when the distance of center of the cirecle and rectangle > r +x/2 -> return
         *   false. otherwise return true
         *2. x/2 is equal to (x2-x1)/2
         */
        double halfLength ;
        boolean isOverlap = true;
        double rectangleCenterx;
        double rectangleCentery;
        double twoCenterDistance;


        rectangleCenterx = x1+(x2-x1)/2.0;
        rectangleCentery = y1+(y2-y1)/2.0;

        halfLength = Math.sqrt(Math.pow((x2-x1)/2.0,2)+Math.pow((y2-y1)/2.0,2));


        twoCenterDistance=Math.sqrt( Math.pow(rectangleCentery-y_center,2)
                +(Math.pow(rectangleCenterx-x_center,2)));

        if(twoCenterDistance> radius +halfLength){
            isOverlap = false;
        }

        return isOverlap;
    }
}