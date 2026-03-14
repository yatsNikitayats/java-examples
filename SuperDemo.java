// Суперкласс
class Animal {
    String name;
    
    public Animal(String name) {    // ← конструктор суперкласса
        this.name = name;
    }
    
    public void sound() {
        System.out.println(name + " издает звук");
    }
}

// Подкласс
class Dog extends Animal {
    String breed;
    
    // Единственный конструктор
    public Dog(String name, String breed) {
        super(name);           // 1️ super() - вызов конструктора суперкласса!
        this.breed = breed;
    }
    
    public void show() {
        System.out.println("super.name = " + super.name);  // 2️ super.поле - доступ к полю суперкласса!
        System.out.println("breed = " + breed);
    }
    
    @Override
    public void sound() {
        super.sound();          // 3️ super.метод() - вызов метода суперкласса!
        System.out.println("Гав-гав!");
    }
}

public class SuperDemo {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик", "Овчарка");
        
        dog.show();
        dog.sound();
    }
}