package Animal.Pet.Impl;

import Animal.Pet.Interfaces.Meowable;
import Animal.Pet.Pet;

import java.time.LocalDate;
import java.util.Date;

public class Cat extends Pet implements Meowable {

    String species = "кошка";

    public Cat(String name, LocalDate birthdate) {
        super(name, birthdate);
        setSpecies("кошка");
    }

    @Override
    public void meow() {
        System.out.println("Meow!");
    }
}
