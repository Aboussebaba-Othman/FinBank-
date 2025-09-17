import java.util.HashSet;
import java.io.FileWriter;
import java.io.IOException;

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
        if (montant <= 0) {
            System.out.println("Montant invalide !");
            return;
        }
        solde += montant;
        Transaction t = new Transaction("T" + (historique.size() + 1), "Dépôt", montant, null, numeroCompte);
        historique.add(t);
        ecrireDansFichier(t);
    }

    public void retrait(double montant) {
        if (montant <= 0) {
            System.out.println("Montant invalide !");
            return;
        }
        if (montant > solde) {
            System.out.println("Solde insuffisant !");
            return;
        }
        solde -= montant;
        Transaction t = new Transaction("T" + (historique.size() + 1), "Retrait", montant, numeroCompte, null);
        historique.add(t);
        ecrireDansFichier(t);
    }

    public void virement(double montant, Compte destinataire) {
        if (montant <= 0) {
            System.out.println("Montant invalide !");
            return;
        }
        if (montant > solde) {
            System.out.println("Solde insuffisant !");
            return;
        }

        solde -= montant;
        destinataire.solde += montant;

        Transaction t = new Transaction("T" + (historique.size() + 1), "Virement", montant, numeroCompte, destinataire.numeroCompte);
        historique.add(t);
        destinataire.historique.add(t);

        ecrireDansFichier(t);
        destinataire.ecrireDansFichier(t);
    }

    private void ecrireDansFichier(Transaction t) {
        try {
            FileWriter fw = new FileWriter(numeroCompte + ".txt", true);
            fw.write(t.toString() + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Erreur d'écriture dans le fichier !");
        }
    }

    public void ajouterTransaction(Transaction t) {
        historique.add(t);
    }
}
