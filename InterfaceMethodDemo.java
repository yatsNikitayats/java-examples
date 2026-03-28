// Интерфейс с default и static методами
interface Vehicle {
    
    // Абстрактный метод 
    void move();
    
    // DEFAULT метод (имеет реализацию, можно переопределить)
    default void start() {
        System.out.println("Vehicle: двигатель запущен");
    }
    
    // STATIC метод (вызывается через интерфейс)
    static void info() {
        System.out.println("Vehicle: это транспортное средство");
    }
}

// Класс, реализующий интерфейс
class Car implements Vehicle {
    
    // Обязательная реализация абстрактного метода
    @Override
    public void move() {
        System.out.println("Car: машина едет");
    }
    
    // Опционально: переопределяем default метод
    @Override
    public void start() {
        System.out.println("Car: заводим двигатель ключом");
    }
}

// Другой класс, использующий default метод без переопределения
class Bicycle implements Vehicle {
    
    @Override
    public void move() {
        System.out.println("Bicycle: велосипед едет");
    }
    
    // default метод start() НЕ переопределен, используется версия из интерфейса
}

public class InterfaceMethodDemo {
    public static void main(String[] args) {
        System.out.println("=== Car ===");
        Car car = new Car();
        car.start();      // вызов переопределенного default метода
        car.move();       // вызов реализованного абстрактного метода
        
        System.out.println("\n=== Bicycle ===");
        Bicycle bike = new Bicycle();
        bike.start();     // вызов default метода из интерфейса
        bike.move();
        
        System.out.println("\n=== Статический метод интерфейса ===");
        // Статический метод вызывается через имя интерфейса (не через объект!)
        Vehicle.info();   //  правильно
        
        // car.info();    //  ошибка! static метод нельзя вызвать через объект
    }
}
