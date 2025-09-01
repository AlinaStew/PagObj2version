package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private static final Faker faker = new Faker(new Locale("en-US"));
    public String firstName = getRandomFirstName(),
        lastName = getRandomLastName(),
        email = getRandomEmail(),
        gender = getRandomGender(),
        userNumber = getRandomUserNumber(),
        month = getRandomMonth(),
        year = getRandomYear(),
        day = getRandomDay(),
        subject = getRandomSubject(),
        hobbies = getRandomHobbies(),
        uploadFile = getRandomFile(),
        address = getRandomAddress(),
        state = getRandomState(),
        city = getRandomCity(state);

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public String getRandomUserNumber() {
        return faker.number().digits(10);
    }

    public String getRandomDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public String getRandomMonth() {
        String[] month = {"December", "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November"};
        return faker.options().option(month);
    }

    public String getRandomYear() {
        return String.valueOf(faker.number().numberBetween(1950, 2012));
    }

    public String getRandomSubject() {
        return faker.options().option("English", "Maths", "Arts", "Hindi", "History");
    }

    public String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getRandomCity(String state) {
        String city = "";
        if (state.equals("NCR")) city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana")) city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) city = faker.options().option("Jaipur", "Jaiselmer");
        return city;
    }

    public String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomFile() {
        return faker.options().option("pic1.png", "pic2.png");
    }
}
