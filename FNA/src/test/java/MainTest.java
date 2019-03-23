
import Algorithms.FNA.Control;
import Model.Document;
import Model.Term;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainTest
{
    public static void main(String[] args)
    {
        Model.Term<String> s1 = new Term<>("f"),s2 = new Term<>("a");
        Model.Document doc= new Document("Deneme");
        for (int i = 0; i < 5; i++)
        {
            doc.AddTerm(s1);
            doc.AddTerm(s2);
        }

        System.out.println(Control.returnKey(doc));

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
