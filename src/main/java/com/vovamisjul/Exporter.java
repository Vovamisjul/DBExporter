package com.vovamisjul;

import com.google.gson.Gson;
import com.vovamisjul.database.DBController;
import com.vovamisjul.entities.Apartment;
import com.vovamisjul.entities.House;
import com.vovamisjul.entities.HouseAddress;
import com.vovamisjul.entities.people.Resident;

import java.util.Map;

public class Exporter {
    private DBController dbController = new DBController();

    public Exporter() {
    }

    public void export(String json) throws Exception {
        Validator.check(json);
        var communalServices = new Gson().fromJson(json.toString(), CommunalServices.class);
        for (var house:communalServices.getServicedHouses().values()
             ) {
            exportHouse(house);
        }
    }

    private void exportHouse(House house) throws Exception {
        int id = dbController.addHouse(house.getAddress());
        for (var apartment:house.getApartments().values()
             ) {
            exportApartment(apartment, id);
        }
    }

    private void exportApartment(Apartment apartment, int idHouse) throws Exception {
        int id = dbController.addApartment(apartment, idHouse);
        for (var resident:apartment.getResidents()
        ) {
            exportResident(resident, id);
        }
    }

    private void exportResident(Resident resident, int idApartment) throws Exception {
        int id = dbController.addResident(resident, idApartment);
    }
}
