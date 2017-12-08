package facture;

import java.io.PrintStream;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactureTest {

	Catalogue catalogue;
	Client bastide;
	Facture f;
	Article disk, iPad;

	@Before
	public void setUp() {
		catalogue = new Catalogue();
		/// "disk" : code de l'article
		disk = new Article("disk", "Disque 2To", 100f);
		iPad = new Article("ipad", "IPad 2", 700f);
		catalogue.addArticle(disk);
		catalogue.addArticle(iPad);

		bastide = new Client("Rémi Bastide", "Rue du Bac, Castres");
		Date dateDuJour = new Date();
		int numeroFacture = 345;
		f = new Facture(bastide, dateDuJour, numeroFacture);
		f.ajouteLigne(iPad, 1, 0f); // 700€, 0% de remise
		f.ajouteLigne(disk, 5, 0.1f); //5*100€, 10% de remise

	}

	@Test
	public void testCatalogue() {
		assertSame(iPad, catalogue.findByCode("ipad"));
		assertSame(disk, catalogue.findByCode("disk"));		
	}
	
	@Test
	public void testTTC() {
		
                float tva = 0.2f;
		float expected = (1*iPad.getPrix() + 5*disk.getPrix()*(0.9f)) * (1+tva);
		assertEquals(expected, f.montantTTC(tva), 0.001f);
		
                f.print(System.out, tva);
	}
        
        @Test 
        public void testGet(){
            Date dateDuJour = new Date();
            Facture f = new Facture(bastide, dateDuJour, 346);
                assertEquals(346, f.getNumero());
                assertEquals(dateDuJour, f.getEmission());
                assertEquals(bastide, f.getDestinataire());
        }
        
        @Test 
        public void testSetArticle(){
            iPad.setCode("test");
            iPad.setNom("artcile test");
            iPad.setPrix(10f);
            
            assertEquals("test", iPad.getCode());
            assertEquals("artcile test", iPad.getNom());
            assertEquals(10f, iPad.getPrix(), 0.1);
        }
}
