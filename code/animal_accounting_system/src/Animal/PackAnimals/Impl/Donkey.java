package Animal.PackAnimals.Impl;

import Animal.PackAnimals.PackAnimals;

import java.time.LocalDate;

public class Donkey extends PackAnimals {
    public Donkey(String name, LocalDate birthdate) {
        super(name, birthdate);
        setSpecies("осёл");
    }
}
