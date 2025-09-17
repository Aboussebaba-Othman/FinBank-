import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Client client = new Client("1", "Othman","Aboussebaba","onepiece.istheBest@gmail.com","12345678");

        Compte compte1 = new Compte("C1001", "Courant");
        Compte compte2 = new Compte("C1002", "Épargne");
        client.ajouterCompte(compte1);
        client.ajouterCompte(compte2);

        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n--- Menu Client ---");
            System.out.println("1. Consulter solde compte 1");
            System.out.println("2. Dépôt compte 1");
            System.out.println("3. Retrait compte 1");
            System.out.println("4. Virement vers compte 2");
            System.out.println("5. Consulter historique compte 1");
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
                    break;
                case 3:
                    System.out.print("Montant à retirer : ");
                    double retrait = sc.nextDouble();
                    compte1.retrait(retrait);
                    break;
                case 4:
                    System.out.print("Montant à virer vers compte 2 : ");
                    double virement = sc.nextDouble();
                    compte1.virement(virement, compte2);
                    break;
                case 5:
                    System.out.println("Historique du compte 1 :");
                    for (Transaction t : compte1.getHistorique()) {
                        System.out.println(t);
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
