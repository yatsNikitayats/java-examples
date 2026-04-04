public class StringBufferDemo {
    public static void main(String[] args) {
        
        // Создание StringBuffer с начальным значением
        StringBuffer sb = new StringBuffer("Hello");
        
        System.out.println("=== Исходная строка ===");
        System.out.println("sb = " + sb); // Hello
        
        // 1. append() - добавляет строку в конец
        sb.append(" World");
        System.out.println("\n1. append(\" World\"): " + sb); // Hello World
        
        // 2. insert() - вставляет строку в указанную позицию
        sb.insert(5, ",");
        System.out.println("2. insert(5, \",\"): " + sb); // Hello, World
        
        // 3. delete() - удаляет символы от start до end
        sb.delete(5, 6);
        System.out.println("3. delete(5, 6): " + sb); // Hello World
        
        // 4. reverse() - переворачивает строку
        sb.reverse();
        System.out.println("4. reverse(): " + sb); // dlroW olleH
        
        // 5. reverse() обратно
        sb.reverse();
        System.out.println("5. reverse() обратно: " + sb); // Hello World
        
        // 6. deleteCharAt() - удаляет символ по индексу
        sb.deleteCharAt(5);
        System.out.println("6. deleteCharAt(5): " + sb); // HelloWorld
        
        // 7. replace() - заменяет часть строки
        sb.replace(0, 5, "Hi");
        System.out.println("7. replace(0,5,\"Hi\"): " + sb); // HiWorld
        
        // 8. length() - возвращает длину
        System.out.println("8. length(): " + sb.length()); // 7
        
        // 9. charAt() - возвращает символ по индексу
        System.out.println("9. charAt(2): " + sb.charAt(2)); // W
        
        // 10. setCharAt() - заменяет символ по индексу
        sb.setCharAt(2, 'L');
        System.out.println("10. setCharAt(2,'L'): " + sb); // HiLorld
        
        // 11. substring() - извлекает подстроку (не изменяет оригинал)
        String sub = sb.substring(2, 5);
        System.out.println("11. substring(2,5): " + sub); // Lor
        
        // 12. indexOf() - поиск подстроки
        System.out.println("12. indexOf(\"Lor\"): " + sb.indexOf("Lor")); // 2
        
        // 13. capacity() - возвращает текущую емкость
        System.out.println("13. capacity(): " + sb.capacity()); // 21
        
        // 14. setLength() - устанавливает новую длину
        sb.setLength(3);
        System.out.println("14. setLength(3): " + sb); // HiL
        
        // 15. toString() - преобразование в String
        String result = sb.toString();
        System.out.println("15. toString(): " + result); // HiL
    }
}
