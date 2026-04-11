public class MultiCatchPractice {
    
    public static void main(String[] args) {
        
        // 1. Одинаковая обработка (оператор |)
        String[] values = {"100", "abc", "0"};
        
        for (String val : values) {
            try {
                int num = Integer.parseInt(val);
                int result = 100 / num;
                System.out.println("Результат для '" + val + "': " + result);
            } catch (NumberFormatException | ArithmeticException e) {
                System.out.println("Ошибка для '" + val + "': " + e.getClass().getSimpleName());
            }
        }
        
        // 2. Иерархия исключений (от потомка к родителю)
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Перехвачен ArithmeticException: деление на ноль");
        } catch (RuntimeException e) {
            System.out.println("Перехвачен RuntimeException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Перехвачен Exception: " + e.getMessage());
        }
    }
}