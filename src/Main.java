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
            System.out.println("\n----- Menu Client -----");
            System.out.println("1. Consulter solde compte 1");
            System.out.println("2. Consulter solde compte 2");
            System.out.println("3. Dépot compte 1");
            System.out.println("4. Dépot compte 2");
            System.out.println("5. Retrait compte 1");
            System.out.println("6. Retrait compte 2");
            System.out.println("7. Virement vers compte 2");
            System.out.println("8. Virement vers compte 1");
            System.out.println("9. Consulter historique compte 1");
            System.out.println("10. Consulter historique compte 2");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Solde du compte " + compte1.getNumeroCompte() + " : " + compte1.getSolde() + " DH");
                    break;
                case 2:
                    System.out.println("Solde du compte " + compte2.getNumeroCompte() + " : " + compte2.getSolde() + " DH");
                    break;
                case 3:
                    System.out.print("Montant à déposer : ");
                    double depot = sc.nextDouble();
                    compte1.depot(depot);
                    break;
                case 4:
                    System.out.print("Montant à déposer : ");
                    double depot2 = sc.nextDouble();
                    compte2.depot(depot2);
                    break;
                case 5:
                    System.out.print("Montant à retirer : ");
                    double retrait1 = sc.nextDouble();
                    compte1.retrait(retrait1);
                    break;
                case 6:
                    System.out.print("Montant a retirer : ");
                    double retrait2 = sc.nextDouble();
                    compte2.retrait(retrait2);
                    break;
                case 7:
                    System.out.print("Montant a virer vers compte 2 : ");
                    double virement = sc.nextDouble();
                    compte1.virement(virement, compte2);
                    break;
                case 8:
                    System.out.print("Montant a virer vers compte 1 : ");
                    double virement2 = sc.nextDouble();
                    compte2.virement(virement2, compte1);
                    break;
                case 9:
                    System.out.println("Historique du compte 1 :");
                    for (Transaction t : compte1.getHistorique()) {
                        System.out.println(t);
                    }
                    break;
                case 10:
                    System.out.println("Historique du compte 2 :");
                    for (Transaction t : compte2.getHistorique()) {
                        System.out.println(t);
                    }
                    break;
                case 0:
                    System.out.println("M3A SALAMA !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 0);

        sc.close();
    }
}
