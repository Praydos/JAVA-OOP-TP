import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("anas");
        list.add("dadas");
        list.add("boba");
        list.add("bobo");
        list.add("bob");

        List<String> filtredWords =  list.stream().filter(word -> word.contains("a")).toList();

        List<String> filtredLength = list.stream().filter(word -> word.length() > 3).toList();

    }
}