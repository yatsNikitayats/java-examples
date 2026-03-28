public class stringmethodDemo {
     public static void main(String[] args) {
        String str = "  Java Programming Language  ";
        String str2 = "Java";
        
        // 1. length() - возвращает длину строки
        System.out.println("1. length(): " + str.length()); // 30
        
        // 2. charAt() - возвращает символ по индексу
        System.out.println("2. charAt(5): " + str.charAt(5)); // 'P'
        
        // 3. trim() - удаляет пробелы в начале и конце
        System.out.println("3. trim(): '" + str.trim() + "'");
        
        // 4. toUpperCase() / toLowerCase() - изменение регистра
        System.out.println("4. toUpperCase(): " + str.toUpperCase());
        System.out.println("   toLowerCase(): " + str.toLowerCase());
        
        // 5. substring() - извлекает часть строки
        System.out.println("5. substring(2, 6): " + str.substring(2, 6)); // "Java"
        
        // 6. indexOf() - поиск индекса подстроки
        System.out.println("6. indexOf('Java'): " + str.indexOf("Java")); // 2
        System.out.println("   lastIndexOf('a'): " + str.lastIndexOf('a')); // 24
        
        // 7. replace() - замена символов или подстрок
        System.out.println("7. replace('a', 'o'): " + str.replace('a', 'o'));
        System.out.println("   replace('Java', 'Python'): " + str.replace("Java", "Python"));
        
        // 8. startsWith() / endsWith() - проверка начала и конца
        System.out.println("8. startsWith('  Ja'): " + str.startsWith("  Ja")); // true
        System.out.println("   endsWith('ge  '): " + str.endsWith("ge  ")); // true
        
        // 9. split() - разбивает строку на массив
        String[] words = str.trim().split(" ");
        System.out.println("9. split(): " + java.util.Arrays.toString(words));
        
        // 10. equals() / equalsIgnoreCase() - сравнение строк
        System.out.println("10. equals('Java'): " + str2.equals("Java")); // true
        System.out.println("    equalsIgnoreCase('JAVA'): " + str2.equalsIgnoreCase("JAVA")); // true
        
        // 11. isEmpty() / isBlank() - проверка на пустоту
        String empty = "";
        String blank = "   ";
        System.out.println("11. isEmpty(): " + empty.isEmpty()); // true
        System.out.println("    isBlank(): " + blank.isBlank()); // true
        
        // 12. join() - объединение строк
        String joined = String.join("-", "2024", "12", "25");
        System.out.println("12. join(): " + joined); // 2024-12-25
    }
}
