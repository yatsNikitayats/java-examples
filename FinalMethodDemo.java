// Суперкласс с final-методом
class Parent {
    
    // Обычный метод - можно переопределить
    public void normalMethod() {
        System.out.println("Обычный метод в Parent");
    }
    
    // Final метод - переопределить нельзя
    public final void finalMethod() {
        System.out.println("FINAL метод в Parent - его нельзя переопределить");
    }
    
    public void tryToCall() {
        System.out.println("\n=== Вызов методов из Parent ===");
        normalMethod();
        finalMethod();
    }
}

// Подкласс пытается переопределить методы
class Child extends Parent {
    
    // Это работает - обычный метод можно переопределить
    @Override
    public void normalMethod() {
        System.out.println("Переопределенный метод в Child");
    }
    
    // Это не работает - final метод нельзя переопределить
    /*
    @Override
    public void finalMethod() {
        System.out.println("Попытка переопределить final метод");
    }
    */
    
    // Можно вызвать final метод, но нельзя изменить его реализацию
    public void showFinal() {
        System.out.println("\n=== Вызов final метода из Child ===");
        finalMethod(); // просто вызываем, не переопределяя
    }
}

// Еще один уровень наследования
class GrandChild extends Child {
    
    //  Все еще можно переопределить обычный метод
    @Override
    public void normalMethod() {
        System.out.println("Переопределенный метод в GrandChild");
    }
    
    // finalMethod все еще нельзя переопределить
    // Он остался final от Parent через Child
}


public class FinalMethodDemo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ FINAL МЕТОДОВ ===\n");
        
        Parent parent = new Parent();
        parent.tryToCall();
        
        Child child = new Child();
        child.normalMethod();      // вызовет переопределенный метод
        child.finalMethod();       // вызовет метод родителя (не переопределенный)
        child.showFinal();
        
        GrandChild grandChild = new GrandChild();
        grandChild.normalMethod(); // вызовет метод из GrandChild
        grandChild.finalMethod();  // все еще метод из Parent
        
        System.out.println("\n=== ПОПЫТКА ПЕРЕОПРЕДЕЛИТЬ FINAL МЕТОД ===");
        System.out.println("Если раскомментировать finalMethod() в Child,");
        System.out.println("компилятор выдаст ошибку:");
        System.out.println("'finalMethod() cannot override finalMethod() in Parent;");
        System.out.println("overridden method is final");
    }
}
