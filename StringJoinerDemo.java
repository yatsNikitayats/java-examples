import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args) {
        
        // 1. Простое объединение с разделителем
        System.out.println("=== 1. Базовое использование ===");
        StringJoiner sj1 = new StringJoiner(", ");
        sj1.add("Январь");
        sj1.add("Февраль");
        sj1.add("Март");
        System.out.println(sj1); // Январь, Февраль, Март
        
        // 2. С префиксом и суффиксом
        System.out.println("\n=== 2. С префиксом и суффиксом ===");
        StringJoiner sj2 = new StringJoiner(", ", "[", "]");
        sj2.add("Красный");
        sj2.add("Зеленый");
        sj2.add("Синий");
        System.out.println(sj2); // [Красный, Зеленый, Синий]
        
        // 3. Объединение двух StringJoiner
        System.out.println("\n=== 3. Объединение StringJoiner ===");
        StringJoiner fruits = new StringJoiner(", ");
        fruits.add("Яблоко");
        fruits.add("Груша");
        
        StringJoiner vegetables = new StringJoiner(", ");
        vegetables.add("Морковь");
        vegetables.add("Картофель");
        
        fruits.merge(vegetables);
        System.out.println(fruits); // Яблоко, Груша, Морковь, Картофель
        
        // 4. Обработка пустого значения
        System.out.println("\n=== 4. Пустой StringJoiner ===");
        StringJoiner empty = new StringJoiner(", ", "[", "]");
        System.out.println("Без элементов: " + empty); // []
        System.out.println("Длина: " + empty.length()); // 2
        
        empty.setEmptyValue("Нет данных");
        System.out.println("После setEmptyValue: " + empty); // Нет данных
    }
}
