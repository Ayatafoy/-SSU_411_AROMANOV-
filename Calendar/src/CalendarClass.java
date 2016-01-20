import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class CalendarClass {
     public static void main(String[] args) throws IOException {
        int year, k = 0;
        for(;;){
            System.out.println("Введите год:");
            Scanner scanner = new Scanner(System.in);
             year = Integer.parseInt(scanner.nextLine());
            if (year > 1800 && year < 2020)
                break;
        }
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 12; i++){
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, i);
            calendar.set(Calendar.DAY_OF_MONTH, 13);
            String day_of_week = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
            if (day_of_week.contains("Fri")){
                System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US));
                k++;
            }
        }
        System.out.println("Число пятниц 13го в " + year + " году: " + k);
    }
}