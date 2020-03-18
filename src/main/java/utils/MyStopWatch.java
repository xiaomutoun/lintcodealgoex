package utils;

public class MyStopWatch {

    private static long startTime;
    private static long stopTime;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void stop() {
        stopTime = System.currentTimeMillis();
    }

    public static String countTime() {
        return "Time release is " + (stopTime - startTime) + " milliseconds.";
    }
}
