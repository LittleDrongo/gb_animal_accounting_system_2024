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
    private final String repositoryName;
    private final Map <Integer, Animal> animalMap = new HashMap<>();
    static private int counter = 0;

    public static Repository importFromJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());  // Регистрация модуля для поддержки Java 8 date/time

        // Чтение из файла и десериализация JSON в объект Repository
        Repository repository = mapper.readValue(new File(filePath), Repository.class);

        // Восстановление счетчика на основе текущего состояния репозитория
        counter = repository.getAnimalMap().size();

        return repository;
    }

    public Repository(String repositoryName) {
        this.repositoryName = repositoryName;
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

    public String getRepositoryName() {
        return repositoryName;
    }
}


