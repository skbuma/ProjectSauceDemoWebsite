package saucedemoproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ProjectTest {
     
	
	private WebDriver driver;
	private LoginPage loginPage;
	private AddToCart addToCart;
	private ContinueShopping continueShopping;
	private CheckoutPage checkoutPage;
	
    
    @BeforeSuite
    public void setUp() 
    {
	    // Set up WebDriver
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	
	    // Initialize LoginPage
	    loginPage = new LoginPage(driver);
    }
    
    @Test(priority=1)
    public void openURL() throws InterruptedException
    {
    	driver.get("https://www.saucedemo.com/");
    	Thread.sleep(5000);
    }
    
    
    @Test(priority=2)
    //Test Login page with valid user id and password  
    public void testLoginWithValidCredentials() throws InterruptedException 
    {
    	//Enter username in the textbox
    	System.out.println("Send Username");
    	loginPage.type_Username("standard_user");
    	Thread.sleep(1000);
    	
    	//Enter password in the textbox
    	System.out.println("Send Password");
        loginPage.type_Password("secret_sauce");
        Thread.sleep(1000);
        
        
        //Click on login button
        System.out.println("Send Login button");
        loginPage.click_Login();
        Thread.sleep(1000);
        
        
     // Verify successful login
        System.out.println("Getting actualUrl");
        String actualUrl = driver.getCurrentUrl();
        
        System.out.println("Getting expectedUrl");
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        
        System.out.println("Checking assertions");
        Assert.assertEquals(actualUrl, expectedUrl, "Login was not successful!");
    }
    
    //loginErrorMessage
 
 /*   @Test(priority=3)
    //Test Login page with invalid user id and password  
    public void testLoginWithInvalidCredentials() throws InterruptedException 
    {
    	//navigate back to login screen;
    	driver.navigate().back();
    	
    	//Enter username in the textbox
    	System.out.println("Send Username");
    	loginPage.setUsername("invalid_user");
    	Thread.sleep(5000);
    	
    	//Enter password in the textbox
    	System.out.println("Send Password");
        loginPage.setPassword("invalid_password");
        Thread.sleep(5000);
        
        
        //Click on login button
        System.out.println("Send Login button");
        loginPage.clickLogin();
        Thread.sleep(5000);
        
        
     // Verify error message for invalid login
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        
        
        System.out.println("Checking assertions");
        Assert.assertEquals(errorMessage, expectedErrorMessage, "Error message is not as expected for invalid login!");
        
        //navigate back
        Thread.sleep(5000);
        
        driver.navigate().back();
        Thread.sleep(5000);
        testLoginWithValidCredentials(); 
    }*/
    
    
    
    @Test(priority=3)
    public void test_SDProducts() throws InterruptedException 
    {
       //verify Products Page
  	  String ActTextProducts=loginPage.captureProductsText();
  	  String ExpTextProducts="Products";
  	  
  	 if (ActTextProducts.equalsIgnoreCase(ExpTextProducts))
  	  {
  		  System.out.println("Products Label Present");
  	  }
  	  else
  	  {
  		System.out.println("Products Label Not Present");
  	  } 
  	 
  	  Assert.assertEquals(ActTextProducts, ExpTextProducts);
  	  
  	
  	
    }
    
        
    @Test(priority=4)
    public void test_AddToCart() throws InterruptedException 
    {
       addToCart = new AddToCart(driver);
       addToCart.addToCartbutton();
       addToCart.emptyShoppingCart();
  	
    }
    
    
    @Test(priority=5)
    public void test_ContinueShopping() throws InterruptedException 
    {
    	continueShopping = new ContinueShopping(driver);
    	continueShopping.ClickContinueShopping();
    	continueShopping.moveToCheckoutScreen();
    	continueShopping.clickCheckoutButton();
    }
    
    
    @Test(priority=6)
    public void test_Checkout() throws InterruptedException 
    {
    	checkoutPage = new CheckoutPage(driver);
    	checkoutPage.ClickCheckoutPageBtn();
    	
    	//Click on check out button
    	checkoutPage.ClickFinishBtn();
    	
    	//Check the final page
    	checkoutPage.checkFinalPage();  	
    	
    }
    
    
    
    
    @AfterSuite
    public void tearDown() {
        // Close the WebDriver
        driver.quit();
    }
   
    

	
	
	
}
