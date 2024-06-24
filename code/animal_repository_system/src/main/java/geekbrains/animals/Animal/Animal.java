package geekbrains.animals.Animal;
import geekbrains.animals.Wrappers.Age;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Animal implements Serializable {
    private String name;
    private LocalDate birthdate;
    private String type;
    private ArrayList<String> commands;

    public Animal() {

    }

    public Animal(String name, LocalDate birthdate) {
        this.name = name;
        this.commands = new ArrayList<>();
        this.birthdate = birthdate;
    }

    public void giveCommand(String command) {

        if (commands.contains(command)) {
            System.out.println(this.name + " выполняет команду: " + command);
        } else {
            System.out.println(this.name + " не умеет выполнять команду: " + command);
        }

    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public String getType() {
        return type;
    }

    public Age getAge() {
        LocalDate now = LocalDate.now();
        return new Age(this.birthdate, now);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public void setCommands(String ...commands) {
        this.commands.clear();
        Collections.addAll(this.commands, commands);
    }

    public void appendCommands(String ...commands) {
        Collections.addAll(this.commands, commands);
    }

    @Override
    public String toString() {
        return ("Вид: " + this.type + ","
                + " кличка: " + this.name + ","
                + " дата рождения: " +
                + this.birthdate.getDayOfMonth() + "."
                + this.birthdate.getMonthValue() + "."
                + this.birthdate.getYear()
                + ","
                + " возраст: " +this.getAge()
        );
    }

}
