import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamDemo {
    public static void main(String[] args) {
        // Создаем временный файл для демонстрации
        String fileName = "test.txt";
        
        // Сначала запишем что-нибудь в файл
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write("Hello".getBytes());
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
        
        // Демонстрация read()
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int data;
            System.out.println("Содержимое файла:");
            while ((data = fis.read()) != -1) {  // read() возвращает байт или -1
                System.out.print((char) data);   // преобразуем байт в символ
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }
}