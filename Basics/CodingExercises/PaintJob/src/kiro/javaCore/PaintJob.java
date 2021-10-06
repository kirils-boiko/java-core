package kiro.javaCore;

public class PaintJob {

    public static int getBucketCount(double width, double height,
                                     double areaPerBucket, int extraBuckets) {

        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets <0)
            return -1;

        double areaToCover = width * height;
        double areaNetExtra = areaToCover - extraBuckets * areaPerBucket;
        int bucketsToBuy = (int)Math.ceil(areaNetExtra / areaPerBucket);
        return bucketsToBuy;
    }

    public static int getBucketCount(double width, double height,
                                     double areaPerBucket) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0)
            return -1;

        double areaToCover = width * height;
        int bucketsToBuy = (int)Math.ceil(areaToCover / areaPerBucket);
        return bucketsToBuy;
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if (area <= 0 || areaPerBucket <= 0)
            return -1;

        int bucketsToBuy = (int)Math.ceil(area / areaPerBucket);
        return bucketsToBuy;
    }

}
