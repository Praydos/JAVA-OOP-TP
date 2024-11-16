import java.util.HashMap;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import java.util.Map;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // creation du map
        HashMap<String, Double> map = new HashMap<>();

        // ajoute des element en map
        map.put("dadas",20.0);
        map.put("chafik",15.0);
        map.put("boba",18.0);

        map.forEach((key,value)->{
            System.out.println("nom : "+key+", note : "+value);
        });
        System.out.println();

        //augmentation dun note dun etudiant
        if(map.containsKey("boba")){
            double note = map.get("boba");
            if(note<20)
                map.put("boba",note+1.0);

            map.forEach((key,value)->{
                System.out.println("nom : "+key+", note : "+value);
            });
        }
        System.out.println();


        //la taille
        System.out.println("la taille du map est : "+ map.size());

        // la note moyenne finale et max/min
        double noteMoy =0;
        double noteMax =0;
        double noteMin =0;
        for(Map.Entry<String, Double> entry : map.entrySet()){
            noteMoy += entry.getValue();
            noteMax = Math.max(noteMax, entry.getValue());
            noteMin = Math.min(noteMin, entry.getValue());

        }
        noteMoy = noteMoy/map.size();

        map.forEach((key,value)->{
            System.out.println("nom : "+key+", note : "+value);
        });


        System.out.printf(" note moyenne : %.2f, Max %.2f :, Min %.2f :",noteMoy,noteMax,noteMin);

        //check if it contains a note = 20

        if(map.containsValue(20.0)){
           System.out.println("la note 20 existe");
        } else {
            System.out.println("la note 20 no existe");
        }


    }
}