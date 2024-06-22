package Animal;

import java.util.Date;

abstract class Animal {
    private String name;
    private Date dateofbirth;

    public Animal(String name, Date dateofbirth) {
        this.name = name;
        this.dateofbirth = dateofbirth;
    }
}
