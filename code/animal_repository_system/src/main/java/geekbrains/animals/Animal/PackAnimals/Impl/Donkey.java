package geekbrains.animals.Animal.PackAnimals.Impl;


import geekbrains.animals.Animal.Interfaces.Carryable;
import geekbrains.animals.Animal.PackAnimals.PackAnimals;

import java.time.LocalDate;

public class Donkey extends PackAnimals implements Carryable {
    public Donkey(String name, LocalDate birthdate) {
        super(name, birthdate);
        setType("осёл");
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
