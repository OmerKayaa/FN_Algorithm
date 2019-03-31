import Algorithms.AlgorithmInterface;
import Algorithms.BloomsFilter.BloomsFilter;
import Algorithms.FNA.FNA;
import Algorithms.Primitive.Primitive;
import Algorithms.SortedList.SortedList;
import Control.OperationsInterface;
import Model.Document;
import Model.Term;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestOperations
{
    private Term a=new Term("A"),b=new Term("B"),c=new Term("C"),d=new Term("D"),e=new Term("E"),f=new Term("F")
            ,g=new Term("G"),h=new Term("H"),i=new Term("I"),j=new Term("J"),k=new Term("K"),l=new Term("L")
            ,m=new Term("M"),n=new Term("N"),o=new Term("O"),p=new Term("P"),q=new Term("Q"),r=new Term("R");
    private AlgorithmInterface[] Algorithms;
    private Document doc1,doc2;

    @Before
    public void setup()
    {
        doc1 = new Document();
        doc1.AddAll(a,b,c,d,e,f,g,h,i,j,k,l);
        doc2 = new Document();
        doc2.AddAll(a,b,c,q,p,m,n,o,r);
        Algorithms = new AlgorithmInterface[]
                {new FNA(doc1, doc2),new Primitive(doc1,doc2),new BloomsFilter(doc1,doc2),new SortedList(doc1,doc2)};
    }

    @Test
    public void testAdd()
    {
        String mes = "Addition operation failed on ";
        for (AlgorithmInterface Al: Algorithms)
        {
            List<Term> list = OperationsInterface.AddDocuments(Al);
            Assert.assertTrue(mes + Al.getClass(),list.size()==18);
            Assert.assertTrue(mes + Al.getClass(),list.contains(a));
            Assert.assertTrue(mes + Al.getClass(),list.contains(d));
            Assert.assertTrue(mes + Al.getClass(),list.contains(j));
            Assert.assertTrue(mes + Al.getClass(),list.contains(g));
            Assert.assertTrue(mes + Al.getClass(),list.contains(n));
            Assert.assertTrue(mes + Al.getClass(),list.contains(r));
        }
    }

    @Test
    public void testSub()
    {
        String mes = "Subtraction operation failed on ";
        for (AlgorithmInterface Al:Algorithms)
        {
            List<Term> list = OperationsInterface.SubtractDocuments(Al);
            Assert.assertTrue(mes + Al.getClass(),list.size()==9);
            Assert.assertTrue(mes + Al.getClass(),!list.contains(a));
            Assert.assertTrue(mes + Al.getClass(),!list.contains(b));
            Assert.assertTrue(mes + Al.getClass(),!list.contains(c));
            Assert.assertTrue(mes + Al.getClass(),list.contains(e));
            Assert.assertTrue(mes + Al.getClass(),list.contains(h));
            Assert.assertTrue(mes + Al.getClass(),list.contains(l));
        }

    }

    @Test
    public void testIntersection()
    {
        String mes = "Intersection operation failed on ";
        for (AlgorithmInterface Al:Algorithms)
        {
            List<Term> list = OperationsInterface.IntersectDocuments(Al);
            Assert.assertTrue(mes + Al.getClass(),list.size()==3);
            Assert.assertTrue(mes + Al.getClass(),list.contains(a));
            Assert.assertTrue(mes + Al.getClass(),list.contains(b));
            Assert.assertTrue(mes + Al.getClass(),list.contains(c));
        }
    }

    @Test
    public void testDisjunction()
    {
        String mes = "Disjunction operation failed on ";
        for (AlgorithmInterface Al:Algorithms)
        {
            List<Term> list = OperationsInterface.DisjunctDocuments(Al);
            Assert.assertTrue(mes + Al.getClass(),list.size()==15);
            Assert.assertTrue(mes + Al.getClass(),!list.contains(a));
            Assert.assertTrue(mes + Al.getClass(),!list.contains(b));
            Assert.assertTrue(mes + Al.getClass(),!list.contains(c));
        }

    }

    @Test
    public void testContains()
    {
        String mes = "Contains operation failed on ";
        for (AlgorithmInterface Al: Algorithms)
        {
            Assert.assertTrue(mes + Al.getClass(),OperationsInterface.ContainsTerm(Al,a));
            Assert.assertTrue(mes + Al.getClass(),OperationsInterface.ContainsTerm(Al,d));
            Assert.assertTrue(mes + Al.getClass(),OperationsInterface.ContainsTerm(Al,h));
            Assert.assertTrue(mes + Al.getClass(),OperationsInterface.ContainsTerm(Al,k));
            Assert.assertTrue(mes + Al.getClass(),OperationsInterface.ContainsTerm(Al,new Term("Z")));
        }
    }
}
