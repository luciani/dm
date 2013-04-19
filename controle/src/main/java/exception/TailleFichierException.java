package exception;

public class TailleFichierException extends Exception{

	public TailleFichierException(){
		super("Impossible de creer un Fichier de taille negative");
	}
}
