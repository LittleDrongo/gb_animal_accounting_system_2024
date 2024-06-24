package Animal.PackAnimals.Impl;

import Animal.Interfaces.Carryable;
import Animal.PackAnimals.PackAnimals;

import java.time.LocalDate;
import java.util.concurrent.Callable;

public class Camel extends PackAnimals implements Carryable {

    public Camel(String name, LocalDate birthdate) {
        super(name, birthdate);
        setSpecies("верблюд");
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