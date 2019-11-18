package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        clickLink("login"); 
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAnsPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        clickLink("register new user");  
    }
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        createUserWith(username, password);
    }
    
    @When("a new user is created")
    public void newUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @When("a short username {string} and valid password {string} and matching password confirmation are entered")
    public void shortUsernameAndValidPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        createUserWith(username, password);
    }
    
    @When("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String error) {
        pageHasContent("error");
    }
    
    @When("a valid username {string} and short password {string} and matching password confirmation are entered")
    public void validUsernameAndShortPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        createUserWith(username, password);
    }
    
    @When("a valid username {string} and password {string} and unmatching password confirmation are entered")
    public void validUsernameAndPasswordAndUnmatchingPasswordConfirmationAreEntered(String username, String password) {
        createUserWith(username, password);
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }
    
    private void createUserWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
    
    private void clickLink(String linkText) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText(linkText));       
        element.click(); 
    }
}
