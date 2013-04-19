package exception;

public class RepertoirePleinException extends Exception{
	public RepertoirePleinException(){
		super("Impossible d'ajouter un Fichier ou un Repertoire");
	}
}