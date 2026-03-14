// Обычный класс - от него можно наследоваться
class RegularClass {
    protected String name;
    
    public RegularClass(String name) {
        this.name = name;
    }
    
    public void showInfo() {
        System.out.println("Обычный класс: " + name);
    }
}

// Final класс - от него нельзя наследоваться!
final class FinalClass {
    private String value;
    
    public FinalClass(String value) {
        this.value = value;
    }
    
    public void display() {
        System.out.println("Final класс, значение: " + value);
    }
}

//  Это работает - наследование от обычного класса
class ExtendedClass extends RegularClass {
    private int extra;
    
    public ExtendedClass(String name, int extra) {
        super(name);
        this.extra = extra;
    }
    
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Дополнительно: " + extra);
    }
}

// Это не будет работать - попытка наследования от final класса
/*
class ChildOfFinal extends FinalClass {
    public ChildOfFinal(String value) {
        super(value);
    }
    
    public void extraMethod() {
        System.out.println("Попытка расширить final класс");
    }
}
*/

// Можно создать класс, который использует final класс как поле (композиция)
class WrapperClass {
    private FinalClass finalObject;
    private String wrapperName;
    
    public WrapperClass(String value, String wrapperName) {
        this.finalObject = new FinalClass(value);
        this.wrapperName = wrapperName;
    }
    
    public void useFinalObject() {
        System.out.println("Wrapper: " + wrapperName);
        finalObject.display();  // используем методы final класса
    }
}


public class FinalClassDemo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ FINAL КЛАССОВ ===\n");
        
        // Работа с обычным классом и его наследником
        RegularClass regular = new RegularClass("Обычный");
        regular.showInfo();
        
        ExtendedClass extended = new ExtendedClass("Расширенный", 100);
        extended.showInfo();
        
        // Работа с final классом
        FinalClass finalObj = new FinalClass("Секретное значение");
        finalObj.display();
        
        // Альтернатива наследованию - композиция
        WrapperClass wrapper = new WrapperClass("Завернутое значение", "Обертка");
        wrapper.useFinalObject();
        
        System.out.println("\n=== ПОПЫТКА НАСЛЕДОВАНИЯ ОТ FINAL КЛАССА ===");
        System.out.println("Если раскомментировать класс ChildOfFinal,");
        System.out.println("компилятор выдаст ошибку:");
        System.out.println("'cannot inherit from final FinalClass'");
    }
}
