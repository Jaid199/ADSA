import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter a seven digit number: ");
            int num = scan.nextInt();
            sevenDigit(num);
        }
    }

    public static boolean sevenDigit(int num) {
        // Correctly naming the digits
        int seventhNum = num % 10;
        num = num / 10;
        int sixthNum = num % 10;
        num = num / 10;
        int fifthNum = num % 10; // 5th digit
        num = num / 10;
        int fourthNum = num % 10; // 4th digit
        num = num / 10;
        int thirdNum = num % 10; // 3rd digit
        num = num / 10;
        int secondNum = num % 10; // 2nd digit
        num = num / 10;
        int firstNum = num; // 1st digit
        
        for(int i = 0; i <= 10; i++) {
            if(i == firstNum) {
                for(int j = 0; j < 10; j++) {
                    if(j == secondNum) {
                        for(int k = 0; k < 10; k++) {
                            if(k == thirdNum) {
                                for(int l = 0; l < 10; l++) {
                                    if(l == fourthNum) {
                                        for(int m = 0; m < 10; m++) {
                                            if(m == fifthNum) {
                                                for(int n = 0; n < 10; n++) {
                                                    if(n == sixthNum) {
                                                        for(int o = 0; o < 10; o++) {
                                                            if(o == seventhNum) {
                                                                System.out.println(i + " " + j + " " + k + " " + l + " " + m + " " + n + " " + o);
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}