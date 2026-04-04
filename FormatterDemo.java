public class FormatterDemo {
    public static void main(String[] args) {
        
        System.out.println("=== ПРАКТИКА #1: 5 спецификаторов ===\n");
        
        // 1. %d - десятичное целое число
        int age = 25;
        System.out.printf("1. %%d: Мне %d лет%n", age);
        
        // 2. %f - число с плавающей точкой
        double price = 19.99;
        System.out.printf("2. %%f: Цена: %.2f руб.%n", price);
        
        // 3. %s - строковое представление
        String name = "Иван";
        System.out.printf("3. %%s: Имя: %s%n", name);
        
        // 4. %b - логическое значение
        boolean isActive = true;
        System.out.printf("4. %%b: Активен: %b%n", isActive);
        
        // 5. %c - символ
        char grade = 'A';
        System.out.printf("5. %%c: Оценка: %c%n", grade);
        
        
    }
}
