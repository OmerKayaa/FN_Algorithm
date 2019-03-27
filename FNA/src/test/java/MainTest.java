
import Algorithms.FNA.FNA;
import Model.Document;
import Model.Term;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainTest
{
    public static void main(String[] args)
    {
        Term a=new Term("A"),b=new Term("B"),c=new Term("C"),d=new Term("D"),e=new Term("E"),f=new Term("F")
                ,g=new Term("G"),h=new Term("H"),i=new Term("I"),j=new Term("J"),k=new Term("K"),l=new Term("L")
                ,m=new Term("M"),n=new Term("N"),o=new Term("O"),p=new Term("P"),q=new Term("Q"),r=new Term("R");

        Document d1 = new Document();
        d1.AddTerm(a);
        d1.AddTerm(b);
        d1.AddTerm(c);
        d1.AddTerm(d);
        d1.AddTerm(e);
        d1.AddTerm(f);
        Document d2 = new Document();
        d2.AddTerm(a);
        d2.AddTerm(e);
        d2.AddTerm(f);
        d2.AddTerm(b);
        d2.AddTerm(g);
        d2.AddTerm(h);
        d2.AddTerm(i);
        d2.AddTerm(j);
        d2.AddTerm(k);
        d2.AddTerm(l);
        d2.AddTerm(m);

        Algorithms.FNA.FNA al = new FNA(d1,d2);

        for (Term t: al.DisjunctDocuments())
        {
            System.out.println(t.getTerm());
        }

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
