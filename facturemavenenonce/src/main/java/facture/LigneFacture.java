/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facture;

/**
 *
 * @author rbastide
 */
public class LigneFacture {
    
    private int nombre;
    private float tauxRemise;
    private final Facture figureDans;
    private final Article articleFacture;

    public LigneFacture(int nombre, Facture figureDans, Article articleFacture, float tauxRemise) {
        this.nombre = nombre;
        this.figureDans = figureDans;
        this.articleFacture = articleFacture;
        this.tauxRemise = tauxRemise;
    }

    /**
     * Get the value of articleFacture
     *
     * @return the value of articleFacture
     */
    public Article getArticleFacture() {
        return articleFacture;
    }

    /**
     * Get the value of figureDans
     *
     * @return the value of figureDans
     */
    public Facture getFigureDans() {
        return figureDans;
    }
    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(int nombre) {
        if (nombre <= 0) {
            throw new IllegalArgumentException("Le nombre doit être positif");
        }
        this.nombre = nombre;
    }


    /**
     * Get the value of tauxRemise
     *
     * @return the value of tauxRemise
     */
    public float getTauxRemise() {
        return tauxRemise;
    }

    /**
     * Set the value of tauxRemise
     *
     * @param tauxRemise new value of tauxRemise
     */
    public void setTauxRemise(float tauxRemise) {
        this.tauxRemise = tauxRemise;
    }

    public float montantLigne() {
        return articleFacture.getPrix() * nombre * (1 - tauxRemise); 
    }

    @Override
    public String toString() {
        return String.format("%s, nombre : %d, taux de remise %4.2f%%, montant ligne %6.2f€", articleFacture, nombre, tauxRemise*100, montantLigne() );
    }
    
    
}
