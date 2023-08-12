package javapractice;

import org.testng.annotations.Test;

public class JavaMethodsTest {

    @Test
    public void testJavaMethods() {
        String access;
        int age = 10;
        boolean registered = false;
        boolean guardian = true;

        if(age >= 21 && registered) {
            access = "100%";
        } else if (age >= 18 && age < 21 || guardian) {
            access = "Partial";
        } else {
            access = "Forbidden";
        }
        System.out.println(access);
    }

    @Test
    public void testSwitch() {
        int day = 5;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Wrong number");
                break;
        }
    }

    @Test
    public void forLoop() {

        for (int i = 1; i < 24; i++) {
            System.out.println(++i);
        }

    }
}
