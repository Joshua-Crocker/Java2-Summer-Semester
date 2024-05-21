package Java_Assignments.Java_Assignment1.Question8;

public class WeightConverter {
    public static double poundsToKilos(double pounds) {
        assert pounds > 0 : "Weight in pounds has to be greater than 0.";
        return pounds * 0.45359237;
    }

    public static double kilosToPounds(double kilos) {
        assert kilos > 0: "Weight in kilos has to be greater than 0";
        return kilos / 0.45359237;
    }

    public static void main(String[] args) {
        try {
            System.out.printf("200 pounds to kilos " + poundsToKilos(200.0) + "\n");
            System.out.printf("200 kilos to pounds " + kilosToPounds(200.0) + "\n");
            System.out.printf("-25 pounds to kilos " + poundsToKilos(-25.0) + "\n");
            System.out.printf("-25 kilos to pounds " + kilosToPounds(-25.0) + "\n");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}
