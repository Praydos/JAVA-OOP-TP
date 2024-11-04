public class Evaluateur {
    public Evaluateur() {}

    public void verifierNote(int note)throws NoteInvalideException{
        if(note<0 || note>20){
            throw new NoteInvalideException(note);
        }

    }
}
