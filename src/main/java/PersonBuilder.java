import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String city;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0 || age > 100) {
            throw new IllegalArgumentException("Некорректно указан возраст");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    /**
     * Делает проверку достаточности данных
     *
     * @return true - данные достаточны, иначе false
     */
    public boolean doCheck() {
        return (name != null && !name.trim().isEmpty()) &&
                (surname != null && !surname.trim().isEmpty());
    }


    public Person build() {
        if (!doCheck()) {
            throw new IllegalStateException("Данных не достаточно для создания обекта Person");
        } else {
            if (age.isPresent()) {
                return new Person(name, surname, age.getAsInt());
            } else {
                return new Person(name, surname);
            }
        }
    }
}
