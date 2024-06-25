package geekbrains.animals.Wrappers;

import java.time.LocalDate;
import java.time.Period;

public class Age {
    private Period period;

    public Age(LocalDate birthDate, LocalDate currentDate) {
        this.period = Period.between(birthDate, currentDate);
    }

    public int getMonths(){
        return this.period.getMonths();
    }

    public int getDays(){
        return this.period.getDays();
    }

    public int getYears(){
        return this.period.getYears();
    }


    public Period getPeriod() {
        return period;
    }


    @Override
    public String toString() {
        return period.getYears() + " лет " + period.getMonths() + " месяцев " + period.getDays() + " дней";
    }
}
