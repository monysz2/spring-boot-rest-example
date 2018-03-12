package pl.maslowskis.entity.request;

/**
 * Created by oro-6 on 3/12/2018.
 */
public class AddUserRequest {
    private String name;
    private String surname;

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
}
