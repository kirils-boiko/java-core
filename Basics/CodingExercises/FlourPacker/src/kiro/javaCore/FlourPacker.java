package kiro.javaCore;

public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        // bigCount represents the number of available big 5-kilo flour bags
        // smallCount represents the number of available small 1-kilo flour bags
        // goal represents the goal amount of kilo flour needed to assemble a package
        // only full bags can be used for package

        if (bigCount < 0 || smallCount < 0 || goal < 0 || (bigCount * 5 + smallCount) < goal)
            return false;

        // first pack as much big bags as possible, then see if enough small bags to pack the rest
        int bigPacksNeeded = goal / 5;
        int smallPacksNeeded;

        if (bigPacksNeeded > bigCount)
            smallPacksNeeded = goal - bigCount * 5;
        else
            smallPacksNeeded = goal % 5;

        return smallCount >= smallPacksNeeded;
    }
}
