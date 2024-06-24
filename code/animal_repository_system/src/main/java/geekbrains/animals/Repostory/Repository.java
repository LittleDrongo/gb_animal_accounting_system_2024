package geekbrains.animals.Repostory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import geekbrains.animals.Animal.Animal;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Repository implements Serializable {
    private final Map <Integer, Animal> animalMap = new HashMap<>();
    static  int counter = 0;

    public void setCounter(int counter) {
        Repository.counter = counter;
    }

    public Repository() {
    }

    public static Repository importFromJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Repository repository = mapper.readValue(new File(filePath), Repository.class);

        counter = repository.getAnimalMap().size();

        return repository;
    }

    public void addAnimal(Animal... animals) {

        for (Animal animal : animals) {
            counter++;
            this.animalMap.put(counter, animal);
        }
    }
    public void removeAnimal(int... ids){
            for (int id : ids){
                this.animalMap.remove(id);
            }
    }

    public Animal getAnimal(Integer id) {
        return this.animalMap.get(id);
    }

    public Map<Integer, Animal> getAnimalMap() {
        return animalMap;
    }

    public void printListOfAnimals(){
       for (Map.Entry<Integer, Animal> animal : this.animalMap.entrySet()){
           System.out.println(animal.getKey() + " | " +animal.getValue());
       }
    }

    public static int getCounter() {
        return counter;
    }


    public void exportToJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());  // Регистрация модуля для поддержки Java 8 date/time
        mapper.writeValue(new File(filePath), this);
    }

}


