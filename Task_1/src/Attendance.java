import java.util.ArrayList;
import java.util.Date;

public class Attendance{
    static Group group;
    static Subject subject;
    static ArrayList<Date> dats;
    static ArrayList<ArrayList<Integer>> pos;

    Attendance(Group group1, Subject subject1, ArrayList<Date> dats1, ArrayList<ArrayList<Integer>> pos1){
        group = group1;
        subject = subject1;
        dats = dats1;
        pos = pos1;
    }

    void printGroupPos(){
        System.out.println(subject.name);
        System.out.print(group.Fakultet + "   " + group.Number + "\n");
        System.out.print("                              ");
        for (int i = 0; i < dats.size(); i++) {
            System.out.print(dats.get(i) + "   ");
        }
        System.out.println("\n");
        for (int i = 0; i < group.list.size(); i++) {
            int size = group.list.get(i).FirstName.length() + group.list.get(i).LastName.length() + 1;
            System.out.print(group.list.get(i).LastName + " " + group.list.get(i).FirstName);
            for (int j = 0; j < 30 - size; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < dats.size(); j++) {
                System.out.print(pos.get(j).get(i) + "                              ");
            }
            System.out.println("\n");
        }
    }

    boolean existsStudent(Student student, Date date){
        int posStud = 0, posDate = 0;
        for (int i = 0; i < group.list.size(); i++){
            posStud = group.list.indexOf(student);
        }
        for (int i = 0; i < dats.size(); i++){
            posDate = dats.indexOf(date);
        }
        int res = pos.get(posDate).get(posStud);
        if (res == 0){
            return false;
        }
        else
            return true;
    }

    int skipCountStud(Student student){
        int posStud = 0, presenceCount = 0;
        for (int i = 0; i < group.list.size(); i++){
            posStud = group.list.indexOf(student);
        }
        for (int i = 0; i < pos.size(); i++){
            presenceCount += pos.get(i).get(posStud);
        }
        return dats.size() - presenceCount;
    }

    void printGroupSkip(){
        for (int i = 0; i < group.list.size(); i++) {
            int presenceCount = 0;
            int size = group.list.get(i).FirstName.length() + group.list.get(i).LastName.length() + 1;
            System.out.print(group.list.get(i).LastName + " " + group.list.get(i).FirstName + ":");
            for (int j = 0; j < 30 - size; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < dats.size(); j++) {
                int posStud = 0;
                for (int k = 0; k < group.list.size(); k++){
                    posStud = group.list.indexOf(group.list.get(i));
                }
                presenceCount += pos.get(j).get(posStud);
            }
            System.out.println(dats.size() - presenceCount + "\n");
        }
    }
}