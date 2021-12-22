package com.solvd.talab;

import com.solvd.talab.dao.CarDao;
import com.solvd.talab.enums.CarEngineType;
import com.solvd.talab.enums.CarModel;
import com.solvd.talab.exceptions.InvalidCharacter;
import com.solvd.talab.models.Car;

public class App {
    public static void main(String[] args) throws InvalidCharacter {

        CarDao cdao = new CarDao();

        Car ford2 = new Car("cc193fr", 240, 23400f, CarEngineType.ELECTRIC, CarModel.FORD);
        Car fiat = new Car("BE567NA", 190, 40000f, CarEngineType.COMBUSTION, CarModel.FIAT);

        cdao.create(ford2);
        cdao.create(fiat);
        cdao.delete(1);
        for(int i=1; i<4; i++){
            Car carlitos = cdao.read(i);
            System.out.println(carlitos.toString());
        }
    }
}
