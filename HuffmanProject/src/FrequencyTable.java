package src;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Подсчет частот символов во входном файле
 */
public class FrequencyTable {
    
    private static final int SYMBOL_COUNT = 256;
    private int[] frequencies;
    private int totalSymbols;
    
    public FrequencyTable() {
        frequencies = new int[SYMBOL_COUNT];
        totalSymbols = 0;
    }
    
    public void countFromFile(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            int b;
            while ((b = fis.read()) != -1) {
                frequencies[b]++;
                totalSymbols++;
            }
        }
    }
    
    public int getFrequency(int symbol) {
        if (symbol < 0 || symbol >= SYMBOL_COUNT) {
            return 0;
        }
        return frequencies[symbol];
    }
    
    public int getTotalSymbols() {
        return totalSymbols;
    }
    
    public int getUniqueSymbolsCount() {
        int count = 0;
        for (int i = 0; i < SYMBOL_COUNT; i++) {
            if (frequencies[i] > 0) {
                count++;
            }
        }
        return count;
    }
    
    public void printStats() {
        System.out.println("=== СТАТИСТИКА ЧАСТОТ ===");
        System.out.println("Всего символов: " + totalSymbols);
        System.out.println("Уникальных символов: " + getUniqueSymbolsCount());
        System.out.println("\nСимволы с частотами > 0:");
        for (int i = 0; i < SYMBOL_COUNT; i++) {
            if (frequencies[i] > 0) {
                char c = (char) i;
                if (c >= 32 && c <= 126) {
                    System.out.printf("  '%c' (код %d): %d%n", c, i, frequencies[i]);
                } else {
                    System.out.printf("  код %d: %d%n", i, frequencies[i]);
                }
            }
        }
    }
}