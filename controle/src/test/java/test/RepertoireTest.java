package test;

import static org.junit.Assert.*;

import org.junit.*;

import exception.*;
import filesys.*;


/**
 * Classe RepertoireTest Test les methodes de la classe Repertoire 
 * @author LUCIANI Arnaud VASSOUT Vincent
 * @version 16/04/13
 */
public class RepertoireTest {
	
	@Test
	@Before
	public void TestRepertoire()
    {
		try{
			Repertoire r1 = new Repertoire("rep1");
			assertNotNull(r1);
			assertEquals(r1.get_nom(), "rep1");
		//	Repertoire r2 = new Repertoire();
		}
		catch(FileSystemNullException e){
			System.out.println(e.getMessage());
		}
		
    }
     
    
    @Test
    public void TestAjouterFileSystem()
    {
    	try{
	    	Repertoire r1 = new Repertoire("rep1");
	    	Repertoire r2 = new Repertoire("rep2");
	    	Fichier f1 = new Fichier("fic1",10);
	    	
	    	assertTrue(r1.ajouterFileSystem(f1));
	    	assertFalse(r1.ajouterFileSystem(r1));
	    	assertTrue(r1.ajouterFileSystem(r2));
	    	//assertFalse(r2.ajouterFileSystem(r1));
    	}catch(RepertoirePleinException e){
    		System.out.println(e.getMessage());
    	}
    	catch(FileSystemNullException excep){
    		System.out.println(excep.getMessage());
    	}
    	catch(TailleFichierException eFic){
    		System.out.println(eFic.getMessage());
    	}
    	
    }
    
    @Test
    public void taille()
    {
    	try{
	    	Repertoire r1 = new Repertoire("rep1");
	    	Fichier f1 = new Fichier("fic1",10);
	    	Fichier f2 = new Fichier("fic2",30);
	    	Repertoire r2 = new Repertoire("rep2");
	    	
	    	r1.ajouterFileSystem(f1);
	    	assertTrue(r1.taille() == 10);
	    	r1.ajouterFileSystem(r2);
	    	assertTrue(r1.taille() == 10);
	    	r1.ajouterFileSystem(f2);
	    	assertTrue(r1.taille() == 40);
    	}catch(RepertoirePleinException e){
    		System.out.println(e.getMessage());
    	}
    	catch(FileSystemNullException excep){
    		System.out.println(excep.getMessage());
    	}
    	catch(TailleFichierException eFic){
    		System.out.println(eFic.getMessage());
    	}
    }
    
    @Test
    public void TestnotInDirectory(){
    	try{
	    	Repertoire r1 = new Repertoire("rep1");
	    	Repertoire r2 = new Repertoire("rep2");
	    	Repertoire r3 = new Repertoire("rep3");
	    	
	    	assertTrue(r1.notInDirectory(r2));
	    	r1.ajouterFileSystem(r2);
	    	r2.ajouterFileSystem(r3);
	    	assertFalse(r3.notInDirectory(r1));
    	}catch(RepertoirePleinException e){
    		System.out.println(e.getMessage());
    	}
    	catch(FileSystemNullException excep){
    		System.out.println(excep.getMessage());
    	}
    }
    
    @Test
    public void notAlreadyExist(){
    	try{
	    	Repertoire r1 = new Repertoire("rep1");
	    	Repertoire r2 = new Repertoire("f2");
	    	Repertoire r3 = new Repertoire("f1");
	    	Fichier f1 = new Fichier("f1",10);
	    	Fichier f2 = new Fichier("f2",30);
	    	Fichier f3 = new Fichier("f3",50);
	    	
	    	r1.ajouterFileSystem(r2);
	    	r1.ajouterFileSystem(f1);
	    	
	    	assertFalse(r1.notAlreadyExist(r3));
	    	assertFalse(r1.notAlreadyExist(f2));
	    	
	    	assertTrue(r1.notAlreadyExist(f3));
	    	
	    	r1.ajouterFileSystem(f3);
	    	assertFalse(r1.notAlreadyExist(f3));
    	}catch(RepertoirePleinException e){
    		System.out.println(e.getMessage());
    	}
    	catch(FileSystemNullException excep){
    		System.out.println(excep.getMessage());
    	}
    	catch(TailleFichierException eFic){
    		System.out.println(eFic.getMessage());
    	}
    }
}
 