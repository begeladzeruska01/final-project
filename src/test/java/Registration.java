import com.codeborne.selenide.Condition;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class Registration  extends ChromeRunner {
    @Test
    public void successRegistration() {
        Assert.assertTrue($(byText("რეგისტრაცია")).is(Condition.visible));

        $(byText("რეგისტრაცია")).click();

        SelenideElement form = $((byId("form-validate")));

        form.$(byId("firstname")).setValue("ruska");

        form.$(byId("firstname")).setValue("ruska");

        form.$(byId("lastname")).setValue("begeladze");

        form.$(byId("phone")).setValue("+995597937157");

        form.$(byId("email_address")).setValue("begeladzeruska@gmail.com");
        $(byId("wantpartner")).click();
        $(byId("profileurl")).shouldBe(Condition.visible);

        $(byId("wantpartner0")).click();
        $(byId("profileurl")).shouldNotBe(Condition.visible);

        form.$(byId("password")).setValue("RuskaBegeladze1111");

        form.$(byName("password_confirmation")).setValue("RuskaBegeladze1111");

        $(byClassName("submit")).click();

        Assert.assertTrue(form.$(byId("firstname")).getValue().equals(""));
    }

    @Test
    public void failedRegistration() {
        $(byText("რეგისტრაცია")).click();

        $(byClassName("submit")).click();

        $(byId("firstname-error")).shouldBe(Condition.visible);

        $(byId("lastname-error")).shouldBe(Condition.visible);

        $(byId("phone-error")).shouldBe(Condition.visible);

        $(byId("password-error")).shouldBe(Condition.visible);

        $(byId("password-confirmation-error")).shouldBe(Condition.visible);


        $(byId("phone")).setValue("2342342342");
        $(byId("email_address")).setValue("fsfds@a.a");
        $(byClassName("submit")).click();

        Assert.assertTrue($(byId("phone-error")).getText().equals("გთხოვთ, შეიყვანოთ ტელეფონი ამ ფორმატში +995 XXX XXX XXX"));

        Assert.assertTrue($(byId("email_address-error")).getText().equals("შეიყვანეთ ელ.ფოსტა"));
    }
}






