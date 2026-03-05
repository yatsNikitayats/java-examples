
    import java.util.ArrayList;
import java.util.List;

public class GenericsInstanceofDemo {
    
    static class Container<T> {
        private T value;
        
        public Container(T value) {
            this.value = value;
        }
        
        public T getValue() {
            return value;
        }
    }
    
    public static void main(String[] args) {
        // Создаем разные параметризованные объекты
        Container<Integer> intContainer = new Container<>(100);
        Container<String> strContainer = new Container<>("Hello");
        Container<Double> dblContainer = new Container<>(3.14);
        
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        
        System.out.println("=== INSTANCEOF С GENERICS ===");
        
        // 1. Можно проверить сырой тип
        System.out.println("intContainer instanceof Container: " + 
                          (intContainer instanceof Container));  // true
        
        // 2. НЕЛЬЗЯ проверить конкретный параметр! (стираются типы)
        // System.out.println(intContainer instanceof Container<Integer>); //  ошибка 
        
        // 3. Можно проверить с ?
        System.out.println("intContainer instanceof Container<?>: " + 
                          (intContainer instanceof Container<?>));  // true
        
        // 4. List instanceof
        System.out.println("\n=== LIST ===");
        System.out.println("stringList instanceof List: " + 
                          (stringList instanceof List));  // true
        System.out.println("stringList instanceof ArrayList: " + 
                          (stringList instanceof ArrayList));  // true
        // System.out.println(stringList instanceof List<String>); //  ошибка
        
        // 5. Все Container имеют один класс
        System.out.println("\n=== СРАВНЕНИЕ КЛАССОВ ===");
        System.out.println("intContainer.getClass() == strContainer.getClass(): " +
                          (intContainer.getClass() == strContainer.getClass()));  // true!
        
        // 6. Как проверить тип внутри
        System.out.println("\n=== ПРОВЕРКА ТИПА ВНУТРИ ===");
        if (intContainer instanceof Container) {
            Container<?> container = (Container<?>) intContainer;
            Object value = container.getValue();
            
            if (value instanceof Integer) {
                System.out.println("Внутри Integer: " + value);
            } else if (value instanceof String) {
                System.out.println("Внутри String: " + value);
            }
        }
    }
}

