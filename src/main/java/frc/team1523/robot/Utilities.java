package frc.team1523.robot;

public class Utilities {
    public static double signedSqrt(double value) {
        // Square the number, but keep the original sign
        return Math.copySign(value * value, value);
    }
}
