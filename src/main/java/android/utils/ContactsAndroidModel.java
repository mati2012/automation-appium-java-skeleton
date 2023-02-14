package android.utils;

import com.github.javafaker.Faker;

public class ContactsAndroidModel {
    private String name, phone, email, groups;

    public ContactsAndroidModel(String groups) {
        Faker faker = new Faker();

        this.name = faker.name().firstName();
        this.phone = faker.phoneNumber().cellPhone();
        this.email = faker.internet().emailAddress();
        this.groups = groups;
    }
}
