package Animal;

import java.util.Date;

public abstract class Animal {
    private String name;
    private Date dateofbirth;

    public Animal(String name, Date dateofbirth) {
        this.name = name;
        this.dateofbirth = dateofbirth;
    }

    public String getName() {
        return name;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}
