package Animal.Pet.Impl;

import Animal.Interfaces.Meowable;
import Animal.Pet.Pet;

import java.time.LocalDate;

public class Cat extends Pet implements Meowable {

    public Cat(String name, LocalDate birthdate) {
        super(name, birthdate);
        setSpecies("кошка");
    }

    @Override
    public void meow() {
        System.out.println("Meow!");
    }
}
