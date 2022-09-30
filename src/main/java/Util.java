public class Util {
    // [ minValue, maxValue ]
    static int generateRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue+1 - minValue) + minValue);
    }
}
