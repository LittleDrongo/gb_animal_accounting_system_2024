package geekbrains.animals;


import geekbrains.animals.Model.Animal.PackAnimals.Impl.Horse;
import geekbrains.animals.Model.Animal.Pet.Impl.Cat;
import geekbrains.animals.Model.Animal.Pet.Impl.Dog;
import geekbrains.animals.Model.Animal.Pet.Impl.Hamster;
import geekbrains.animals.Model.Config.Config;
import geekbrains.animals.Model.Repostory.Repository;
import geekbrains.animals.Model.Utils.Files;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args)  {


        Repository repository = Repository.loadFromFile(Config.RepositoryFilePath);

//        Repository repository = new Repository();
//        Cat cat = new Cat("sunny", LocalDate.of(1988, 10, 4));
//        Dog dog = new Dog("bob", LocalDate.of(2014, 9, 18));
//        Hamster hamster = new Hamster("jemmy", LocalDate.of(2023, 7, 5));
//        Horse horse = new Horse("german", LocalDate.of(2000, 5, 5));



//        repository.addAnimals(cat, dog, hamster, horse);
        repository.printListOfAnimals();
//        repository.saveToFile(Config.RepositoryFilePath);

    }


    public void example() throws IOException {
        Repository repository = new Repository();
        Cat cat = new Cat("sunny", LocalDate.of(1988, 10, 4));
        Dog dog = new Dog("bob", LocalDate.of(2014, 9, 18));
        Hamster hamster = new Hamster("jemmy", LocalDate.of(2023, 7, 5));
        Horse horse = new Horse("german", LocalDate.of(2000, 5, 5));


        repository.addAnimals(cat, dog, hamster, horse);
        repository.printListOfAnimals();


        Files.createDirectoryAndFile("data/myfile.json");
        repository.exportToJson("data/myfile.json");
    }

}
