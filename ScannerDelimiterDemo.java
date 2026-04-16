import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDelimiterDemo {
    public static void main(String[] args) {
        // Содержимое файла: "Иван,25,Тюмень"
        File file = new File("person.txt");
        
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(",");  // устанавливаем разделитель
            
            String name = scanner.next();
            int age = scanner.nextInt();
            String city = scanner.next();
            
            System.out.println("Имя: " + name);
            System.out.println("Возраст: " + age);
            System.out.println("Город: " + city);
            
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}