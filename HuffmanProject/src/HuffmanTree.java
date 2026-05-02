package src;

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

/**
 * Построение дерева Хаффмана и генерация кодов
 */
public class HuffmanTree {
    
    private Node root;
    private Map<Integer, String> huffmanCodes;
    private FrequencyTable freqTable;
    
    public HuffmanTree(FrequencyTable freqTable) {
        this.freqTable = freqTable;
        this.huffmanCodes = new HashMap<>();
        buildTree();
        generateCodes();
    }
    
    private void buildTree() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        for (int i = 0; i < 256; i++) {
            int freq = freqTable.getFrequency(i);
            if (freq > 0) {
                queue.add(new Node(i, freq));
                System.out.println("  Добавлен символ " + i + " (частота=" + freq + ")");
            }
        }
        
        if (queue.isEmpty()) {
            throw new RuntimeException("Файл пуст, нечего кодировать");
        }
        
        if (queue.size() == 1) {
            System.out.println("  Только один символ, добавляем фиктивный узел");
            Node onlyNode = queue.poll();
            Node dummy = new Node(-1, 0);
            queue.add(new Node(onlyNode, dummy));
        }
        
        System.out.println("\n  Построение дерева:");
        int step = 1;
        
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            
            System.out.println("    Шаг " + step + ": объединяем freq=" + left.getFrequency() +
                             " и freq=" + right.getFrequency() + " -> сумма=" + 
                             (left.getFrequency() + right.getFrequency()));
            
            Node parent = new Node(left, right);
            queue.add(parent);
            step++;
        }
        
        root = queue.poll();
        System.out.println("    Корень дерева имеет частоту: " + root.getFrequency());
    }
    
    private void generateCodes() {
        if (root == null) return;
        generateCodesRecursive(root, "");
    }
    
    private void generateCodesRecursive(Node node, String code) {
    if (node.isLeaf()) {
        // Сохраняем код для символа (включая dummy с symbol = -1)
        huffmanCodes.put(node.getSymbol(), code);
        
        // Выводим информацию только для реальных символов (не dummy)
        if (node.getSymbol() != -1) {
            char c = (char) node.getSymbol();
            if (c >= 32 && c <= 126) {
                System.out.println("    Символ '" + c + "' (код " + node.getSymbol() +
                                 ") → " + code + " (длина=" + code.length() + ")");
            } else {
                System.out.println("    Символ " + node.getSymbol() +
                                 " → " + code + " (длина=" + code.length() + ")");
            }
        } else {
            System.out.println("    Фиктивный символ -1 → " + code + " (НЕ БУДЕТ В СЛОВАРЕ)");
        }
        return;
    }
    
    generateCodesRecursive(node.getLeft(), code + "0");
    generateCodesRecursive(node.getRight(), code + "1");
}
    
    public String getCode(int symbol) {
        return huffmanCodes.get(symbol);
    }
    
    public Node getRoot() {
        return root;
    }
    
    public Map<Integer, String> getAllCodes() {
        return huffmanCodes;
    }
    
    public void printStats() {
        System.out.println("\n=== СТАТИСТИКА КОДОВ ХАФФМАНА ===");
        System.out.println("Количество уникальных символов: " + huffmanCodes.size());
        
        int minLen = Integer.MAX_VALUE;
        int maxLen = 0;
        int totalBits = 0;
        
        for (Map.Entry<Integer, String> entry : huffmanCodes.entrySet()) {
            int symbol = entry.getKey();
            String code = entry.getValue();
            int freq = freqTable.getFrequency(symbol);
            int len = code.length();
            
            if (len < minLen) minLen = len;
            if (len > maxLen) maxLen = len;
            totalBits += freq * len;
        }
        
        System.out.println("Минимальная длина кода: " + minLen + " бит");
        System.out.println("Максимальная длина кода: " + maxLen + " бит");
        System.out.println("Общее количество бит после сжатия: " + totalBits);
        
        int originalBits = freqTable.getTotalSymbols() * 8;
        double compression = (double) totalBits / originalBits * 100;
        System.out.printf("Коэффициент сжатия: %.1f%% (было %d бит, стало %d бит)%n",
                         compression, originalBits, totalBits);
    }
}