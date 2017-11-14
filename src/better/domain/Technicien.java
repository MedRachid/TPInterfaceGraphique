package better.domain;

public class Technicien extends Employee {

    private final int base;
    private final double UNIT_PRICE = 5;

    public Technicien(String firstname, String lastname, int age, String entryYear, int base) {
        super(firstname, lastname, age, entryYear);
        this.base = base;
    }

    @Override
    public double calculerSalaire() {
        return (double) base * UNIT_PRICE;
    }

    @Override
    public String getPosition() {
        return "Le technicien";
    }
}
