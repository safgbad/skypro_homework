package pro.sky.course2.hw20.passports;

import java.util.HashMap;
import java.util.Map;

public class PassportDatabase {
    private final Map<String, Passport> passports;

    public PassportDatabase() {
        passports = new HashMap<>();
    }

    public boolean addPassport(Passport passport) {
        if (passport == null) {
            return false;
        }
        String passportID = passport.getPassportID();
        Passport foundPassport = passports.get(passportID);
        if (foundPassport != null) {
            foundPassport.updateData(passport);
            return false;
        }
        passports.put(passportID, passport);
        return true;
    }

    public Passport getPassport(String passportID) {
        return passports.get(passportID);
    }
}
