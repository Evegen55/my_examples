package Algorithms;

public class MathExamples {

    public static void main(String[] args) {

        double pow1 = Math.pow(1.7e+154, 2); //Infinity
        double pow2 = Math.pow(1.7e+153, 2); //2.8899999999999993E306
        System.out.println(pow1);
        System.out.println(pow2);

        double pow3 = Math.pow(2e+2, 2);  //40000.0
        System.out.println(pow3);
        System.out.println(1.7e+3); //1700.0
    }
}
