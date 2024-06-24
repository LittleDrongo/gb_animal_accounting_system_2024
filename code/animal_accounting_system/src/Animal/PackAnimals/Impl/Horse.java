package Animal.PackAnimals.Impl;

import Animal.Interfaces.Carryable;
import Animal.PackAnimals.PackAnimals;

import java.time.LocalDate;

public class Horse extends PackAnimals implements Carryable {
    public Horse(String name, LocalDate birthdate) {
        super(name, birthdate);
        setSpecies("лошадь");
    }


    @Override
    public void loadCargo() {
        System.out.println("Загрузили груз");
    }

    @Override
    public void unloadCargo() {
        System.out.println("Выгрузили груз");
    }

    @Override
    public void moveCargo() {
        System.out.println("Везет груз");
    }
}
