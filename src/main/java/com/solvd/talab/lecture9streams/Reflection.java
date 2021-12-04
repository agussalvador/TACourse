package com.solvd.talab.lecture9streams;

import com.solvd.talab.enums.CarEngineType;
import com.solvd.talab.enums.CarModel;
import com.solvd.talab.models.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class Reflection {
    public static void main(String[] args) {
//        try {
//            Class c = Class.forName("com.solvd.talab.models.Car");
//            Method m[] = c.getDeclaredMethods();
//            for (int i = 0; i < m.length; i++)
//                System.out.println(m[i].toString());
//        }
//        catch (Throwable e) {
//            LOGGER.log(Level.INFO, e.getMessage());
//        }
        try {
            Class cls = Class.forName("com.solvd.talab.models.Car");


            //Field list of Car Class
            LOGGER.log(Level.INFO, "(------------------ATTRIBUTES----------------------)");
            Field fieldlist[] = cls.getDeclaredFields();
            for (int i = 0; i < fieldlist.length; i++) {
                Field fld = fieldlist[i];
                int mod = fld.getModifiers();
                LOGGER.log(Level.INFO, "NAME= " + fld.getName()
                        + " DECL CLASS = " + fld.getDeclaringClass()
                        + " TYPE= " + fld.getType()
                        + " MODIFIERS = " + Modifier.toString(mod));
            }
            //Method list of Car Class
            LOGGER.log(Level.INFO, "(------------------METHODS----------------------)");
            Method m[] = cls.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
                LOGGER.log(Level.INFO, m[i].toString());

            LOGGER.log(Level.INFO, "(----------------------------------------)");
            //Creating new instance using reflection
            Constructor<Car> constructor = cls.getConstructor(String.class, Float.TYPE, Float.TYPE, Enum.class, Enum.class);
            Car newCar = constructor.newInstance("AA345FF", 34f, 34f, CarEngineType.COMBUSTION, CarModel.FIAT);
            LOGGER.log(Level.INFO, "Constructor parameters count: " + constructor.getParameterCount());
            //Calling methods using reflection
            Method run = cls.getMethod("run", Float.TYPE);
            run.invoke(newCar, 45f);

            Method reverse = cls.getMethod("reverse");
            LOGGER.log(Level.INFO, "Reverse return type: " + reverse.getReturnType());

        } catch (Throwable e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }
}
