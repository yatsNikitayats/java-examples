import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo {
    public static void main(String[] args) {
        String fileName = "output.txt";
        
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            // write(int) - записывает один байт (младшие 8 бит)
            fos.write(72);  // 'H'
            fos.write(101); // 'e'
            fos.write(108); // 'l'
            fos.write(108); // 'l'
            fos.write(111); // 'o'
            
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }
}