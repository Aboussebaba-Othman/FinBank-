import java.time.LocalDateTime;

public class Transaction {
    private String idTransaction;
    private String type;
    private double montant;
    private LocalDateTime date;
    private String compteSource;
    private String compteDestination;

    public Transaction(String idTransaction, String type, double montant, String compteSource, String compteDestination) {
        this.idTransaction = idTransaction;
        this.type = type;
        this.montant = montant;
        this.date = LocalDateTime.now();
        this.compteSource = compteSource;
        this.compteDestination = compteDestination;
    }

    public String toString() {
        return date + " | " + type + " | " + montant + " | " + compteSource + " | " + compteDestination;
    }
}
