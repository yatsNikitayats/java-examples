
class MyFirstException extends Exception {
    
    // Конструктор без параметров
    public MyFirstException() {
        super();
    }
    
    // Конструктор с сообщением
    public MyFirstException(String message) {
        super(message);
    }
    
    // Конструктор с сообщением и причиной
    public MyFirstException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class SimpleException {
    
    public static void validateAge(int age) throws MyFirstException {
        if (age < 0 || age > 150) {
            throw new MyFirstException("Некорректный возраст: " + age);
        }
        System.out.println("Возраст " + age + " корректен");
    }
    
    public static void main(String[] args) {
        try {
            validateAge(-5);
        } catch (MyFirstException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }
    }
}