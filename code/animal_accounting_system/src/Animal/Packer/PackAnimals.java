package Animal.Packer;

import Animal.Animal;

import java.time.LocalDate;
import java.util.Date;

abstract public class PackAnimals extends Animal {
    public PackAnimals(String name, LocalDate birthdate) {
        super(name, birthdate);
    }
}
