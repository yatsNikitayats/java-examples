public class IntegerCacheExample {
    public static void main(String[] args) {
        // Для 127 (попадает в кэш)
        Integer a1 = 127;
        Integer a2 = 127;
        System.out.println("127 == 127: " + (a1 == a2));       // true
        System.out.println("127 equals: " + a1.equals(a2));    // true
        
        // Для 128 (НЕ попадает в кэш)
        Integer b1 = 128;
        Integer b2 = 128;
        System.out.println("128 == 128: " + (b1 == b2));       // false
        System.out.println("128 equals: " + b1.equals(b2));    // true
    }
}
