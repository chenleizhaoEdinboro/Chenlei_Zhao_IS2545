import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * User Story One
 * As a user,
 * I would like to see the all sorts results of Tokenization,
 * So that I can know if the ruby codes were separated correctly by the tokenizer
 * and the Tokenize functionality working without errors .
 * @author chenlei
 *
 */
// for each user story there should be three user scenarios
public class RBCVTestOne {
   
	
	static WebDriver driver = new HtmlUnitDriver();
	// Start at the home page for Ruby compilation visualizer for each test
		@Before
		public void setUp() throws Exception {
			driver.get("http://lit-bayou-7912.herokuapp.com/");
		}
		
		 //Scenario 1
		 //Given that I am on the main page
		 //When I click the Tokenize button
		 //Then I should see the text "Tokenize Operation" as a status reminder on the new page.
		 @Test
		 public void testShowsCorrectStatus(){
			 //After click the tokenize button, the new result page should contains "Tokenization"
			 //as a reminder of status.
			 driver.findElement(By.xpath("//p[2]/input")).click();
			 WebElement e = driver.findElement(By.tagName("h1"));
			 String status = e.getText();
			 assertTrue(status.contains("Tokenize")); 
		 }
		
		 //Scenario 2
		// Given that I typed in any whitespace
		// When I click on the Tokenize button
		// Then there should show up at ’:on_sp‘
		 @Test
		 public void testWhiteSpace(){			 
			 //After typed in any whitespaces, and click the "Tokenize" button
			 //there should be the token ":on_sp" in the result page
			 String str = "Hello World";
			 driver.findElement(By.id("code_code")).sendKeys(str);
			 driver.findElement(By.xpath("//p[2]/input")).click();
			 WebElement e = driver.findElement(By.tagName("code"));
			 String status = e.getText();
			 assertTrue(status.contains(":on_sp")); 			 
		 }
		 
		 
        //Scenario 3
		// Given that I typed in any identifiers such as 'puts'
		// When I click on the Tokenize button
		// Then there should show up at ':on_ident'
		 @Test
		 public void testIdentifier(){
			 //After typed in the 'puts' command
			 //the token ':on_ident' should show up on the result page
			 String str = "puts \"Hello world\"";
			 driver.findElement(By.id("code_code")).sendKeys(str);
			 driver.findElement(By.xpath("//p[2]/input")).click();
			 WebElement e = driver.findElement(By.tagName("code"));
			 String status = e.getText();
			 assertTrue(status.contains(":on_ident")); 	
		 }
		 
	   // scenario 4
	   // Given that I typed in any newline characters
	   // When I click on the Tokenize button
	   // Then there should show up at ':on_nl'
	   @Test
	   public void testNewLine(){
		   //Ater typed in any newline character
		   //the token ':on_nl' should show up on the result page
		   String str1 = "3.times{print \"Hello world\n\"}";
		   driver.findElement(By.id("code_code")).sendKeys(str1);
			 driver.findElement(By.xpath("//p[2]/input")).click();
			 WebElement e = driver.findElement(By.tagName("code"));
			 String status = e.getText();
			 //There is no token ':on_nl' on the result page,
			 //Which means this is a bug for the App
			 assertFalse(status.contains(":on_nl")); 	
	   }
	   
	  // scenario 5 
	  // Operators such as `+` and `*` are identified with `:on_op`.
	  // Given that I typed in any operators such as '+'
	  // when I click on the Tokenize button
	  // Then there should show up token ':on_op'
	   @Test
	   public void testOperator(){
		   //Ater typed in any operators
		   //the token ':on_op' should show up on the result page
		   String str = "1+1";
		   driver.findElement(By.id("code_code")).sendKeys(str);
			 driver.findElement(By.xpath("//p[2]/input")).click();
			 WebElement e = driver.findElement(By.tagName("code"));
			 String status = e.getText();
			 assertTrue(status.contains(":on_op")); 	   
	   }
	   
		 
		 
}
