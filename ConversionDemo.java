public class ConversionDemo {
    public static void main(String[] args) {
        
        // ========== Исходные объекты ==========
        String str = "Java";
        StringBuilder sb = new StringBuilder("Python");
        StringBuffer sbf = new StringBuffer("C++");
        
        System.out.println("=== Исходные значения ===");
        System.out.println("String: " + str);
        System.out.println("StringBuilder: " + sb);
        System.out.println("StringBuffer: " + sbf);
        
        // ========== 1. String → StringBuilder ==========
        StringBuilder fromStringToSB = new StringBuilder(str);
        System.out.println("\n1. String → StringBuilder: " + fromStringToSB);
        
        // ========== 2. String → StringBuffer ==========
        StringBuffer fromStringToSBF = new StringBuffer(str);
        System.out.println("2. String → StringBuffer: " + fromStringToSBF);
        
        // ========== 3. StringBuilder → String ==========
        String fromSBToString = sb.toString();
        System.out.println("3. StringBuilder → String: " + fromSBToString);
        
        // ========== 4. StringBuilder → StringBuffer ==========
        StringBuffer fromSBToSBF = new StringBuffer(sb.toString());
        System.out.println("4. StringBuilder → StringBuffer: " + fromSBToSBF);
        
        // ========== 5. StringBuffer → String ==========
        String fromSBFToString = sbf.toString();
        System.out.println("5. StringBuffer → String: " + fromSBFToString);
        
        // ========== 6. StringBuffer → StringBuilder ==========
        StringBuilder fromSBFToSB = new StringBuilder(sbf.toString());
        System.out.println("6. StringBuffer → StringBuilder: " + fromSBFToSB);
        
        // ========== 7. String → String (через конструктор) ==========
        String strCopy = new String(str);
        System.out.println("7. String → String (копия): " + strCopy);
        
        // ========== 8. append() с разными типами ==========
        System.out.println("\n=== append() с разными типами ===");
        StringBuilder mixed = new StringBuilder();
        mixed.append(str).append(" + ").append(sb).append(" + ").append(sbf);
        System.out.println("Склеили все: " + mixed);
    }
}
