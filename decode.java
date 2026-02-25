public class decode {
   public static void main(String[] args) {
        System.out.println(Integer.decode("10"));    // 10
        System.out.println(Integer.decode("012"));   // 10 (восьмеричная)
        System.out.println(Integer.decode("0xA"));   // 10 (шестнадцатеричная)
        System.out.println(Integer.decode("#A"));    // 10 (шестнадцатеричная)
    }
} 

