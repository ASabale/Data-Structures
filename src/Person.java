public class Person {
    int height;

    public int eat(int apples){
        int result = apples * 2;
        return result;
    }

    public static void main(String[] args) {
        Person kishuu = new Person();
        kishuu.height = 163;
        System.out.println(kishuu.height);
        System.out.println(kishuu.eat(5));
    }
}
