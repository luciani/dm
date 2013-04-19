package filesys;

import exception.*;


/**
 * Classe fichier 
 * @author LUCIANI Arnaud VASSOUT Vincent
 * @version 16/04/13
 */
public class Fichier extends FileSystem
{
    // instance variables - replace the example below with your own
    private int taille;

    /**
     * Constructor for objects of class Fichier
     */
    public Fichier(String nom, int taille) throws TailleFichierException, FileSystemNullException
    {
        // initialise instance variables
        super(nom,"file");
        if(nom.equals(null)) throw new FileSystemNullException();
        if(taille >= 0)
        	this.taille = taille;
        else throw new TailleFichierException();
    }
 
    /** 
     * taille
     * 
     * @return     la taille du fichier
     */
    public int taille()
    {
        return this.taille;
    }
    
    public String get_nom()
    {
    	return super.get_nom();
    }

    public String get_type()
    {
    	return "file";
    }
}
