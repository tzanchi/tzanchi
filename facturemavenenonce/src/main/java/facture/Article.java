package facture;

public class Article {
    
    private String code;

    /**
     * Get the value of code
     *
     * @return the value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the value of code
     *
     * @param code new value of code
     */
    public void setCode(String code) {
        this.code = code;
    }

    private float prix;
    private String nom;

    public Article(String code, String nom, float prix) {
        this.code = code;
        this.prix = prix;
        this.nom = nom;
    }

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the value of prix
     *
     * @return the value of prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * Set the value of prix
     *
     * @param prix new value of prix
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s, prix unitaire %6.2f€",code, nom, prix);
    }

}
