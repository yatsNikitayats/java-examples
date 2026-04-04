public class StringBuilderDemo {
    public static void main(String[] args) {
        
        // Создание StringBuilder
        StringBuilder sb = new StringBuilder("Java");
        
        // 1. append() - добавляет строку в конец
        sb.append(" Programming");
        System.out.println("1. append(): " + sb); // Java Programming
        
        // 2. insert() - вставляет строку в указанную позицию
        sb.insert(4, " (язык)");
        System.out.println("2. insert(): " + sb); // Java (язык) Programming
        
        // 3. delete() - удаляет символы от start до end
        sb.delete(4, 12);
        System.out.println("3. delete(): " + sb); // Java Programming
        
        // 4. deleteCharAt() - удаляет символ по индексу
        sb.deleteCharAt(4);
        System.out.println("4. deleteCharAt(): " + sb); // JavaProgramming
        
        // 5. replace() - заменяет часть строки
        sb.replace(0, 4, "Python");
        System.out.println("5. replace(): " + sb); // PythonProgramming
        
        // 6. reverse() - переворачивает строку
        sb.reverse();
        System.out.println("6. reverse(): " + sb); // gnimmargorPnohtyP
        
        sb.reverse(); // возвращаем обратно
        System.out.println("   обратно: " + sb); // PythonProgramming
        
        // 7. substring() - извлекает подстроку (не изменяет оригинал)
        String sub = sb.substring(6, 10);
        System.out.println("7. substring(6,10): " + sub); // Prog
        
        // 8. length() - возвращает длину
        System.out.println("8. length(): " + sb.length()); // 17
        
        // 9. capacity() - возвращает текущую емкость
        System.out.println("9. capacity(): " + sb.capacity()); // 20 (изначально 16+4)
        
        // 10. setLength() - устанавливает новую длину
        sb.setLength(6);
        System.out.println("10. setLength(6): " + sb); // Python
        
    }
}
