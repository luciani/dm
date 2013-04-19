package filesys;


/**
 * Abstract class FileSystem - D�crit soit un repertoire soit un fichier
 * 
 * @author LUCIANI Arnaud VASSOUT Vincent
 * @version 16/04/13
 */
public abstract class FileSystem
{
    // instance variables - replace the example below with your own
    private String nom;
    private String type;

    /**
     * Constructor for objects of class FileSystem
     */
    public FileSystem(String nom, String type)
    {
        this.nom = nom;
        this.type = type;
    }
    
    /**
     * taille
     * 
     * @return     la taille du fichier
     */
    public abstract int taille();
    public String get_nom()
    {
    	return nom;
    }

    public abstract String get_type();
}
  