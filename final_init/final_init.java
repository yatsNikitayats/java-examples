package final_init;

public class final_init {
    public class A {
    public final int a;
    
    // ВАРИАНТ 1: в конструкторе
    public A(int value) {
        a = value;  // инициализация через параметр конструктора
    }
    
    // ВАРИАНТ 2: несколько конструкторов
    public A() {
        a = 10;  // значение по умолчанию
    }
    
    // ВАРИАНТ 3: в логическом блоке
    
    {
      //  a = 20;  // тоже работает
    }
    
}
}


