package filesys;


/**
 * Classe abstraite FileSystem - D�crit soit un repertoire soit un fichier
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
     * Constructeur d'objet FileSystem
     */
    public FileSystem(String nom, String type)
    {
        this.nom = nom;
        this.type = type;
    }
    
    /**
     * Méthode abstraite
     * la taille donnée pour un fichier et pour un repertoire la somme de la taille de tous ses éléments
     * @see Fichier
     * @see Repertoire
     * @return     la taille
     */
    public abstract int taille();
    
    /**
     * Permet de connaître le nom du FileSystem(file,directory)
     * @return nom du FileSystem
     */
    public String get_nom()
    {
    	return nom;
    }

    /**
     * Méthode abstraite
     * le type du FileSystem(file,directory)
     * @see Fichier
     * @see Repertoire
     * @return     le type du FileSystem
     */
    public abstract String get_type();
}
  