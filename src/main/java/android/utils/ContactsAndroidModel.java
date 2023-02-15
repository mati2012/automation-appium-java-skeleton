package android.utils;

import com.github.javafaker.Faker;

import java.util.ArrayList;

public class ContactsAndroidModel {
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String phone;
    private final String email;

    public ContactsAndroidModel() {
        Faker faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.company = faker.company().name();
        this.phone = faker.phoneNumber().cellPhone();
        this.email = faker.internet().emailAddress();

    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getFullContactInfo() {
        ArrayList<String> fullContactInfo = new ArrayList<>();
        fullContactInfo.add(getFullName());
        fullContactInfo.add(getCompany());
        fullContactInfo.add(getPhone());
        fullContactInfo.add(getEmail());
        return fullContactInfo;
    }
}
