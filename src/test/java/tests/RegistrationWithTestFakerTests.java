package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

import java.util.Locale;
import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static enums.ResultTableEnums.*;
import static enums.ResultTableEnums.ADDRESS;
import static enums.ResultTableEnums.MOBILE;


public class RegistrationWithTestFakerTests extends TestBase {

    TestData testData = new TestData();
    RegistrationPage registrationPage= new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

      registrationPage.openPage()
              .setFirstName(testData.firstName)
              .setLastName(testData.lastName)
              .setEmail(testData.email)
              .setGenter(testData.gender)
              .setUserNumber(testData.userNumber)
              .setDateOfBirth(testData.day, testData.month, testData.year)
              .setSubject(testData.subject)
              .setHobbies(testData.hobbies)
              .setPicture(testData.uploadFile)
              .setAddress(testData.address)
              .setState(testData.state)
              .setCity(testData.city)
              .clickSubmitButton()
              .checkResultTitle()
              .checkResultTable(Map.of(
                              STUDENT_NAME, testData.firstName + " " + testData.lastName,
                              STUDENT_EMAIL, testData.email,
                              GENDER, testData.gender,
                              MOBILE, testData.userNumber,
                      DATE_OF_BIRTH, testData.day + " " + testData.month + ", " + testData.year,
                              SUBJECTS, testData.subject,
                              ADDRESS, testData.address,
                              PICTURE, testData.uploadFile,
                              STATE_AND_CITY, testData.state + " " + testData.city)
              );

    }
}