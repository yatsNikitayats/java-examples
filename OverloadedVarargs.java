public class OverloadedVarargs {
   // Метод для целых чисел
    public static void process(int... numbers) {
        System.out.print("Обработка целых чисел: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    // Метод для строк
    public static void process(String... strings) {
        System.out.print("Обработка строк: ");
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
    // Метод для чисел с плавающей точкой
    public static void process(double... doubles) {
        System.out.print("Обработка чисел double: ");
        for (double d : doubles) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        process(1, 2, 3);                 // целые числа
        process("Java", "Python", "C++");  // строки
        process(3.14, 2.71, 1.61);         // double
       // process();                          // какой метод?  неоднозначность
    } 
}
