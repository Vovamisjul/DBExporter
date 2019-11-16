package com.vovamisjul.database;

import com.vovamisjul.entities.Apartment;
import com.vovamisjul.entities.House;
import com.vovamisjul.entities.HouseAddress;
import com.vovamisjul.entities.people.Resident;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBController {
    private final String db_user;
    private final String db_password;
    private final String connectionURL;

    public DBController() {
        db_user = "root";
        db_password = "";
        connectionURL = "jdbc:mysql://localhost:3306/cs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
    }

    public DBController(String db_user, String db_password, String connectionURL) {
        this.db_user = db_user;
        this.db_password = db_password;
        this.connectionURL = connectionURL;
    }

    public int addHouse(HouseAddress address) throws Exception {
        try(Connection connection = DriverManager.getConnection(connectionURL, db_user, db_password)) {
            var statement = connection.prepareStatement("insert into houses values (null, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHouse());
            statement.executeUpdate();
            var result = statement.getGeneratedKeys();
            result.next();
            return result.getInt(1);
        }
    }

    public int addApartment(Apartment apartment, int houseId) throws Exception {
        try(Connection connection = DriverManager.getConnection(connectionURL, db_user, db_password)) {
            var statement = connection.prepareStatement("insert into apartments values (null, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, houseId);
            statement.setInt(2, apartment.getNumber());
            statement.executeUpdate();
            var result = statement.getGeneratedKeys();
            result.next();
            return result.getInt(1);
        }
    }

    public int addResident(Resident resident, int apartmentId) throws Exception {
        try(Connection connection = DriverManager.getConnection(connectionURL, db_user, db_password)) {
            var statement = connection.prepareStatement("insert into residents values (null, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, apartmentId);
            statement.setString(2, resident.getName());
            statement.setString(3, resident.getGender().toString());
            statement.executeUpdate();
            var result = statement.getGeneratedKeys();
            result.next();
            return result.getInt(1);
        }
    }
}
