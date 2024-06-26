package geekbrains.animals.Model.Repostory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import geekbrains.animals.Model.Animal.Animal;
import geekbrains.animals.Model.Animal.PackAnimals.PackAnimals;
import geekbrains.animals.Model.Animal.Pet.Pet;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Repository implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Map<Integer, Animal> animalMap = new HashMap<>();

    public Repository() {
    }

    public void addAnimals(Animal... animals) {

        for (Animal animal : animals) {
            int id = generateId();
            this.animalMap.put(id, animal);
        }
    }

    private int generateId() {
        return this.animalMap.size() + 1;
    }

    public void removeAnimal(int... ids) {
        for (int id : ids) {
            this.animalMap.remove(id);
        }
    }

    public int countPetsAnimals() {

        int count = 0;
        for (Animal animal : this.animalMap.values()) {
            if (animal instanceof Pet) {
                count++;
            }
        }
        return count;
    }

    public int countPackAnimals() {
        int count = 0;
        for (Animal animal : this.animalMap.values()) {
            if (animal instanceof PackAnimals) {
                count++;
            }
        }
        return count;
    }

    public Animal getAnimal(Integer id) {
        return this.animalMap.get(id);
    }
    public void printCounters() {
        System.out.println("Данные из репозитория");
        System.out.println("Домашних животных:" + countPetsAnimals());
        System.out.println("Вьючных животных:" + countPackAnimals());
        System.out.println("Всего:" + (countPackAnimals() + countPetsAnimals()));
    }

    public Map<Integer, Animal> getAnimalMap() {
        return animalMap;
    }

    public void printListOfAnimals() {
        for (Map.Entry<Integer, Animal> animal : this.animalMap.entrySet()) {
            System.out.println(animal.getKey() + " | " + animal.getValue());
        }
    }

    public void exportToJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());  // Регистрация модуля для поддержки Java 8 date/time
        mapper.writeValue(new File(filePath), this);
    }

    public void saveToFile(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
            System.out.println("Repository saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Repository loadFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Repository repository = (Repository) ois.readObject();
            // Восстанавливаем значение счетчика из загруженного репозитория
//            Repository.counter = repository.getCounter();
            System.out.println("Repository loaded from file.");
            return repository;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Repository(); // Возвращаем новый репозиторий в случае ошибки
        }
    }
}
