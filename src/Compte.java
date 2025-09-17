import java.util.HashSet;

public class Compte {
    private String numeroCompte;
    private double solde;
    private String typeCompte;
    private HashSet<Transaction> historique;

    public Compte(String numeroCompte, String typeCompte) {
        this.numeroCompte = numeroCompte;
        this.typeCompte = typeCompte;
        this.solde = 0;
        this.historique = new HashSet<>();
    }

    public String getNumeroCompte() { return numeroCompte; }
    public double getSolde() { return solde; }
    public String getTypeCompte() { return typeCompte; }
    public HashSet<Transaction> getHistorique() { return historique; }

    public void depot(double montant) {
        solde += montant;
    }

    public void retrait(double montant) {
        solde -= montant;
    }

    public void ajouterTransaction(Transaction t) {
        historique.add(t);
    }
}
