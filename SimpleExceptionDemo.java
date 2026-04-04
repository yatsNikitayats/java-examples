public class SimpleExceptionDemo {
    
    // 1. Метод с перехваченным исключением
    public static void handledException() {
        System.out.println("--- Перехваченное исключение ---");
        
        try {
            int[] arr = new int[2];
            arr[5] = 10;  // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение перехвачено!");
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        System.out.println("Программа продолжает работу\n");
    }
    
    // 2. Метод с неперехваченным исключением (аварийная остановка)
    public static void unhandledException() {
        System.out.println("--- Неперехваченное исключение ---");
        
        int result = 10 / 0;  // ArithmeticException - будет аварийная остановка
        
        System.out.println("Эта строка не выполнится");
    }
    
    public static void main(String[] args) {
        // Пример 1: исключение перехвачено → программа продолжает работу
        handledException();
        
        // Пример 2: исключение НЕ перехвачено → аварийная остановка
        unhandledException();  // Программа упадет здесь
        
        System.out.println("Эта строка не выполнится из-за ошибки выше");
    }
}