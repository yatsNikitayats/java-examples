class Parent {
    public void display(String message) {
        System.out.println("Parent: " + message);
    }
    
    public void calculate(int a, int b) {
        System.out.println("Parent calculate: " + (a + b));
    }
}

class Child extends Parent {
    
    // случай 1: Ошибка в имени метода
    /*
    @Override
    public void displa(String message) {  //  Опечатка: displa вместо display
        System.out.println("Child: " + message);
    }
    // Компилятор: метод не переопределяет метод суперкласса!
    */
    
    // случай 2: Ошибка в параметрах
    /*
    @Override
    public void display() {  // Нет параметра String
        System.out.println("Child: без параметра");
    }
    // Компилятор: метод не переопределяет метод суперкласса!
    */
    
    // случай 3: Ошибка в типе возвращаемого значения (раскомментируй для проверки)
    /*
    @Override
    public int display(String message) {  // Должен быть void
        System.out.println("Child: " + message);
        return 0;
    }
    // Компилятор: метод не переопределяет метод суперкласса!
    */
    
    // случай 4: Правильное переопределение
    @Override
    public void display(String message) {  //  Все верно
        System.out.println("Child: " + message);
    }
    
    // случай 5: Ошибка - такого метода нет в родителе
    /*
    @Override
    public void calculate(int a, int b, int c) {  //  Три параметра, а надо два
        System.out.println("Child calculate: " + (a + b + c));
    }
    // Компилятор: метод не переопределяет метод суперкласса!
    */
}

public class OverrideAnnotationDemo {
    public static void main(String[] args) {
        Child child = new Child();
        child.display("Привет");
    }
}