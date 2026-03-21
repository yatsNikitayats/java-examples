// Интерфейс может содержать вложенный класс
interface Calculator {
    
    // Вложенный класс внутри интерфейса (всегда public static)
    class Operation {
        private String name;
        
        public Operation(String name) {
            this.name = name;
        }
        
        public int add(int a, int b) {
            System.out.println("Выполняем " + name);
            return a + b;
        }
        
        public int multiply(int a, int b) {
            System.out.println("Выполняем " + name);
            return a * b;
        }
    }
    
    // Методы интерфейса
    int calculate(int a, int b);
}

// Реализация интерфейса
class SimpleCalculator implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

public class NestedInInterfaceDemo {
    public static void main(String[] args) {
        // Способ 1: Прямое создание вложенного класса интерфейса
        Calculator.Operation op = new Calculator.Operation("Сложение");
        int result = op.add(5, 3);
        System.out.println("Результат: " + result);
        
        // Способ 2: Использование с реализацией интерфейса
        SimpleCalculator calc = new SimpleCalculator();
        System.out.println("Через реализацию: " + calc.calculate(10, 20));
        
        // Способ 3: Другой пример
        Calculator.Operation mult = new Calculator.Operation("Умножение");
        System.out.println("Умножение: " + mult.multiply(4, 5));
    }
}
