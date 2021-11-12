import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class Contact extends ChromeRunner {

    @Test
    public void testContactForm() {

        $(byId("sm_megamenu_18")).click();

        $("#name").setValue("ruska");

        $("#email").setValue("begeladzeruska@gmail.com");

        $("#telephone").setValue("597937157");

        $("#comment").setValue("გამარჯობა,კარავი გაქვთ?");
    }

    @Test
    public void testContactPageElements() {
        $(byId("sm_megamenu_18")).click();
        $(byClassName("google-map")).shouldBe(Condition.visible);
        $(byAttribute("data-ui-id", "page-title-wrapper")).getText().equals("დაგვიკავშირდით");
        $(byText("გაგზავნეთ მესენჯერში")).shouldBe(Condition.visible);
    }

}






