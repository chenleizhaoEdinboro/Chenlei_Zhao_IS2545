import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * User Story Three
 * As a user,
 * I would like to see the all sorts results of Compilation,
 * So that I can know if the tokens on the parsing tree were compiled correctly 
 * and the compiler functionality working without errors .
 * @author chenlei
 *
 */
//Finally, the compiler goes through the AST 
//and writes the actual machine-level instructions to an executable
public class RBCVTestThree {
	/*  
	Compiling_: 
		1. Any program that contains `puts` should also have the `putstring` YARV operation.  
		2. A program which contains `+` should call the opt_plus operation, 
		   plus put any of the values specified on the stack using the `putobject` operation.  
		3. Any program which contains `-` (subtraction) should contain the `opt_minus` operation, 
		   any program with `/`(division) should contain `opt_div`,
		   any program with `*` should contain `opt_mult`.
	*/
	  static WebDriver driver = new HtmlUnitDriver();
	// Start at the home page for Ruby compilation visualizer for each test
	 @Before
	  public void setUp() throws Exception {
		  driver.get("http://lit-bayou-7912.herokuapp.com/");
	  }
		
	   //Scenario 1
	   //Given that I am on the main page
	   //When I click the Compile button
	   //Then I should see the text "Compile Operation" as a status reminder on the new page.
	   @Test
	   public void testShowsCorrectStatus(){
		 //After click the compile button, the new result page should contains "Compile"
		 //as a reminder of status.
		 driver.findElement(By.xpath("//input[3]")).click();
		 WebElement e = driver.findElement(By.tagName("h1"));
		 String status = e.getText();
		 assertTrue(status.contains("Compile")); 
	   }
	  
	  //Scenario 2
	  //Given I typed in a string contains identifier 'puts' on the main page
	  //when I click on the Compile button
	  //Then there should have the `putstring` YARV operation
	  @Test
	  public void testShowPutString(){
		  String str = "puts \"Hello\"";
		  driver.findElement(By.id("code_code")).sendKeys(str);
		  driver.findElement(By.xpath("//input[3]")).click();
		  WebElement e = driver.findElement(By.tagName("code"));
		  String status = e.getText();
		  assertTrue(status.contains("putstring")); 
	  }
	  
	 //Scenario 3
	 // Given I typed in the plus operation
	 // When I click on the Compile button
	 // Then there should have the 'opt_plus' and 'putobject' operations
	 @Test
	 public void testOperatorPlus(){
		  String str = "1+1";
		  driver.findElement(By.id("code_code")).sendKeys(str);
		  driver.findElement(By.xpath("//input[3]")).click();
		  WebElement e = driver.findElement(By.tagName("code"));
		  String status = e.getText();
		  assertTrue(status.contains("opt_plus"));
		  assertTrue(status.contains("putobject"));
	 }
	 
	
	 //Scenario 4
	 // Given I typed in the '-'(substraction),'/'(division) and '*'
	 // When I click on the Compile button
	 // Then there should have the 'opt_minus', 'opt_div', 'opt_mult' on the result page
	 @Test
	 public void testOpertors(){
		 String str =  "(2-1)/1*3";
		 driver.findElement(By.id("code_code")).sendKeys(str);
		 driver.findElement(By.xpath("//input[3]")).click();
		 WebElement e = driver.findElement(By.tagName("code"));
		  String status = e.getText();
		  assertTrue(status.contains("opt_minus"));
		  assertTrue(status.contains("opt_div"));
		  assertTrue(status.contains("opt_mult"));	  	 
	 }
	 
			
}
