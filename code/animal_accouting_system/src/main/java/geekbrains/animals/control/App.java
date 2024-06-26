package geekbrains.animals.control;

import geekbrains.animals.Model.Animal.Animal;
import geekbrains.animals.Model.Animal.PackAnimals.Impl.Camel;
import geekbrains.animals.Model.Animal.PackAnimals.Impl.Donkey;
import geekbrains.animals.Model.Animal.PackAnimals.Impl.Horse;
import geekbrains.animals.Model.Animal.Pet.Impl.Cat;
import geekbrains.animals.Model.Animal.Pet.Impl.Dog;
import geekbrains.animals.Model.Animal.Pet.Impl.Hamster;
import geekbrains.animals.Model.Config.Config;
import geekbrains.animals.Model.Repostory.Repository;
import geekbrains.animals.view.Cmd.Cmd;
import geekbrains.animals.view.Cmd.Style;
import geekbrains.animals.view.UI.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class App {
    Repository repository;
    private Map<String, Function<String, Animal>> animalTypes;

    public App() {
        this.repository = Repository.loadFromFile(Config.RepositoryFilePath);
        this.animalTypes = new HashMap<>();
        initializeAnimalTypes();
    }

    private void initializeAnimalTypes() {
        animalTypes.put("кошка", name -> new Cat(name, LocalDate.now()));
        animalTypes.put("собака", name -> new Dog(name, LocalDate.now()));
        animalTypes.put("хомяк", name -> new Hamster(name, LocalDate.now()));
        animalTypes.put("лошадь", name -> new Horse(name, LocalDate.now()));
        animalTypes.put("верблюд", name -> new Camel(name, LocalDate.now()));
        animalTypes.put("осёл", name -> new Donkey(name, LocalDate.now()));
    }

    public void addAnimal(String animalType, String name, LocalDate birthDate) {
        try {
            Function<String, Animal> animalConstructor = animalTypes.get(animalType.toLowerCase());
            if (animalConstructor == null) {
                System.out.println("Тип животного не поддерживается: " + animalType);
                return;
            }

            Animal animal = animalConstructor.apply(name);
            animal.setBirthdate(birthDate);

            repository.addAnimals(animal);

            System.out.println("Животное добавлено: " + animalType + ", имя: " + name);

        } catch (Exception e) {
            System.out.println("Ошибка при добавлении животного: " + e.getMessage());
        }

    }

    public void showAnimalList() {
        this.repository.printListOfAnimals();
    }

    public void showFirstMessage() {
        Menu menu = new Menu();
        System.out.println();
        menu.showTitle("Главное меню");
        Menu.showDescription("Для выбора действия введите в терминал подходящий символ. Вы можете просмотреть список животных добавленных в репозиторий и так же управлять данными. Если хотите увидеть меню еще раз нажмите Enter", 60);
        System.out.println();
        menu.addPoint('1', "Посмотреть список животных");
        menu.addPoint('2', "Добавить животное");
        menu.addPoint('3', "Удалить животное");
        menu.addPoint('4', "Посмотреть список команд животного");
        menu.addPoint('5', "Обучить животное команде");
        menu.addPoint('6', "Показать счётчики репозитория");

        menu.addPoint(' ', "");
        menu.addPoint('9', "Сохранить изменения и выйти.");
        menu.addPoint('0', "Выйти, без сохранения");

        menu.showMenu();
        System.out.println();
    }

    public void start() {

        showFirstMessage();
        waitAnswer();

    }

    public void waitAnswer() {

        boolean flag = false;
        while (!flag) {

            char select = Cmd.readChar(Style.BG_BLUE, " Выберите вариант: ", Style.BG_RESET, " ");

            switch (select) {
                case '1': {
                    flag = true;
                    this.showAnimalList();
                    waitAnswer();
                    break;
                }
                case '2': {
                    Menu.showDescription("кошка, собака, хомяк, лошадь, верблюд, осёл", 100);
                    String animalType = Cmd.input("Введите тип животного:");
                    String animalName = Cmd.input("Введите имя животного:");
                    Menu.showDescription("В формате дд.мм.ггг (26.06.2024)", 100);
                    String animalBirthDate = Cmd.input("Введите дату рождения:");

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                    try {
                        LocalDate date = LocalDate.parse(animalBirthDate, formatter);
                        this.addAnimal(animalType, animalName, date);
                        System.out.println("Преобразованная дата: " + date);
                    } catch (DateTimeParseException e) {
                        System.out.println("Ошибка при преобразовании даты: " + e.getMessage());
                    }

                    waitAnswer();


                    flag = true;
                    break;
                }
                case '3': {
                    Menu.showDescription("Вы можете ввести несколько ID через пробел для удаления из репозитория", 60);
                    String input = Cmd.input("Введите ID: ");

                    String[] strArray = input.split("\\s+"); // разбиваем строку по пробелам (или другим разделителям)

                    int[] intArray = new int[strArray.length];
                    for (int i = 0; i < strArray.length; i++) {
                        intArray[i] = Integer.parseInt(strArray[i]); // парсим каждый элемент в int
                    }

                    System.out.println(input);
                    this.repository.removeAnimal(intArray);
                    waitAnswer();

                    flag = true;
                    break;
                }
                case '4': {
                    String animalID = Cmd.input("Введите номер животного: ");
                    try {
                        Integer animalIDInt = Integer.parseInt(animalID);
                        Animal animal = this.repository.getAnimal(animalIDInt);
                        animal.printCommands();

                    } catch (Exception e) {
                        System.out.println("Ошибка ввода");
                        waitAnswer();
                    }
                    break;
                }
                case '5': {
                    String animalID = Cmd.input("Введите номер животного: ");
                    String command = Cmd.input("Введите команду: ");
                    try {
                        Integer animalIDInt = Integer.parseInt(animalID);
                        Animal animal = this.repository.getAnimal(animalIDInt);
                        animal.appendCommands(command);
                        waitAnswer();

                    } catch (Exception e) {
                        System.out.println("Ошибка ввода");
                        waitAnswer();
                    }
                }
                case '6': {
                    this.repository.printCounters();
                    flag = true;
                    break;
                }
                case '9': {
                    this.repository.saveToFile(Config.RepositoryFilePath);
                    flag = true;
                    break;
                }
                case '0': {
                    Menu menu = new Menu();
                    System.out.println();
                    System.out.println(Style.BG_RED + " Вы точно хотите завершить работу? " + Style.BG_RESET);
                    Menu.showDescription("Будьте внимательны, все внесенные изменения будут утрачены и не будут сохранены. Если вы передумали нажмите Отмена", 80);
                    menu.addPoint('1', "Нет, отмена!");
                    menu.addPoint('2', "Да.");
                    System.out.println();
                    menu.showMenu();
                    System.out.println();

                    boolean flagTwo = false;
                    while (!flagTwo) {

                        char selectTwo = Cmd.readChar(Style.BG_RED, " Завершить работу? ", Style.BG_RESET, " ");

                        switch (selectTwo) {
                            case '1': {
                                flag = true;
                                waitAnswer();
                                break;
                            }
                            case '2': {
                                System.out.println();
                                System.exit(0);
                                flag = true;
                                break;
                            }
                            default: {
                                System.out.println(Style.BG_RED + "Не верная команда" + Style.BG_RESET);
                                System.out.println("Повторите выбор");
                                break;
                            }
                        }


                    }
                }
                default: {
                    System.out.println(Style.BG_RED + "Не верная команда" + Style.BG_RESET);
                    System.out.println("Повторите выбор");
                    showFirstMessage();
                    break;
                }
            }
        }
    }
}
