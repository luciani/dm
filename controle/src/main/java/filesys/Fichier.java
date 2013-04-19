package filesys;

import exception.*;


/**
 * Classe fichier 
 * @author LUCIANI Arnaud VASSOUT Vincent
 * @version 16/04/13
 */
public class Fichier extends FileSystem
{
    private int taille;

    /**
     * Constructeur d'objets fichier
     * 
     * @param taille donné au fichier
     * @param nom du fichier
     * @exception TailleFichierException si la taille donnée est négative
     * @exception FileSystemNullException si le nom donné au fichier est vide
     */
    public Fichier(String nom, int taille) throws TailleFichierException, FileSystemNullException
    {
        super(nom,"file");
        if(nom.equals(null)) throw new FileSystemNullException();
        if(taille >= 0)
        	this.taille = taille;
        else throw new TailleFichierException();
    }
 
    /** 
     * 	Permet de connaître la taille
     * 
     * @return     la taille du fichier
     */
    public int taille()
    {
        return this.taille;
    }
    
    /**
     * Permet de connaître le nom du fichier
     * @see FileSystem
     * @return     le nom du fichier
     */
    public String get_nom()
    {
    	return super.get_nom();
    }

    /**
     * Permet de connaître le type du fichier
     * @return le type du fichier, ici file
     */
    public String get_type()
    {
    	return "file";
    }
}
