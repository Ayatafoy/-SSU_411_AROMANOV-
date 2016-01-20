import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';

    }

    static int priority(char oper) {
        if (oper == '^') {
            return 2;
        }
        if (oper == '*' || oper == '/') {
            return 1;
        }
        else if (oper == '+' || oper == '-') {
            return 0;
        }
        else {
            return -1;
        }
    }

    static void make(LinkedList<Integer> st, char oper) {
        int one = st.removeLast();
        int two = st.removeLast();
        switch (oper) {
            case '+':
                st.add(two + one);
                break;
            case '-':
                st.add(two - one);
                break;
            case '*':
                st.add(two * one);
                break;
            case '/':
                st.add(two / one);
                break;
            case '^':
                st.add((int) Math.pow((double)two, (double)one));
                break;
            default:
                System.out.println("Operator not found!");
        }
    }

    public static void main(String[] args) {
        String a = "0123456789^*/+-()";
        System.out.println("Введите выражение:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if (a.indexOf(c) != -1)
                i++;
            else {
                System.out.println("Введеное вами выражение содержит недопустимые символы, пожалуйста, введите" +
                        " выражение заново:");
                scanner = new Scanner(System.in);
                s = scanner.nextLine();
                i = 0;
            }
        }
        if (s.contains("Close")) {
            System.exit(0);
        } else {
            LinkedList<Integer> chisla = new LinkedList<>();
            LinkedList<Character> operatory = new LinkedList<>();
            for (i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    operatory.add('(');

                } else if (c == ')') {
                    while (operatory.getLast() != '(') {
                        make(chisla, operatory.removeLast());
                    }
                    operatory.removeLast();

                } else if (isOperator(c)) {
                    while (!operatory.isEmpty() &&
                            priority(operatory.getLast()) >= priority(c)) {
                        make(chisla, operatory.removeLast());

                    }
                    operatory.add(c);
                } else {
                    String operand = "";
                    while (i < s.length() &&
                            Character.isDigit(s.charAt(i))) {

                        operand += s.charAt(i++);
                    }
                    --i;
                    chisla.add(Integer.parseInt(operand));

                }
            }
            while (!operatory.isEmpty()) {

                make(chisla, operatory.removeLast());
            }
            System.out.println(chisla.get(0));
        }
    }
}