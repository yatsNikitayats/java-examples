
   import java.util.*;

   class Animal {
    public void sound() { 
        System.out.println("Animal sound"); 
    }
}

class Dog extends Animal {
    public void sound() { 
        System.out.println("Woof!"); 
    }
    public void bark() { 
        System.out.println("Bark!"); 
    }
}

class Cat extends Animal {
    public void sound() { 
        System.out.println("Meow!"); 
    }
}

class Puppy extends Dog {
    public void sound() { 
        System.out.println("Yip!"); 
    }
}

public class WildcardsCompleteDemo {
    
    // Метод для чтения (PRODUCER) - используем ? extends
    public static void printAll(List<? extends Animal> list) {
        System.out.println("\n--- Чтение животных ---");
        for (Animal a : list) {  // можно читать как Animal
            a.sound();
        }
        // list.add(new Dog()); // нельзя!
    }
    
    // Метод для записи (CONSUMER) - используем ? super
    public static void addTwoDogs(List<? super Dog> list) {
        System.out.println("\n--- Добавление собак ---");
        list.add(new Dog());
        list.add(new Puppy());  // можно добавить подкласс
        System.out.println("Добавлено 2 собаки");
        // Dog d = list.get(0); // нельзя читать как Dog
    }
    
    // Метод для копирования из одного списка в другой
    public static void copyAnimals(List<? extends Animal> src, 
                                   List<? super Animal> dest) {
        System.out.println("\n--- Копирование ---");
        for (Animal a : src) {
            dest.add(a);
        }
        System.out.println("Скопировано " + src.size() + " животных");
    }
    
    public static void main(String[] args) {
        // Создаем разные списки
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        
        List<Object> objects = new ArrayList<>();
        
        
        printAll(dogs);     //  работает
        printAll(cats);     //  работает
        printAll(animals);  //  работает
        
        addTwoDogs(dogs);      //  работает
        addTwoDogs(animals);   //  работает
        addTwoDogs(objects);   //  работает
        
        copyAnimals(dogs, animals);    //  работает
        copyAnimals(cats, objects);    //  работает
        copyAnimals(animals, animals); //  работает
    }
} 

