package src;

import java.io.IOException;

/**
 * Главный класс программы сжатия/распаковки методом Хаффмана
 * 
 * Использование:
 *   Кодирование: java src.Huffman encode input.txt output.huff
 *   Декодирование: java src.Huffman decode output.huff decoded.txt
 */
public class Huffman {
    
    public static void main(String[] args) {
        if (args.length < 3) {
            printUsage();
            return;
        }
        
        String command = args[0];
        String inputFile = args[1];
        String outputFile = args[2];
        
        try {
            if (command.equalsIgnoreCase("encode")) {
                HuffmanEncoder encoder = new HuffmanEncoder(inputFile, outputFile);
                encoder.encode();
            } 
            else if (command.equalsIgnoreCase("decode")) {
                HuffmanDecoder decoder = new HuffmanDecoder(inputFile, outputFile);
                decoder.decode();
            }
            else {
                System.out.println("Неизвестная команда: " + command);
                printUsage();
            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void printUsage() {
        System.out.println("Использование:");
        System.out.println("  Кодирование: java src.Huffman encode <входной файл> <выходной файл>");
        System.out.println("  Декодирование: java src.Huffman decode <входной файл> <выходной файл>");
        System.out.println("\nПримеры:");
        System.out.println("  java src.Huffman encode test1.txt compressed.huff");
        System.out.println("  java src.Huffman decode compressed.huff decompressed.txt");
    }
}