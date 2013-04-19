package exception;

public class FileSystemNullException extends Exception{
	public FileSystemNullException(){
		super("Impossible de creer un Fichier ou un Repertoire sans nom");
	}
}
