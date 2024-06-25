package geekbrains.animals.Model.Animal.Pet.Impl;


import geekbrains.animals.Model.Animal.Interfaces.Squeakable;
import geekbrains.animals.Model.Animal.Pet.Pet;

import java.time.LocalDate;

public class Hamster extends Pet implements Squeakable {
    public Hamster(String name, LocalDate birthdate) {
        super(name, birthdate);
        setType("хомяк");
    }

    @Override
    public void squeak() {
        System.out.println("Squeak!");
    }
}
