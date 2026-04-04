public class ExceptionsDemo {
    
    // ===== 1. ArithmeticException =====
    // Возникает при арифметических ошибках (деление на ноль)
    public static void demonstrateArithmeticException() {
        System.out.println("\n=== 1. ArithmeticException ===");
        
        try {
            int result = 10 / 0;  // деление на ноль
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль!");
            System.out.println("Сообщение: " + e.getMessage());
        }
        
        // Как избежать: проверять делитель
        int divisor = 0;
        if (divisor != 0) {
            int result = 10 / divisor;
        } else {
            System.out.println("На ноль делить нельзя!");
        }
    }
    
    // ===== 2. ArrayIndexOutOfBoundsException =====
    // Возникает при обращении по несуществующему индексу массива
    public static void demonstrateArrayIndexOutOfBoundsException() {
        System.out.println("\n=== 2. ArrayIndexOutOfBoundsException ===");
        
        int[] numbers = {1, 2, 3};
        
        try {
            int value = numbers[5];  // индекс 5, а длина массива 3
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Индекс выходит за границы массива!");
            System.out.println("Длина массива: " + numbers.length);
        }
        
        // Как избежать: проверять индекс
        int index = 5;
        if (index >= 0 && index < numbers.length) {
            int value = numbers[index];
        } else {
            System.out.println("Индекс " + index + " вне диапазона (0-" + (numbers.length - 1) + ")");
        }
    }
    
    // ===== 3. IllegalArgumentException =====
    // Возникает при передаче недопустимого аргумента методу
    public static void demonstrateIllegalArgumentException() {
        System.out.println("\n=== 3. IllegalArgumentException ===");
        
        try {
            setAge(-5);  // возраст не может быть отрицательным
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        // Как избежать: проверять аргументы
        int age = -5;
        if (age < 0 || age > 150) {
            System.out.println("Некорректный возраст: " + age);
        } else {
            setAge(age);
        }
    }
    
    public static void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Возраст должен быть от 0 до 150, получено: " + age);
        }
        System.out.println("Возраст установлен: " + age);
    }
    
    // ===== 4. ClassCastException =====
    // Возникает при некорректном приведении типов
    public static void demonstrateClassCastException() {
        System.out.println("\n=== 4. ClassCastException ===");
        
        Object obj = "Это строка";
        
        try {
            Integer number = (Integer) obj;  // нельзя String привести к Integer
            System.out.println("Число: " + number);
        } catch (ClassCastException e) {
            System.out.println("Ошибка: Некорректное приведение типов!");
            System.out.println("Реальный тип: " + obj.getClass().getSimpleName());
        }
        
        // Как избежать: использовать instanceof
        if (obj instanceof Integer) {
            Integer number = (Integer) obj;
        } else {
            System.out.println("Объект не является Integer, его тип: " + obj.getClass().getSimpleName());
        }
    }
    
    // ===== 5. NullPointerException =====
    // Возникает при обращении к методу/полю null-объекта
    public static void demonstrateNullPointerException() {
        System.out.println("\n=== 5. NullPointerException ===");
        
        String text = null;
        
        try {
            int length = text.length();  // text = null, нельзя вызвать метод
            System.out.println("Длина строки: " + length);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: Обращение к null-объекту!");
        }
        
        // Как избежать: проверять на null
        if (text != null) {
            int length = text.length();
        } else {
            System.out.println("Строка равна null, нельзя получить длину");
        }
    }
    
    // ===== Дополнительный пример с несколькими catch =====
    public static void demonstrateMultipleCatch() {
        System.out.println("\n=== Множественная обработка исключений ===");
        
        String[] data = {"10", "ноль", null};
        
        for (String item : data) {
            try {
                int number = Integer.parseInt(item);  // может быть NumberFormatException
                int result = 100 / number;             // может быть ArithmeticException
                System.out.println("Результат: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: '" + item + "' не является числом");
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: Деление на ноль");
            } catch (NullPointerException e) {
                System.out.println("Ошибка: Передано null значение");
            }
        }
    }
    
    // ===== main метод для запуска =====
    public static void main(String[] args) {
        demonstrateArithmeticException();
        demonstrateArrayIndexOutOfBoundsException();
        demonstrateIllegalArgumentException();
        demonstrateClassCastException();
        demonstrateNullPointerException();
        demonstrateMultipleCatch();
    }
}
