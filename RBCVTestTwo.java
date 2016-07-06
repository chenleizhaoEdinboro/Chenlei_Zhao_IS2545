import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * User Story Two
 * As a user,
 * I would like to see the all sorts results of Parse,
 * So that I can know if the tokens were parsed correctly 
 * and the Parser functionality working without errors .
 * @author chenlei
 *
 */

public class RBCVTestTwo {
	
	
	   static WebDriver driver = new HtmlUnitDriver();
	// Start at the home page for Ruby compilation visualizer for each test
		@Before
		public void setUp() throws Exception {
			driver.get("http://lit-bayou-7912.herokuapp.com/");
		}
	
		   //Scenario 1
		   //Given that I am on the main page
		   //When I click the Parse button
		   //Then I should see the text "Parse Operation" as a status reminder on the new page.
		   @Test
		   public void testShowsCorrectStatus(){
			 //After click the parse button, the new result page should contains "Parse"
			 //as a reminder of status.
			 driver.findElement(By.xpath("//p[2]/input[2]")).click();
			 WebElement e = driver.findElement(By.tagName("h1"));
			 String status = e.getText();
			 assertTrue(status.contains("Parse")); 
		   }
	        //Scenario 2
			//Given I typed in a string contains whitespace
			//when I click on the Parse button
			//Then there should not appear any ':on_sp' in the AST(parse tree)
			
			 @Test
			 public void testWhiteSpace(){			 
				 //After typed in any whitespaces, and click the "Parse" button
				 //there should NOT be the token ":on_sp" in the result page
				 String str = "Hello World";
				 driver.findElement(By.id("code_code")).sendKeys(str);
				 driver.findElement(By.xpath("//p[2]/input[2]")).click();
				 WebElement e = driver.findElement(By.tagName("code"));
				 String status = e.getText();
				 assertFalse(status.contains(":on_sp")); 			 
			 }
			 
			//Scenario 3
			//Given I typed in a string contains newline characters
			//when I click in the Parse button
			//Then there should not appear any ':on_nl' in the AST
			 
			@Test
			public void testNewLine(){
			   //After typed in any newline charater, and click the "Parse" button
			   // There should NOT be the token ':on_nl" in the result page
				 String str = "Hello\n";
				 driver.findElement(By.id("code_code")).sendKeys(str);
				 driver.findElement(By.xpath("//p[2]/input[2]")).click();
				 WebElement e = driver.findElement(By.tagName("code"));
				 String status = e.getText();
				 assertFalse(status.contains(":on_nl")); 
			}
	
	      //Scenario 4
		  //Given I typed in some operators
		  //When I click in the Parse button
		  //Then all of the operators' tokens should appear on the parse tree
			
		 @Test
		 public void testOperators(){
			 String str = "1+1*2";
			 driver.findElement(By.id("code_code")).sendKeys(str);
			 driver.findElement(By.xpath("//p[2]/input[2]")).click();
			 WebElement e = driver.findElement(By.tagName("code"));
			 String status = e.getText();
			 assertFalse(status.contains(":on_op")); 
			 
		 }
	
}
