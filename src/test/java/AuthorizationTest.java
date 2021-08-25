import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class AuthorizationTest {

    @BeforeEach
    public void setUp() {
        open("https://lmslite47vr.demo.mirapolis.ru/mira");
    }

    @Test
    public void shouldSubmitRequest() {
        SelenideElement form = $("[method=post]");
        form.$("[name=user]").setValue("fominaelena");
        form.$("[name=password]").setValue("z0K6CTQR");
        form.$("[type=submit]").click();
        $("[title=Новости]").shouldHave(text("Новости"));

    }

    @Test
    public void shouldNotSubmitWrongPassword() {
        SelenideElement form = $("[method=post]");
        form.$("[name=user]").setValue("fominaelena");
        form.$("[name=password]").setValue("badpassword");
        form.$("[type=submit]").click();
        $("[class=info-title]").shouldHave(text("Вход в систему"));

    }



    @Test
    public void shouldShowPassword() {
        SelenideElement form = $("[method=post]");
        form.$("[name=user]").setValue("fominaelena");
        form.$("[name=password]").setValue("badpassword");
        form.$("[id=show_password]").click();
        $("[name=password]").shouldBe(visible);

    }


    @Test
    public void shouldNotSubmitWrongLogin() {
        SelenideElement form = $("[method=post]");
        form.$("[name=user]").setValue("haha");
        form.$("[name=password]").setValue("z0K6CTQR");
        form.$("[type=submit]").click();
        $("[class=info-title]").shouldHave(text("Вход в систему"));

    }
}
