import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashSet<String> groupA = new HashSet<>();
        HashSet<String> groupB = new HashSet<>();
        // ajoute des element
        groupA.add("anas");
        groupA.add("dadas");
        groupB.add("boba");
        groupB.add("dadas");
        //affiche des sets
        System.out.println("Groupe A :"+groupA);
        System.out.println("Groupe B "+groupB);
        //union des sets
        HashSet<String> union = new HashSet<>(groupA);
        union.addAll(groupB);
        System.out.println("union :"+union);
        //intersection des sets
        HashSet<String> intersection = new HashSet<>(groupA);
        intersection.retainAll(groupB);
        System.out.println("intersection :"+intersection);


    }
}