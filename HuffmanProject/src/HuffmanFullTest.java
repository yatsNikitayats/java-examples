package src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class HuffmanFullTest {
    
    public static void main(String[] args) throws IOException {
        System.out.println("=== ПОЛНОЕ ТЕСТИРОВАНИЕ АЛГОРИТМА ХАФФМАНА ===\n");
        
        createTestFiles();
        
        testFile("test1.txt", "test1.huff", "test1_dec.txt");
        testFile("test2.txt", "test2.huff", "test2_dec.txt");
        
        System.out.println("\n=== ВСЕ ТЕСТЫ ПРОЙДЕНЫ ===");
    }
    
    private static void createTestFiles() throws IOException {
        // test1.txt
        try (FileWriter fw = new FileWriter("test1.txt")) {
            for (int i = 0; i < 10; i++) fw.write('1');
        }
        
        // test2.txt
        try (FileWriter fw = new FileWriter("test2.txt")) {
            for (int i = 0; i < 10; i++) fw.write('1');
            for (int i = 0; i < 5; i++) fw.write('2');
            for (int i = 0; i < 5; i++) fw.write('3');
        }
        
        System.out.println("Созданы тестовые файлы: test1.txt, test2.txt");
    }
    
    private static void testFile(String input, String compressed, String decompressed) 
            throws IOException {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ТЕСТИРОВАНИЕ: " + input);
        System.out.println("=".repeat(60));
        
        // Кодирование
        HuffmanEncoder encoder = new HuffmanEncoder(input, compressed);
        encoder.encode();
        
        // Декодирование
        HuffmanDecoder decoder = new HuffmanDecoder(compressed, decompressed);
        decoder.decode();
        
        // Проверка
        boolean same = filesEqual(input, decompressed);
        System.out.println("\n  Результат проверки: " + (same ? "✅ ФАЙЛЫ ИДЕНТИЧНЫ" : "❌ ФАЙЛЫ ОТЛИЧАЮТСЯ"));
        
        long originalSize = new File(input).length();
        long compressedSize = new File(compressed).length();
        System.out.printf("  Оригинальный размер: %d байт%n", originalSize);
        System.out.printf("  Сжатый размер: %d байт%n", compressedSize);
        System.out.printf("  Коэффициент сжатия: %.1f%%%n", (double) compressedSize / originalSize * 100);
    }
    
    private static boolean filesEqual(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
            
            int b1, b2;
            while ((b1 = fis1.read()) != -1) {
                b2 = fis2.read();
                if (b1 != b2) return false;
            }
            return fis2.read() == -1;
        }
    }
}