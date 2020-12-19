
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyStepWhenDoTest {
    @Given("yo abro el aplicativo")
    public void yoAbroElAplicativo() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformVersion","8");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        Runner.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // implicit wait  (tiempo para todos los controles)
        Runner.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("yo realizo click en agregarAlarma")
    public void yoRealizoClickEnAgregarAlarma() {
        // click Agregar Alarma
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();

    }

    @And("yo realizo click en el boton fijarRecordatorio")
    public void yoRealizoClickEnElBotonFijarRecordatorio() {
        // click Fecha Limite, recordatorio Repetir
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/note_item_reminder")).click();

    }

    @And("yo realizo click en el boton ingresarFechaLimite")
    public void yoRealizoClickEnElBotonIngresarFechaLimite() {
        // Seleccionar Opción Fijar Fecha Limite
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/due_date")).click();
        // seleccionar una fecha
        Runner.driver.findElement(By.xpath("//android.view.View[@content-desc=\"21 diciembre 2020\"]")).click();
        // click en aceptar
        Runner.driver.findElement(By.id("android:id/button1")).click();

    }

    @And("yo realizo click en el boton fijarHora")
    public void yoRealizoClickEnElBotonFijarHora() {
        // Seleccionar Opción Fijar Hora
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/time")).click();
        // Escoger Hora con click
        Runner.driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"9\"]")).click();
        Runner.driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        // Escoger minutos con click
        Runner.driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"25\"]")).click();
        // click en aceptar Hora
        Runner.driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

    }

    @And("yo realizo click en el boton recordarATiempo : {string}")
    public void yoRealizoClickEnElBotonRecordarATiempoRecordar(String recordar) {
        // click en Opcion recordar a Tiempo
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/reminder")).click();
        //seleccionar check recordar
        Runner.driver.findElement(By.xpath("//android.widget.RadioButton[@text='" + recordar + "']")).click();
        //seleccionar repetir/fijar frecuencia
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/repeat")).click();
        //seleccionar check repetir
        Runner.driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Diariamente\"]")).click();

    }

    @And("yo lleno la caja de texto titulo con : {string}")
    public void yoLlenoLaCajaDeTextoTituloConTitulo(String titulo) {
        //Ingresar Titulo
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo);

    }

    @And("yo lleno la caja de texto notas con : {string}")
    public void yoLlenoLaCajaDeTextoNotasConNotas(String notas) {
        //Ingresar Notas
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(notas);

    }

    @And("yo realizo click en el boton guardar")
    public void yoRealizoClickEnElBotonGuardar() {
        //Guardar
        Runner.driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Guardar\"]")).click();

    }

    @Then("yo deberia guardar el recordatorio : {string}")
    public void yoDeberiaGuardarElRecordatorio(String titulo) {
        List<WebElement> myControls= Runner.driver.findElements(By.xpath("//android.widget.TextView[@text='"+titulo+"']"));
        Assert.assertTrue("ERROR !! El contacto no fue creado",myControls.size()>0);

    }


}
