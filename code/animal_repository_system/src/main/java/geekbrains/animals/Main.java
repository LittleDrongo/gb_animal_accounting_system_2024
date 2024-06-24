package geekbrains.animals;


import geekbrains.animals.Animal.PackAnimals.Impl.Horse;
import geekbrains.animals.Animal.Pet.Impl.Cat;
import geekbrains.animals.Animal.Pet.Impl.Dog;
import geekbrains.animals.Animal.Pet.Impl.Hamster;
import geekbrains.animals.Repostory.Repository;
import geekbrains.animals.Utils.Files;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {


        Repository repository = new Repository("mainRepository");
        Cat cat = new Cat("sunny", LocalDate.of(1988, 10, 4));
        Dog dog = new Dog("bob", LocalDate.of(2014, 9, 18));
        Hamster hamster = new Hamster("jemmy", LocalDate.of(2023, 7, 5));
        Horse horse = new Horse("german", LocalDate.of(2000, 5, 5));



        repository.addAnimal(cat, dog, hamster, horse);
        repository.printListOfAnimals();


        Files.createDirectoryAndFile("data/myfile.json");
        repository.exportToJson("data/myfile.json");

        System.out.println("importing");
        Repository rep = Repository.importFromJson("data/myfile.json");

        rep.printListOfAnimals();
    }
}

