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
     * Constructor for objects of class Repertoire
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
     * @return  int   taille
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
    
    public String liste_file_type()
    {
	    String liste_nom=" ";
	    for(int i=0;i<nbFile;++i)
	    liste_nom+=this.get_nom() +" "+ this.get_type() + "contient : " + liste[i].get_nom()+ " " + liste[i].get_type()+ " | ";
	
	    return liste_nom;
    }
    
    public FileSystem[] get_liste(){
    	return this.liste;
    }

    public String get_nom()
    {
    	return super.get_nom();
    }

    public String get_type()
    {
    	return "directory";
    }
    
    public int get_nbFile()
    {
    	return nbFile;
    }
    
    public boolean notInDirectory(FileSystem file){
    	FileSystem[] liste;
    	boolean isNotIn = true;
    	int i =0;
    	
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

