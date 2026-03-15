public class Calculator {
    
    // 1. Сложение двух целых чисел
    public int sum(int a, int b) {
        System.out.println("Вызван sum(int, int)");
        return a + b;
    }
    
    // 2. Сложение трех целых чисел
    public int sum(int a, int b, int c) {
        System.out.println("Вызван sum(int, int, int)");
        return a + b + c;
    }
    
    // 3. Сложение чисел с плавающей точкой
    public double sum(double a, double b) {
        System.out.println("Вызван sum(double, double)");
        return a + b;
    }
    
    // 4. Сложение целого и числа с плавающей точкой
    public double sum(int a, double b) {
        System.out.println("Вызван sum(int, double)");
        return a + b;
    }
    
    // 5. Сложение массива чисел (varargs)
    public int sum(int... numbers) {
        System.out.println("Вызван sum(varargs) с " + numbers.length + " числами");
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        System.out.println(calc.sum(5, 3));           // 1
        System.out.println(calc.sum(5, 3, 2));        // 2
        System.out.println(calc.sum(5.5, 3.3));       // 3
        System.out.println(calc.sum(5, 3.3));         // 4
        System.out.println(calc.sum(1, 2, 3, 4, 5));  // 5
    }
}