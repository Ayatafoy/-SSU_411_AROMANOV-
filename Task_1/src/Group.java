import java.util.List;

public class Group{
    String Fakultet;
    String Number;
    List<Student> list;

    Group(String Fakultet, String Number, List<Student> list){
        this.Fakultet = Fakultet;
        this.Number = Number;
        this.list = list;
    }
}