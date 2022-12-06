package sky.pro.java.course2.hw16.sponsorship;

import sky.pro.java.course2.hw16.transport.Transport;
import sky.pro.java.utility.ValueCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sponsor {
    private static final String DEFAULT_NAME = "Анонимный спонсор";

    private static int counter = 0;

    private final int id;
    private String name;
    private final List<Donation> donations;

    public Sponsor(String name) {
        id = ++counter;
        setName(name);
        donations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setName(String name) {
        this.name = ValueCheck.isStringNotNullAndNotBlank(name) ? name : DEFAULT_NAME;
    }

    public boolean makeDonation(Transport transport, Double amount) {
        if (transport != null && ValueCheck.isNumberNotNullAndNotNegative(amount)) {
            donations.add(new Donation(this, transport, amount));
            transport.addSponsor(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return id == sponsor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Спонсор " + name + ":");
        for (Donation donation : donations) {
            stringBuilder.append('\n').append(donation);
        }
        return stringBuilder.toString();
    }
}
