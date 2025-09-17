import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Client client = new Client("1", "othman","Aboussebaba","onepiece.istheBest@gmail.com","12345678");
        Compte compte1 = new Compte("194922", "Courant");
        client.ajouterCompte(compte1);

        Scanner sc =new Scanner(System.in);

        int choix;

        do {
            System.out.println("\n--- Menu Client ---");
            System.out.println("1. Consulter solde");
            System.out.println("2. Dépôt");
            System.out.println("3. Retrait");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Solde du compte " + compte1.getNumeroCompte() + " : " + compte1.getSolde() + " DH");
                    break;
                case 2:
                    System.out.print("Montant à déposer : ");
                    double depot = sc.nextDouble();
                    compte1.depot(depot);
                    System.out.println("Dépôt effectué !");
                    break;
                case 3:
                    System.out.print("Montant à retirer : ");
                    double retrait = sc.nextDouble();
                    if (retrait <= compte1.getSolde()) {
                        compte1.retrait(retrait);
                        System.out.println("Retrait effectué !");
                    } else {
                        System.out.println("Erreur : solde insuffisant !");
                    }
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 0);

        sc.close();

    }

}
