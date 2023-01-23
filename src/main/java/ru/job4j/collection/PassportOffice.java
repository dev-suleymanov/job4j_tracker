package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean result = true;
        for (String key : citizens.keySet()) {
            if (citizens.get(key).getPassport().equals(citizen.getPassport())) {
                result = false;
                break;
            }
        }
        if (result) {
            citizens.put(citizen.getPassport(), citizen);
        }
        return result;
    }

    public Citizen get(String passport) {
        Citizen result = null;
        for (String key : citizens.keySet()) {
            if (citizens.get(key).getPassport().equals(passport)) {
                result = citizens.get(passport);
                break;
            }
        }
        return result;
    }
}