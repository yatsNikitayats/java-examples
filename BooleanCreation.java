public class BooleanCreation {
    public static void main(String[] args) {
        // Все способы создания Boolean
        Boolean b1 = Boolean.valueOf(true);
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = true;  // автоупаковка
        boolean b4 = Boolean.parseBoolean("true"); // примитив
        
        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4);
        System.out.println(Boolean.valueOf("yes")); // false
        System.out.println(Boolean.valueOf(null));  // false
    }
}