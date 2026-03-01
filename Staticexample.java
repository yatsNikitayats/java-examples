public class Staticexample {
    public static class A {
    public static int a = 1;        // статическое поле
    public static int b;             // статическое поле (по умолчанию 0)

    public static void printVars() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    
    public void nonStaticMethod() {
        System.out.println("\n=== Нестатический метод ===");
        System.out.println("Из нестатического метода можно:");
        a = 10;                       // ✔ можно менять статические поля
        printVars();                   // ✔ можно вызывать статические методы
    }
}

public static class StaticDemo {
    public static void main(String[] args) {
        System.out.println("=== ВАРИАНТЫ ВЫЗОВА printVars() ===");
        
        // ВАРИАНТ 1: через имя класса (правильный способ)
        System.out.println("1. Через имя класса:");
        A.printVars();
        
        // ВАРИАНТ 2: через объект (работает, но не рекомендуется)
        System.out.println("\n2. Через объект:");
        A obj = new A();
        obj.printVars();
        
        // ВАРИАНТ 3: из нестатического метода
        System.out.println("\n3. Из нестатического метода:");
        obj.nonStaticMethod();
        
        // ВАРИАНТ 4: без указания класса (если в том же классе)
        System.out.println("\n4. Без указания класса (внутри класса):");
        insideClassCall();
    }
    
    public static void insideClassCall() {
        // внутри того же класса можно без A.
        A.printVars();  // вызывается A.printVars()
    }
}
}
