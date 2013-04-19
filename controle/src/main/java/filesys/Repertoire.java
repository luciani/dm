package filesys;

import exception.*;

/**
 * Classe Repertoire 
 * 
 * @author LUCIANI Arnaud VASSOUT Vincent
 * @version 16/04/13
 */
public class Repertoire extends FileSystem
{
    
    private static final int NB_MAX_FILE_SYST = 10;
    private static int nbRep = 0;
    private FileSystem[] liste;
    private int nbFile;

      
    
    /**
     * Constructeur d'objets de la classe Repertoire
     * 
     * @param nom du Repertoire
     * @exception FileSystemNullException si le nom est vide
     */
    public Repertoire(String nom) throws FileSystemNullException
    {
        super(nom,"directory");
        if(nom.equals(null)) throw new FileSystemNullException();
        liste = new FileSystem[NB_MAX_FILE_SYST];
        nbFile = 0;
    }
    
     
    /**
     * Ajoute un fichier ou un repertoire si ce repertoire n'est pas complet
     * 
     * @param file
     * @exception RepertoirePleinException si Repertoire plein
     * @return boolean vrai si ajout possible faux sinon
     */
    public boolean ajouterFileSystem(FileSystem file) throws RepertoirePleinException
    {
    	if(nbFile >= NB_MAX_FILE_SYST) throw new RepertoirePleinException();
    	else{
    		if(this.notInDirectory(file) && this.notAlreadyExist(file)) {
	            liste[nbFile++] = file;
	            return true;
	        }
	        return false;
    	}
        
    }
    
    /**
     * taille du repertoire
     * 
     * @return taille de tous les éléments du repertoire
     */
    public int taille()
    {
        int sumTaille = 0;
        for(int i=0; i < nbFile; ++i)
        {
            sumTaille += liste[i].taille();
        }
        return sumTaille;
    }
  
   /**
    * Permet d'obtenir la liste de tous les éléments directs du repertoire 
    * @return liste des éléments
    */
    public FileSystem[] get_liste(){
    	return this.liste;
    }
    
    /**
     *Permet de récupérer le nom du repertoire
     *@return nom du repertoire 
     */
    public String get_nom()
    {
    	return super.get_nom();
    }
    
    /**
     *Permet de récupérer le type: directory
     *@return type "directory" 
     */
    public String get_type()
    {
    	return "directory";
    }
    
    /**
     *Permet de récupérer le nombre d'éléments du repertoire
     *@return nombre éléments  
     */
    public int get_nbFile()
    {
    	return nbFile;
    }
    /**
     * Vérifie que l'objet ne peut être ajouté à lui-même ni à un sous-répertoire de lui-même
     * Si file est un fichier renvoie vraie
     * Sinon Explore le file
     * @param file
     * @return boolean vrai si n'est pas dans le repertoire, faux sinon
     */
    public boolean notInDirectory(FileSystem file){
    	FileSystem[] liste;
    	boolean isNotIn = true;
    	int i =0;
    	//Vérifie que le file est repertoire
    	if(file.get_type().equals("directory"))
    	{
    		
    		//le file est un repertoire qui a même nom.
    		if (this.get_nom().equals(file.get_nom()))
    			return false;
    		
    		liste=((Repertoire) file).get_liste();
    		while(i < ((Repertoire) file).get_nbFile() && isNotIn)
    		{
    			isNotIn = this.notInDirectory(liste[i]);
    			++i;
    		}   		
    	
    	}
    	return isNotIn;
    }
    /**
     * Vérifie que file ne porte pas le même qu'un élément présent dans le repertoire
     * @param file
     * @return boolean vrai si n'existe pas, faux sinon
     */
    public boolean notAlreadyExist(FileSystem file){
    	boolean notExist = true;
    	int i=0;
    	
    	while( i < this.nbFile && notExist)
    	{
    		notExist = !(this.liste[i].get_nom()).equals(file.get_nom());
    		++i;
    	}
    	return notExist;
    	
    }
}

