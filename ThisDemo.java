class A {
    int a;
    int b;
    int c;
    int z;

    // Базовый конструктор (вся общая логика здесь)
    public A() {
        z = 1;
        System.out.println("Вызван базовый конструктор");
    }

    // Конструктор с 1 параметром
    public A(int a) {
        this();  // вызов A() → устанавливает z = 1
        this.a = a;
        System.out.println("Конструктор с 1 параметром");
    }

    // Конструктор с 2 параметрами
    public A(int a, int b) {
        this(a);  // вызов A(int a) → установит a и z
        this.b = b;
        System.out.println("Конструктор с 2 параметрами");
    }

    // Конструктор с 3 параметрами
    public A(int a, int b, int c) {
        this(a, b);  // вызов A(int a, int b) → установит a, b и z
        this.c = c;
        System.out.println("Конструктор с 3 параметрами");
    }
    
    // Метод для демонстрации
    public void showValues() {
        System.out.println("a=" + a + ", b=" + b + ", c=" + c + ", z=" + z);
    }
}

// Демонстрационный класс
public class ThisDemo {
    public static void main(String[] args) {
        System.out.println("=== СОЗДАНИЕ ОБЪЕКТОВ ===");
        
        System.out.println("\nnew A():");
        A obj1 = new A();
        obj1.showValues();
        
        System.out.println("\nnew A(10):");
        A obj2 = new A(10);
        obj2.showValues();
        
        System.out.println("\nnew A(10, 20):");
        A obj3 = new A(10, 20);
        obj3.showValues();
        
        System.out.println("\nnew A(10, 20, 30):");
        A obj4 = new A(10, 20, 30);
        obj4.showValues();
    }
}
