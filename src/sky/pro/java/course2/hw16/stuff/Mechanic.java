package sky.pro.java.course2.hw16.stuff;

import sky.pro.java.course2.hw16.transport.Transport;
import sky.pro.java.course2.hw16.transport.transports.*;
import sky.pro.java.utility.ValueCheck;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mechanic {
    private static int counter = 0;

    private final int id;

    private static final String DEFAULT = "undefined";
    private static final Boolean DEFAULT_WORKING_WITH_CARS = false;
    private static final Boolean DEFAULT_WORKING_WITH_TRUCKS = false;
    private static final Boolean DEFAULT_WORKING_WITH_BUSES = false;

    private String name;
    private String company;
    private Boolean workingWithCars;
    private Boolean workingWithTrucks;
    private Boolean workingWithBuses;
    private final Set<Transport> transports;

    public Mechanic(String name, String company, Boolean workingWithCars,
                    Boolean workingWithTrucks, Boolean workingWithBuses) {
        id = ++counter;
        setName(name);
        setCompany(company);
        setWorkingWithCars(workingWithCars);
        setWorkingWithTrucks(workingWithTrucks);
        setWorkingWithBuses(workingWithBuses);
        transports = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public Boolean getWorkingWithCars() {
        return workingWithCars;
    }

    public Boolean getWorkingWithTrucks() {
        return workingWithTrucks;
    }

    public Boolean getWorkingWithBuses() {
        return workingWithBuses;
    }

    public Set<Transport> getTransports() {
        return transports;
    }

    public void setName(String name) {
        this.name = ValueCheck.isStringNotNullAndNotBlank(name) ? name : DEFAULT;
    }

    public void setCompany(String company) {
        this.company = ValueCheck.isStringNotNullAndNotBlank(company) ? company : DEFAULT;
    }

    public void setWorkingWithCars(Boolean workingWithCars) {
        this.workingWithCars = workingWithCars != null ? workingWithCars : DEFAULT_WORKING_WITH_CARS;
    }

    public void setWorkingWithTrucks(Boolean workingWithTrucks) {
        this.workingWithTrucks = workingWithTrucks != null ? workingWithTrucks : DEFAULT_WORKING_WITH_TRUCKS;
    }

    public void setWorkingWithBuses(Boolean workingWithBuses) {
        this.workingWithBuses = workingWithBuses != null ? workingWithBuses : DEFAULT_WORKING_WITH_BUSES;
    }

    public boolean addTransport(Transport transport) {
        if (transport != null &&
                (transport instanceof Car && workingWithCars
                        || transport instanceof Truck && workingWithCars
                        || transport instanceof Bus && workingWithBuses)) {
            boolean result = transports.add(transport);
            if (result) {
                transport.addMechanic(this);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return id == mechanic.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Механик " + name + " (" + company + ") – ");
        if (workingWithCars) {
            stringBuilder.append(Car.CLASS_STRING).append(", ");
        }
        if (workingWithTrucks) {
            stringBuilder.append(Truck.CLASS_STRING).append(", ");
        }
        if (workingWithBuses) {
            stringBuilder.append(Bus.CLASS_STRING).append(", ");
        }
        stringBuilder.delete(stringBuilder.lastIndexOf(","), stringBuilder.length());
        return stringBuilder.toString();
    }
}
