package by.grsu.random;

import java.util.Random;

public class Randomizer {
    public static Random random = new Random();
    public static int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
