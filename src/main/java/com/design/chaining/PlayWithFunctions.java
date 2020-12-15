package com.design.chaining;

import com.design.chaining.function.Function;
import com.design.chaining.model.Meteo;

public class PlayWithFunctions {
    public static void main(String[] args) {

        Meteo meteo=new Meteo(20);
        /*Meteo is input ,Integer is output*/
        Function<Meteo,Integer> readCelsius=m->m.getTemperature();
        /*Integer is input ,Double is output*/
        Function<Integer,Double> celsiusToFahrenheit=t->t*9d/5d+32d;
        /*chaining*/
      /*  Function<Meteo,Double> readFahrenheit=readCelsius.andThen(celsiusToFahrenheit);*/
        /*composition*/
        Function<Meteo,Double> readFahrenheit= celsiusToFahrenheit.compose(readCelsius);

        System.out.println("Meteo is F : "+readFahrenheit.apply(meteo));

    }
}
