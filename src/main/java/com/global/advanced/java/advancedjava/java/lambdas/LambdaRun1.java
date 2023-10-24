package com.global.advanced.java.advancedjava.java.lambdas;

import com.global.advanced.java.advancedjava.models.Customer;

import java.time.LocalDate;
import java.util.function.Supplier;

public class LambdaRun1 {
    public static void main(String[] args) {
        String  prefix  = "deneme";
        Integer intVal1 = 100;
        // Interface impl1
        IProcess processLoc = new ProcessImpl();
        System.out.println(processLoc.execute(10,
                                              "osman"));

        // Interface impl2
        IProcess processLoc1 = new IProcess() {
            @Override
            public String execute(final Integer count,
                                  final String data) {
                return prefix + " Data : " + data + " count : " + count + "-" + intVal1;
            }
        };
        System.out.println(processLoc1.execute(10,
                                               "osman"));

        // Interface Impl3
        IProcess processLoc2 = (a, b) -> prefix + " Data : " + b + " count : " + a + "-" + intVal1;
        System.out.println(processLoc2.execute(10,
                                               "osman"));

        IProcess processLoc3 = (a, b) -> {
            System.out.println("Çalışıyorum");
            return prefix + " Data : " + b + " count : " + a + "-" + intVal1;
        };

        IProcess processLoc4 = LambdaRun1::abc;

        LambdaRun1 lambdaRun1Loc = new LambdaRun1();
        IProcess processLoc5 =lambdaRun1Loc::xyz;
        System.out.println(processLoc5.execute(5, "test method"));

        ITest<String, String> testLoc = p -> "sonuç : " + p;

        ITest<String, Integer> testLoc2 = Integer::parseInt;

        Supplier<String> supplierLoc = () -> "deneme";
        Supplier<Customer> supplierLoc1 = () -> new Customer("test",
                                                             "test",
                                                             LocalDate.now(),
                                                             100,
                                                             200);

    }

    public  String xyz(Integer z,
                             String c) {
        StringBuilder builderLoc = new StringBuilder();
        for (int i = 0; i < z; i++) {
            builderLoc.append(c)
                      .append("%%%");
        }
        return builderLoc.toString();
    }


    public static String abc(Integer z,
                             String c) {
        StringBuilder builderLoc = new StringBuilder();
        for (int i = 0; i < z; i++) {
            builderLoc.append(c)
                      .append("-");
        }
        return builderLoc.toString();
    }
}
