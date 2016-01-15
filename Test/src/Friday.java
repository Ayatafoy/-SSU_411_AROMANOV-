import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Friday {
    public static void main(String[] args) throws IOException {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 13);
        System.out.println(calendar.getTime());
        String a = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
        System.out.println(a);
        Scanner scanner = new Scanner(System.in);
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println(b);
        System.out.println(b-10);
    }
}
