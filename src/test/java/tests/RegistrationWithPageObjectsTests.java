package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage= new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
      registrationPage.openPage()
              .setFirstName("Alex")
              .setLastName("Egorov")
              .setEmail("alex@egorov.com")
              .setGenter("Other")
              .setUserNumber("1234567890")
              .setDateOfBirth("30", "July", "2008")
              .setSubject("Math")
              .setHobbies("Sports")
              .setPicture("pic1.png")
              .setAddress("Some address 1")
              .setState("NCR")
              .setCity("Delhi")
              .clickSubmitButton()
              .checkResult("Student Name", "Alex Egorov")
              .checkResult("Student Email", "alex@egorov.com")
              .checkResult("Mobile", "1234567890");

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}