package test;

import static org.junit.Assert.*;

import org.junit.*;


import exception.*;
import filesys.Fichier;


/**
 * Classe FichierTest Test les methodes de la classe test 
 * @author LUCIANI Arnaud VASSOUT Vincent
 * @version 16/04/13
 */
public class FichierTest {

	@Test
	@Before
	public void TestFichier()
    {
		try{
	        Fichier f1 = new Fichier("test1",10);
	        assertNotNull(f1);
	        Fichier f2 = new Fichier("test2", -2);
		}catch(FileSystemNullException eFile){
			System.out.println(eFile.getMessage());
		}catch(TailleFichierException eTaille){
			System.out.println(eTaille.getMessage());
		}
    }

    @Test
    public void TestTaille()
    {
    	try{
        Fichier f1 = new Fichier("test1",2);
        assertTrue(f1.taille() == 2);
    	}catch(FileSystemNullException eFile){
			System.out.println(eFile.getMessage());
		}catch(TailleFichierException eTaille){
			System.out.println(eTaille.getMessage());
		}
    }
}
  