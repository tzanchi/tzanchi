package facture;

import java.io.PrintStream;
import java.util.Date;
import facture.LigneFacture;
import java.util.ArrayList;

public class Facture {

    private Client destinataire;
    private Date emission;
    private int numero;
    private ArrayList<LigneFacture> mesLignes = new ArrayList<>();

    public Facture(Client destinataire, Date emission, int numero) {
        this.destinataire = destinataire;
        this.emission = emission;
        this.numero = numero;
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return (this.numero);
    }

    /**
     * Get the value of emission
     *
     * @return the value of emission
     */
    public Date getEmission() {
        return (this.emission);
    }

    /**
     * Get the value of destinataire
     *
     * @return the value of destinataire
     */
    public Client getDestinataire() {
        return (this.destinataire);
    }

    public void ajouteLigne(Article a, int nombre, float remise) {
        LigneFacture x = new LigneFacture(nombre, this, a, remise);
        mesLignes.add(x);
    }

    public float montantTTC(float tauxTVA) {
        float y = 0f;

        for (LigneFacture x : mesLignes) {
            y += x.montantLigne();
        }

        y = y * (1 + tauxTVA);

        return (y);
    }

    public void print(PrintStream out, float tva) {
        Article y;

        out.print("################# ticket ##################\n\r");

        for (LigneFacture x : mesLignes) {
            y = x.getArticleFacture();
            out.print("Article : " + y.getNom() + " code : " + y.getCode() + " prix : " + y.getPrix() + " remise : " + x.getTauxRemise() + "\n");
            y.toString();
        }

        out.print("tva : " + tva + "\n");
        out.print("montant ttc : " + montantTTC(tva) + "\n\r");

        out.print("############################################# \n\r");
    }

}
