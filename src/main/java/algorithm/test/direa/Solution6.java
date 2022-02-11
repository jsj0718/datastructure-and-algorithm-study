package algorithm.test.direa;

import java.util.HashMap;

public class Solution6 {
    static abstract class Employee {
        int sabun;
        String name;

        abstract int getSalary();


        void printEmployeeInfo() {
            System.out.println("사번: " + sabun + ", 이름: " +
                    name + ", 봉급 " + getSalary());
        }
    }

    static class Permanent extends Employee {
        int getSalary() {
            return 100;
        }
    }

    static class Salesman extends Permanent {
        int getSalary() {
            return 10 + super.getSalary();
        }
    }


    public static void main(String[] args) {
        Employee one = new Permanent();
        Employee two = new Salesman();
        one.sabun = 1;
        one.name = "lji";
        two.sabun = 2;
        two.name = "kcs";

        one.printEmployeeInfo();
        two.printEmployeeInfo();

        HashMap map = new HashMap();
        map.put(1, "kim");
        map.put(1, "lee");
        map.put(1, "Jung");
        map.put(1, "Park");

        System.out.println(map.size());
        System.out.println(map.get(1));

    }

}
