package com.solvd.talab;

import com.solvd.talab.dao.CarDao;
import com.solvd.talab.models.Car;

public class App {
    public static void main(String[] args) {

        CarDao cdao = new CarDao();
        Car carlitos = cdao.read(1);
        System.out.println(carlitos.toString());
    }
}
