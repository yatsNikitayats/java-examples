// Суперкласс
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    // Метод, который будем переопределять
    public void sound() {
        System.out.println(name + " издает звук");
    }
    
    public void move() {
        System.out.println(name + " двигается");
    }
}

// Подкласс 1
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    // Переопределение метода sound()
    @Override
    public void sound() {
        System.out.println(name + " лает: Гав-гав!");
    }
    
    // Переопределение метода move()
    @Override
    public void move() {
        System.out.println(name + " бегает на четырех лапах");
    }
}

// Подкласс 2
class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    
    // Переопределение метода sound()
    @Override
    public void sound() {
        System.out.println(name + " поет: Чирик-чирик!");
    }
    
    // Переопределение метода move()
    @Override
    public void move() {
        System.out.println(name + " летает");
    }
}

// Подкласс 3
class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }
    
    // Переопределение метода sound() - рыбы не издают звуков
    @Override
    public void sound() {
        System.out.println(name + " молчит (рыбы не издают звуков)");
    }
    
    // Переопределение метода move()
    @Override
    public void move() {
        System.out.println(name + " плавает");
    }
}

public class OverrideDemo {
    public static void main(String[] args) {
        // Демонстрация полиморфизма
        Animal[] animals = {
            new Dog("Шарик"),
            new Bird("Кеша"),
            new Fish("Немо")
        };
        
        for (Animal animal : animals) {
            animal.sound();
            animal.move();
            System.out.println();
        }
    }
}
