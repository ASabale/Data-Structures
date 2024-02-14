package primitive;


public class DataTypes {
    //there are 8 types

    //declaration
    static boolean aBoolean;
    static byte aByte;
    static short aShort;
    static int anInt;
    static long aLong;
    static float aFloat;
    static double aDouble;
    static char aChar;

    public static void main(String[] args) {

        //default values
        System.out.println("default value of boolean is: " + aBoolean);
        System.out.println("default value of byte is: " + aByte);
        System.out.println("default value of short is: " + aShort);
        System.out.println("default value of int is: " + anInt);
        System.out.println("default value of long is: " + aLong);
        System.out.println("default value of float is: " + aFloat);
        System.out.println("default value of double is: " + aDouble);
        System.out.println("default value of char is: " + aChar);

        System.out.println();

        //initialization
        aBoolean = true;
        aByte = 10;
        aShort = 125;
        anInt = 345;
        aLong = 23234L;
        aFloat = 564.2346f;
        aDouble = 345.45678d;
        aChar = 'A';


        System.out.println("new value of boolean is: " + aBoolean);
        System.out.println("new value of byte is: " + aByte);
        System.out.println("new value of short is: " + aShort);
        System.out.println("new value of int is: " + anInt);
        System.out.println("new value of long is: " + aLong);
        System.out.println("new value of float is: " + aFloat);
        System.out.println("new value of double is: " + aDouble);
        System.out.println("new value of char is: " + aChar);

        System.out.println();

        //size and range
        System.out.println("Datatype\t" + "size" + "\t" + "min value" + "\t" + "max value");
        System.out.println("Byte\t" + Byte.SIZE + "\t" + Byte.MIN_VALUE + "\t" + Byte.MAX_VALUE);
        System.out.println("Short\t" + Short.SIZE + "\t" + Short.MIN_VALUE + "\t" + Short.MAX_VALUE);
        System.out.println("Integer\t" + Integer.SIZE + "\t" + Integer.MIN_VALUE + "\t" + Integer.MAX_VALUE);
        System.out.println("Long\t" + Long.SIZE + "\t" + Long.MIN_VALUE + "\t" + Long.MAX_VALUE);
        System.out.println("Float\t" + Float.SIZE + "\t" + Float.MIN_VALUE + "\t" + Float.MAX_VALUE);
        System.out.println("Double\t" + Double.SIZE + "\t" + Double.MIN_VALUE + "\t" + Double.MAX_VALUE);

        //wrappers autoboxing
        Boolean bool = aBoolean;
        Byte b = aByte;
        Short sh = aShort;
        Integer i = anInt;
        Long l = aLong;
        Float f = aFloat;
        Double d = aDouble;
        Character ch = aChar;

        System.out.println("autobox value of boolean is: " + bool);
        System.out.println("autobox value of short is: " + sh);
        System.out.println("autobox value of byte is: " + b);
        System.out.println("autobox value of int is: " + i);
        System.out.println("autobox value of long is: " + l);
        System.out.println("autobox value of float is: " + f);
        System.out.println("autobox value of double is: " + d);
        System.out.println("autobox value of char is: " + ch);
    }

}
