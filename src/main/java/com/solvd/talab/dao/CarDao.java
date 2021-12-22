package com.solvd.talab.dao;

import com.solvd.talab.enums.CarEngineType;
import com.solvd.talab.enums.CarModel;
import com.solvd.talab.models.Car;

import java.sql.*;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class CarDao implements ICrud<Car> {

    Connection con;
    ResultSet rs;
    PreparedStatement stmt;

    public CarDao() {
        con= DBConnection.getConnection();
    }

    @Override
    public void create(Car car) {

    }

    @Override
    public Car read(int id) {
        String query = "select * from Cars c\n" +
                "inner join Vehicles v\n" +
                "where v.id = c.id_vehicle and c.id = ?";
        Car c = new Car();

        try {

            stmt=con.prepareStatement(query);
            stmt.setInt(1,id);
            rs=stmt.executeQuery();

            if(rs.next()) {
                //Mapping the object
                c.setLicensePlate(rs.getString("license_plate"));
                c.setEngine(CarEngineType.valueOf(rs.getString("engine")));
                c.setModel(CarModel.valueOf(rs.getString("model")));
                c.setMaxSpeed(rs.getFloat("maxspeed"));
                c.setKilometers(rs.getFloat("kilometers"));
            }
        } catch (SQLException e) {
        }

        return c;
    }

    @Override
    public void update(Car car) {

    }

    @Override
    public void delete(int id) {
        String query = "delete from cars where id = ?";
        try {
            stmt=con.prepareStatement(query);
            stmt.setInt(1,id);
            rs=stmt.executeQuery();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
