package com.global.advanced.java.advancedjava.java.generics;

public class GenericRunner {
    public static void main(String[] args) {
        IntegerHolder integerHolderLoc = new IntegerHolder();
        integerHolderLoc.setVal1(4683276);
        Integer      val1Loc1        = integerHolderLoc.getVal1();
        StringHolder stringHolderLoc = new StringHolder();
        stringHolderLoc.setVal1("osman");
        String val1Loc2 = stringHolderLoc.getVal1();

        ObjectHolder objectHolderLoc = new ObjectHolder();
        objectHolderLoc.setVal1("osman");
        objectHolderLoc.setVal1(129832);
        objectHolderLoc.setVal1(293748928734L);

        Object val1Loc = objectHolderLoc.getVal1();
        if (val1Loc instanceof Integer) {
            Integer integerLoc = (Integer) val1Loc;
        }

        GenericHolder<Long> holderLoc1 = new GenericHolder<>();
        holderLoc1.setVal1(3287623823L);
        Long val1Loc3 = holderLoc1.getVal1();

        GenericHolder<String> holderLoc2 = new GenericHolder<>();
        holderLoc2.setVal1("osman");
        String val1Loc4 = holderLoc2.getVal1();

        GenericHolder<Car> holderLoc3 = new GenericHolder<>();
        holderLoc3.setVal1(new Car("BMW",
                                   2023,
                                   170));
        Car val1Loc5 = holderLoc3.getVal1();

        Pair<String, Integer> pairLoc2 = new Pair<>("ali",
                                                    43);


        Pair<String, Integer> pairLoc = new Pair<>();
        pairLoc.setLeft("osman");
        pairLoc.setRight(100);
        pairLoc.add("yay");
        pairLoc.execute(pairLoc2);

        IExecute<BMW, Integer> carIntegerIExecuteLoc;

        genMethod(new Car(), "osman");
    }

    public static <R extends CharSequence, T> void genMethod(T t,
                                                          R r) {

    }
}
