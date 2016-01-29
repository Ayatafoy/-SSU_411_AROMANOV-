import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger("Main");

    public static void main(String args[]) throws IOException {
        int k = 0;
        File dir = new File("C:\\Users\\Алексей\\IdeaProjects\\CompanyesBuget\\Resources");
        String fileList[] = dir.list();
        HashMap<String, Pair> map = new HashMap();
        ArrayList<String[]> rows = new ArrayList<>();
        for (int i = 0; i < fileList.length; i++) {
            File f = new File(dir + "\\" + fileList[i]);
            if (!f.isDirectory()) {
                CSVReader reader = new CSVReader(new FileReader(f));
                if (fileList[i].charAt(0) == 'B') {
                    List<String[]> row = reader.readAll();
                    reader.close();
                    String companyName = "";
                    String checkingAccount = "";
                    String budget = "";
                    for (int j = 1; j < row.size(); j++) {
                        while (row.get(j)[0].charAt(k) != ';') {
                            companyName += row.get(j)[0].charAt(k);
                            k++;
                        }
                        k++;
                        while (row.get(j)[0].charAt(k) != ';') {
                            checkingAccount += row.get(j)[0].charAt(k);
                            k++;
                        }
                        k++;
                        while (k < row.get(j)[0].length()) {
                            budget += row.get(j)[0].charAt(k);
                            k++;
                        }
                        Pair pair = new Pair(companyName, budget);
                        map.put(checkingAccount, pair);
                        k = 0;
                        companyName = "";
                        checkingAccount = "";
                        budget = "";
                    }
                } else {
                    if (fileList[i].charAt(0) == 'T') {
                        List<String[]> row = reader.readAll();
                        reader.close();
                        String companyName1 = "";
                        String checkingAccountSend = "";
                        String companyName2 = "";
                        String checkingAccountRec = "";
                        String summ = "";
                        for (int j = 1; j < row.size(); j++) {
                            while (row.get(j)[0].charAt(k) != ';') {
                                companyName1 += row.get(j)[0].charAt(k);
                                k++;
                            }
                            k++;
                            while (row.get(j)[0].charAt(k) != ';') {
                                checkingAccountSend += row.get(j)[0].charAt(k);
                                k++;
                            }
                            k++;
                            while (row.get(j)[0].charAt(k) != ';') {
                                companyName2 += row.get(j)[0].charAt(k);
                                k++;
                            }
                            k++;
                            while (row.get(j)[0].charAt(k) != ';') {
                                checkingAccountRec += row.get(j)[0].charAt(k);
                                k++;
                            }
                            k++;
                            while (k < row.get(j)[0].length()) {
                                summ += row.get(j)[0].charAt(k);
                                k++;
                            }
                            rows.add(new String[]{companyName1, checkingAccountSend,
                                    companyName2, checkingAccountRec, summ});
                            k = 0;
                            companyName1 = "";
                            checkingAccountSend = "";
                            companyName2 = "";
                            checkingAccountRec = "";
                            summ = "";
                        }
                    }
                }

            } else
                continue;
        }
        for (int i = 0; i < rows.size(); i++) {
            String checkingAccount = rows.get(i)[1];
            String companyName = (String) map.get(checkingAccount).first;
            int budget = Integer.parseInt((String) map.get(checkingAccount).second);
            int ostatok = budget - Integer.parseInt(rows.get(i)[4]);
            if (ostatok >= 0) {
                map.replace(checkingAccount, new Pair(companyName, Integer.toString(ostatok)));
                checkingAccount = rows.get(i)[3];
                companyName = (String) map.get(checkingAccount).first;
                budget = Integer.parseInt((String) map.get(checkingAccount).second);
                map.replace(checkingAccount,
                        new Pair(companyName, Integer.toString(budget + Integer.parseInt(rows.get(i)[4]))));
            } else
                log.info("Остаток средств на счете компании " + companyName + ": " + budget +
                        "\n Попытка отправить " + Integer.parseInt(rows.get(i)[4]) + " рублей" +
                        "компании " + map.get(rows.get(i)[3]).first);
        }
        ArrayList<String[]> result = new ArrayList<>();
        for (HashMap.Entry<String, Pair> entry : map.entrySet())
            result.add(new String[]{entry.getValue().first + ";" + entry.getKey() + ";" + entry.getValue().second +
                    "\n"});
        File f = new File(dir + "\\" + "Result.csv");
        FileWriter out = new FileWriter(f);
        out.write("Название компании;Расчетный счет;Бюджет\n");
        for (int i = 0; i < result.size(); i++)
            out.write(result.get(i)[0]);
        out.close();
    }
}
