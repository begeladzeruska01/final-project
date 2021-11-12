import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class Cart extends ChromeRunner {
    @Test
    public void searchProductAndTestCart() {
        $(byClassName("block-title-menu")).hover();
        $(byText("სპორტი და ფიტნესი")).hover();

        $(byText("ბინოკლი")).click();

        $(byClassName("product-item-info")).hover();
        $(byClassName("tocart")).click();
        $(byClassName("smcqp-view-cart")).click();

        Assert.assertTrue($(byAttribute("data-role", "cart-item-qty")).getValue().equals("1"));
        $(byAttribute("data-role", "cart-item-qty")).setValue("2");
        $(byName("update_cart_action")).click();
        Assert.assertTrue($(byAttribute("data-role", "cart-item-qty")).getValue().equals("2"));

        Assert.assertTrue($(byAttribute("data-role", "proceed-to-checkout")).is(Condition.visible));

        Selenide.sleep(500);

        $(byClassName("showcart")).click();

        $(byId("top-cart-btn-checkout")).scrollTo();
        Assert.assertTrue($(byId("top-cart-btn-checkout")).is(Condition.visible));

        Assert.assertTrue($(byClassName("cart-item-qty")).getValue().equals("2"));

        Assert.assertTrue($(byText("კალათის ნახვა და რედაქტირება")).is(Condition.visible));

        $(byClassName("action-edit")).click();
        Selenide.sleep(1000);
        Assert.assertTrue($(byClassName("modal-popup")).is(Condition.visible));
    }


    @Test
    public void checkElements() {
        $(byClassName("counter-number")).getText().equals("0");
        $(byClassName("showcart")).click();

        Selenide.sleep(1000);
        Assert.assertTrue($(byText("კალათა ცარიელია")).isDisplayed());
    }

}






