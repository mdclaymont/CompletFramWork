package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("Test Passed");
	  Assert.assertTrue(true);
  }
  @Test
  public void f1() {
	  System.out.println("failed");
	  Assert.assertTrue(false);
  }
  @Test
  public void f2() {
	  System.out.println("Skip");
	 throw new SkipException("This skip");
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Test Before");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After test");
  }

}
