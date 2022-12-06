package sky.pro.java.course2.hw16.sponsorship;

import sky.pro.java.course2.hw16.transport.Transport;

import java.util.Objects;

public class Donation {
    private static int counter = 0;

    private final int id;
    private final Sponsor sponsor;
    private final Transport transport;
    private final Double amount;

    Donation(Sponsor sponsor, Transport transport, Double amount) {
        id = ++counter;
        this.sponsor = sponsor;
        this.transport = transport;
        this.amount = amount;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public Transport getTransport() {
        return transport;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return id == donation.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Пожертвование " + amount + "RUB в пользу команды " + transport.getBrand() +
                " " + transport.getModel();
    }
}
