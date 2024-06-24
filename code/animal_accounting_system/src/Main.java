import Animal.PackAnimals.Impl.Horse;
import Animal.Pet.Impl.Cat;
import Animal.Pet.Impl.Dog;
import Animal.Pet.Impl.Hamster;
import Repostory.Repository;
import Utils.Files;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {


        Repository repository = new Repository("mainRepository");
        Cat cat = new Cat("sunny", LocalDate.of(1988, 10, 4));
        Dog dog = new Dog("bob", LocalDate.of(2014, 9, 18));
        Hamster hamster = new Hamster("jemmy", LocalDate.of(2023, 7, 5));
        Horse horse = new Horse("german", LocalDate.of(2000, 5, 5));

        repository.addAnimal(hamster, horse, dog, hamster, horse);

        repository.printListOfAnimals();
        Files.createDirectoryAndFile("data/myfile.json");


    }

    public static void createNew(){
        Cat cat = new Cat("sunny", LocalDate.of(1988, 10, 4));
        Dog dog = new Dog("bob", LocalDate.of(2014, 9, 18));
        Hamster hamster = new Hamster("jemmy", LocalDate.of(2023, 7, 5));
        Horse horse = new Horse("german", LocalDate.of(2000, 5, 5));


        /*
        {
            dog.setCommands("прыгать", "бегать");
            System.out.println(dog.getCommands());
            dog.appendCommands("смеяться");
            System.out.println(dog.getCommands());

            dog.giveCommand("бегать");
            dog.giveCommand("летать");

            cat.meow();
            dog.bark();
            hamster.squeak();
            horse.moveCargo();

            System.out.println(cat.getAge());


            System.out.println(cat);
            System.out.println(dog);
            System.out.println(hamster);
        }
         */

        System.out.println("Создание добавление");
        Repository repository = new Repository("mainRepository"); //TODO реализовать SQL отправку
        repository.addAnimal(cat);
        repository.addAnimal(dog);
        repository.addAnimal(hamster, horse);
        repository.printListOfAnimals();

        System.out.println("После удаления 3, 2");
        repository.removeAnimal(3, 2);
        repository.printListOfAnimals();

        System.out.println("Создание добавление второй раз");
        repository.addAnimal(hamster, horse);
        repository.printListOfAnimals();



    }
}

