package Animal.PackAnimals.Impl;

import Animal.PackAnimals.PackAnimals;

import java.time.LocalDate;

public class Camel extends PackAnimals {

    public Camel(String name, LocalDate birthdate) {
        super(name, birthdate);
        setSpecies("верблюд");
    }


}