import java.util.Date;
import java.util.Calendar;

public class DateTimeFormatDemo {
    public static void main(String[] args) {
        
        // Создаем текущую дату и время
        Date now = new Date();
        
        System.out.println("=== ПРАКТИКА #3: Форматирование даты и времени ===\n");
        
        // 1. %tH - час (00-23)
        System.out.printf("1. %%tH: Час (00-23): %tH%n", now);
        
        // 2. %tI - час (01-12)
        System.out.printf("2. %%tI: Час (01-12): %tI%n", now);
        
        // 3. %tM - минуты (00-59)
        System.out.printf("3. %%tM: Минуты: %tM%n", now);
        
        // 4. %tS - секунды (00-59)
        System.out.printf("4. %%tS: Секунды: %tS%n", now);
        
        // 5. %tY - год (4 цифры)
        System.out.printf("5. %%tY: Год (4 цифры): %tY%n", now);
        
        // 6. %ty - год (2 цифры)
        System.out.printf("6. %%ty: Год (2 цифры): %ty%n", now);
        
        // 7. %tB - полное название месяца
        System.out.printf("7. %%tB: Месяц: %tB%n", now);
        
        // 8. %tm - месяц как число (01-12)
        System.out.printf("8. %%tm: Месяц (число): %tm%n", now);
        
        // 9. %tA - полное название дня недели
        System.out.printf("9. %%tA: День недели: %tA%n", now);
        
        // 10. %tL - миллисекунды (000-999)
        System.out.printf("10. %%tL: Миллисекунды: %tL%n", now);
        
        // 11. %td - день месяца (01-31)
        System.out.printf("11. %%td: День месяца: %td%n", now);
        
        // Комбинированное форматирование
        System.out.println("\n=== Комбинированное форматирование ===");
        
        // Полная дата
        System.out.printf("Дата: %td.%tm.%tY%n", now, now, now);
        
        // Время
        System.out.printf("Время: %tH:%tM:%tS%n", now, now, now);
        
        // День недели, число месяц год
        System.out.printf("%tA, %td %tB %tY%n", now, now, now, now);
        
        // Час с AM/PM
        System.out.printf("%tI:%tM %Tp%n", now, now, now);
    }
}