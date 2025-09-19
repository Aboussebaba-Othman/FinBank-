import java.util.HashMap;

public class Gestionnaire extends Personne{
    private String idGestionnaire;
    private HashMap<String, Client> clients;

    public Gestionnaire(String idGestionnaire, String nom, String prenom, String email, String motDePasse){
        super(nom, prenom, email, motDePasse);
        this.idGestionnaire = idGestionnaire;
        this.clients = new HashMap<>();

    }

    public String getIdGestionnaire() {
        return idGestionnaire;
    }
    public HashMap<String, Client> getClients() {
        return clients;
    }


    public void creerClient(String id, String nom, String prenom, String email, String motDePasse) {
        Client newClien = new Client(id, nom, prenom, email, motDePasse);
        clients.put(id, newClien);
        System.out.println("Client créé: " + nom + " " + prenom);
    }


    public void creerCompte(String idClient, String numero, String type) {
        Client client = clients.get(idClient);
        Compte compte = new Compte(numero, type);
        client.ajouterCompte(compte);
        System.out.println("Compte créé pour " + client.getNom() + " avec le numéro : " + numero);

    }

    public void consulterComptes(String idClient) {
        Client client = clients.get(idClient);
        System.out.println("Comptes du client " + client.getNom() + ":");
        for (Compte c : client.getComptes().values()) {
            System.out.println(c.getNumeroCompte() + " | " + c.getTypeCompte() + " | Solde: " + c.getSolde() + " DH");
        }

    }

    public  void consulterHistorique(String idClient, String numeroCompte){
        Client c = clients.get(idClient);

        Compte cmpt = c.getComptes().get(numeroCompte);

        System.out.println("les Historiques de compte " + numeroCompte + " est :");
        for (Transaction t: cmpt.getHistorique()){
            System.out.println(t);
        }

    }
}
