package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Декодирование файла, сжатого методом Хаффмана
 */
public class HuffmanDecoder {
    
    private static final int MAGIC_NUMBER = 0x4846464D;
    
    private String inputFile;
    private String outputFile;
    
    public HuffmanDecoder(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }
    
    public void decode() throws IOException {
        System.out.println("=== НАЧАЛО ДЕКОДИРОВАНИЯ ===");
        System.out.println("Входной файл: " + inputFile);
        System.out.println("Выходной файл: " + outputFile);
        
        try (BitInputStream bis = new BitInputStream(new FileInputStream(inputFile));
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            
            // Magic number
            int magic = 0;
            magic = (magic << 8) | bis.readByte();
            magic = (magic << 8) | bis.readByte();
            magic = (magic << 8) | bis.readByte();
            magic = (magic << 8) | bis.readByte();
            
            if (magic != MAGIC_NUMBER) {
                throw new IOException("Неверный формат файла! Magic number: 0x" + 
                                     Integer.toHexString(magic));
            }
            System.out.println("  Magic number верный: 0x" + Integer.toHexString(magic));
            
            // Оригинальный размер
            int originalSize = 0;
            originalSize = (originalSize << 8) | bis.readByte();
            originalSize = (originalSize << 8) | bis.readByte();
            originalSize = (originalSize << 8) | bis.readByte();
            originalSize = (originalSize << 8) | bis.readByte();
            System.out.println("  Ожидаемый размер: " + originalSize + " байт");
            
            // Размер словаря
            int dictSize = 0;
            dictSize = (dictSize << 8) | bis.readByte();
            dictSize = (dictSize << 8) | bis.readByte();
            System.out.println("  Размер словаря: " + dictSize);
            
            // Восстановление словаря
            System.out.println("\n  Чтение словаря...");
            Map<String, Integer> codeToSymbol = new HashMap<>();
            
            for (int i = 0; i < dictSize; i++) {
                int symbol = bis.readByte();
                int codeLength = bis.readByte();
                
                StringBuilder code = new StringBuilder();
                for (int j = 0; j < codeLength; j++) {
                    int bit = bis.readBit();
                    code.append(bit);
                }
                
                codeToSymbol.put(code.toString(), symbol);
                
                char ch = (char) symbol;
                if (ch >= 32 && ch <= 126) {
                    System.out.printf("    '%c' (код %d): %s%n", ch, symbol, code);
                } else {
                    System.out.printf("    код %d: %s%n", symbol, code);
                }
            }
            
            // Декодирование данных
            System.out.println("\n  Декодирование данных...");
            StringBuilder currentCode = new StringBuilder();
            int decodedCount = 0;
            
            while (decodedCount < originalSize) {
                int bit = bis.readBit();
                if (bit == -1) {
                    throw new IOException("Неожиданный конец файла");
                }
                
                currentCode.append(bit);
                
                if (codeToSymbol.containsKey(currentCode.toString())) {
                    int symbol = codeToSymbol.get(currentCode.toString());
                    fos.write(symbol);
                    decodedCount++;
                    currentCode.setLength(0);
                }
            }
            
            System.out.println("  Декодировано байт: " + decodedCount);
        }
        
        System.out.println("\n=== ДЕКОДИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}