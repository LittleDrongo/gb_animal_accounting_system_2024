package geekbrains.animals.Model.Animal.Pet.Impl;

import geekbrains.animals.Model.Animal.Interfaces.Barkable;
import geekbrains.animals.Model.Animal.Interfaces.Carryable;
import geekbrains.animals.Model.Animal.Interfaces.Meowable;
import geekbrains.animals.Model.Animal.Pet.Pet;

import java.time.LocalDate;

public class Cat extends Pet implements Meowable {

    public Cat(String name, LocalDate birthdate) {
        super(name, birthdate);
        setType("кошка");
    }

    @Override
    public void meow() {
        System.out.println("Meow!");
    }
}
