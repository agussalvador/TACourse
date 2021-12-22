package com.solvd.talab.dao;

import com.solvd.talab.enums.CarEngineType;
import com.solvd.talab.enums.CarModel;
import com.solvd.talab.models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class CarDao implements ICrud<Car> {

    Connection con;
    ResultSet rs;
    PreparedStatement stmt;

    public CarDao() {
        con = DBConnection.getConnection();
    }

    @Override
    public void create(Car car) {
        String query = "insert into Cars (engine, model, id_vehicle) values (?,?,?)";
        int lastInsertId = createVehicle(car);
        try {
            stmt = con.prepareStatement(query);
            //parsing values
            stmt.setString(1, car.getEngine().name());
            stmt.setString(2, car.getModel().name());
            stmt.setInt(3, lastInsertId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }

    private int createVehicle(Car car) {
        String query = "insert into Vehicles(license_plate, maxspeed, kilometers) values (?,?,?)";
        int lastInsertId = -1;
        try {
            stmt = con.prepareStatement(query);
            //Parsing values
            stmt.setString(1, car.getLicensePlate());
            stmt.setFloat(2, car.getMaxSpeed());
            stmt.setFloat(3, car.getKilometers());
            stmt.executeUpdate();

            //Getting last insert id

            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                lastInsertId = rs.getInt(1);
            }
        } catch (SQLException e) {

            LOGGER.info(e.getMessage());
        }
        return lastInsertId;
    }

    @Override
    public Car read(int id) {
        String query = "select * from Cars c\n" +
                "inner join Vehicles v\n" +
                "where v.id = c.id_vehicle and c.id = ?";
        Car c = new Car();

        try {

            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                //Mapping the object
                c.setLicensePlate(rs.getString("license_plate"));
                c.setEngine(CarEngineType.valueOf(rs.getString("engine")));
                c.setModel(CarModel.valueOf(rs.getString("model")));
                c.setMaxSpeed(rs.getFloat("maxspeed"));
                c.setKilometers(rs.getFloat("kilometers"));
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }

        return c;
    }

    @Override
    public void update(Car car) {

    }

    @Override
    public void delete(int id) {
        String query = "delete from vehicles where id = ?";
        try {
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
