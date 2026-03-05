
    public class Logger {
    
    // Простой лог с одним сообщением
    public static void log(String message) {
        System.out.println("[LOG] " + message);
    }
    
    // Лог с сообщением и дополнительными деталями
    public static void log(String message, String... details) {
        System.out.println("[LOG] " + message);
        if (details.length > 0) {
            System.out.println("Детали:");
            for (String detail : details) {
                System.out.println("  - " + detail);
            }
        }
    }
    
    // Лог с сообщением и уровнем важности
    public static void log(String level, String message, String... tags) {
        System.out.println("[" + level + "] " + message);
        if (tags.length > 0) {
            System.out.println("Теги: " + String.join(", ", tags));
        }
    }
    
    public static void main(String[] args) {
        log("Старт программы");
        //log("Ошибка", "файл не найден", "проверьте путь"); //ошибка
       // log("WARNING", "Низкий заряд батареи", "ноутбук", "зарядка");
    }
}

