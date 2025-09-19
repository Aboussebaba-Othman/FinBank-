import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Gestionnaire gestionnaire = new Gestionnaire("G1", "Othman", "Aboussebaba", "aboussebaba@gmail.com", "1234");
        boolean quitter = false;

        while (!quitter) {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Gestionnaire");
            System.out.println("2. Client");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            int choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    boolean quitterGestionnaire = false;
                    while (!quitterGestionnaire) {
                        System.out.println("\n===== Menu Gestionnaire =====");
                        System.out.println("1. Créer un client");
                        System.out.println("2. Créer un compte pour un client");
                        System.out.println("3. Consulter les comptes d’un client");
                        System.out.println("4. Consulter l’historique d’un compte");
                        System.out.println("0. Retour");
                        System.out.print("Votre choix : ");
                        int choixGest = sc.nextInt();
                        sc.nextLine();

                        switch (choixGest) {
                            case 1:
                                System.out.print("ID client: ");
                                String id = sc.nextLine();
                                System.out.print("Nom: ");
                                String nom = sc.nextLine();
                                System.out.print("Prénom: ");
                                String prenom = sc.nextLine();
                                System.out.print("Email: ");
                                String email = sc.nextLine();
                                System.out.print("Mot de passe: ");
                                String mdp = sc.nextLine();
                                gestionnaire.creerClient(id, nom, prenom, email, mdp);
                                break;
                            case 2:
                                System.out.print("ID client: ");
                                String idClient = sc.nextLine();
                                System.out.print("Numéro de compte: ");
                                String numero = sc.nextLine();
                                System.out.print("Type (Courant / Épargne): ");
                                String type = sc.nextLine();
                                gestionnaire.creerCompte(idClient, numero, type);
                                break;
                            case 3:
                                System.out.print("ID client: ");
                                idClient = sc.nextLine();
                                gestionnaire.consulterComptes(idClient);
                                break;
                            case 4:
                                System.out.print("ID client: ");
                                idClient = sc.nextLine();
                                System.out.print("Numéro compte: ");
                                String num = sc.nextLine();
                                gestionnaire.consulterHistorique(idClient, num);
                                break;
                            case 0:
                                quitterGestionnaire = true;
                                break;
                            default:
                                System.out.println("Choix invalide !");
                        }
                    }
                    break;


                case 2:
                    System.out.print("Entrer votre ID client: ");
                    String idClient = sc.nextLine();

                    Client client = gestionnaire.getClients().get(idClient);

                    boolean quitterClient = false;
                    while (!quitterClient) {
                        System.out.println("\n===== Menu Client =====");
                        System.out.println("1. Consulter mes comptes");
                        System.out.println("2. Dépôt");
                        System.out.println("3. Retrait");
                        System.out.println("4. Virement");
                        System.out.println("5. Consulter historique d’un compte");
                        System.out.println("0. Retour");
                        System.out.print("Votre choix : ");
                        int choixClient = sc.nextInt();
                        sc.nextLine();

                        switch (choixClient) {
                            case 1:
                                for (Compte c : client.getComptes().values()) {
                                    System.out.println(c.getNumeroCompte() + " | " + c.getTypeCompte() + " | Solde: " + c.getSolde());
                                }
                                break;
                            case 2:
                                System.out.print("Numéro compte: ");
                                String numC = sc.nextLine();
                                System.out.print("Montant dépôt: ");
                                double dep = sc.nextDouble();
                                sc.nextLine();
                                client.getComptes().get(numC).depot(dep);
                                break;
                            case 3:
                                System.out.print("Numéro compte: ");
                                numC = sc.nextLine();
                                System.out.print("Montant retrait: ");
                                double ret = sc.nextDouble();
                                sc.nextLine();
                                client.getComptes().get(numC).retrait(ret);
                                break;
                            case 4:
                                System.out.print("Numéro compte source: ");
                                String source = sc.nextLine();
                                System.out.print("Numéro compte destination: ");
                                String dest = sc.nextLine();
                                System.out.print("Montant virement: ");
                                double mnt = sc.nextDouble();
                                sc.nextLine();
                                Compte cSource = client.getComptes().get(source);
                                Compte cDest = client.getComptes().get(dest);
                                cSource.virement(mnt, cDest);
                                break;
                            case 5:
                                System.out.print("Numéro compte: ");
                                numC = sc.nextLine();
                                for (Transaction t : client.getComptes().get(numC).getHistorique()) {
                                    System.out.println(t);
                                }
                                break;
                            case 0:
                                quitterClient = true;
                                break;
                            default:
                                System.out.println("Choix invalide !");
                        }
                    }
                    break;
                case 0:
                    quitter = true;
                    System.out.println("Merci et Bay Bay !");
                    break;

                default:
                    System.out.println("Choix invalide !");

            }
        }
        sc.close();
    }
}
