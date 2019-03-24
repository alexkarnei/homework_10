package by.itstep.karnei.tasklist.model;

import java.io.Serializable;
import java.util.Objects;

public class Executor implements Serializable {
    private String name;
    private String surname;
    private String position;

    public Executor() {
    }

    public Executor(String name, String surname, String position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Executor)) return false;
        Executor executor = (Executor) o;
        return getName().equals(executor.getName()) &&
                getSurname().equals(executor.getSurname()) &&
                getPosition().equals(executor.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPosition());
    }

    @Override
    public String toString() {
        return "Executor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
