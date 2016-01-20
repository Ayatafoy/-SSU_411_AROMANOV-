import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int year, month, k = 0, i = 0;
        for(;;){
            System.out.println("Введите год:");
            Scanner scanner = new Scanner(System.in);
            year = Integer.parseInt(scanner.nextLine());
            if (year > 1800 && year < 2020){
                for(;;) {
                    System.out.println("Введите месяц:");
                    scanner = new Scanner(System.in);
                    month = Integer.parseInt(scanner.nextLine());
                    if (month >= 0 && month < 12) {
                        break;
                    }
                }
                break;
            }
        }
        Calendar calendar = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        for(;;){
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, 13);
            if(now.before(calendar))
                break;
            String day_of_week = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
            if (day_of_week.contains("Fri")){
                System.out.println(year);
                k++;
            }
            year += 1;
        }
        System.out.println("Число пятниц 13го в " + month + " месяце среди годов выделенного диапазона: " + k);
    }
}