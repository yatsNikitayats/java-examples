package src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class HuffmanEncoder {
    
    private static final int MAGIC_NUMBER = 0x4846464D;
    
    private String inputFile;
    private String outputFile;
    private FrequencyTable freqTable;
    private HuffmanTree huffmanTree;
    private Map<Integer, String> codes;
    
    public HuffmanEncoder(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.freqTable = new FrequencyTable();
    }
    
    public void encode() throws IOException {
        System.out.println("=== НАЧАЛО КОДИРОВАНИЯ ===");
        System.out.println("Входной файл: " + inputFile);
        System.out.println("Выходной файл: " + outputFile);
        
        System.out.println("\n1. Подсчет частот символов...");
        freqTable.countFromFile(inputFile);
        freqTable.printStats();
        
        System.out.println("\n2. Построение дерева Хаффмана...");
        huffmanTree = new HuffmanTree(freqTable);
        codes = huffmanTree.getAllCodes();
        huffmanTree.printStats();
        
        System.out.println("\n3. Запись закодированного файла...");
        writeEncodedFile();
        
        System.out.println("\n=== КОДИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
    
    private void writeEncodedFile() throws IOException {
        try (BitOutputStream bos = new BitOutputStream(new FileOutputStream(outputFile));
             FileInputStream fis = new FileInputStream(inputFile)) {
            
            // 1. Magic number
            bos.writeByte((MAGIC_NUMBER >> 24) & 0xFF);
            bos.writeByte((MAGIC_NUMBER >> 16) & 0xFF);
            bos.writeByte((MAGIC_NUMBER >> 8) & 0xFF);
            bos.writeByte(MAGIC_NUMBER & 0xFF);
            System.out.println("  Magic number: 0x" + Integer.toHexString(MAGIC_NUMBER));
            
            // 2. Оригинальный размер
            int originalSize = freqTable.getTotalSymbols();
            bos.writeByte((originalSize >> 24) & 0xFF);
            bos.writeByte((originalSize >> 16) & 0xFF);
            bos.writeByte((originalSize >> 8) & 0xFF);
            bos.writeByte(originalSize & 0xFF);
            System.out.println("  Оригинальный размер: " + originalSize + " байт");
            
            // 3. Размер словаря (исключая фиктивный символ -1)
            int dictSize = 0;
            for (int symbol : codes.keySet()) {
                if (symbol != -1) dictSize++;
            }
            bos.writeByte((dictSize >> 8) & 0xFF);
            bos.writeByte(dictSize & 0xFF);
            System.out.println("  Размер словаря: " + dictSize);
            
            // 4. Словарь
            System.out.println("\n  Запись словаря:");
            for (Map.Entry<Integer, String> entry : codes.entrySet()) {
                int symbol = entry.getKey();
                if (symbol == -1) continue;  // пропускаем фиктивный символ
                
                String code = entry.getValue();
                int codeLength = code.length();
                
                bos.writeByte(symbol);
                bos.writeByte(codeLength);
                
                for (char c : code.toCharArray()) {
                    bos.writeBit(c == '1' ? 1 : 0);
                }
                
                char ch = (char) symbol;
                if (ch >= 32 && ch <= 126) {
                    System.out.printf("    '%c' → %s%n", ch, code);
                } else {
                    System.out.printf("    код %d → %s%n", symbol, code);
                }
            }
            
            // 5. Данные
            System.out.println("\n  Запись закодированных данных...");
            int b;
            int totalBits = 0;
            while ((b = fis.read()) != -1) {
                String code = codes.get(b);
                if (code == null) {
                    throw new IOException("Нет кода для символа: " + b);
                }
                for (char c : code.toCharArray()) {
                    bos.writeBit(c == '1' ? 1 : 0);
                    totalBits++;
                }
            }
            System.out.println("  Записано бит: " + totalBits);
        }
    }
}