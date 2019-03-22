
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainTest
{
    public static void main(String[] args)
    {
        Result result= JUnitCore.runClasses();
        if(result.wasSuccessful())
        {
            System.out.println("Tests was successful");
            return;
        }
        for (Failure failure:result.getFailures())
        {
            System.out.println(failure.getMessage());
        }
    }
}
