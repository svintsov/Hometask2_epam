import com.bazyl.credits.RandomGenerator;
import org.junit.Assert;
import org.junit.Test;

public class RandomGenerationTest {

  @Test
  public void testWithDefaultRange(){
    int value=102;
    for(int i=0;i<1000;i++){
      Assert.assertNotEquals(value, RandomGenerator.rand());
    }
  }
}
