import Algorithms.AlgorithmInterface;
import Algorithms.BloomsFilter.BloomsFilter;
import Algorithms.FNA.FNA;
import Algorithms.Primitive.Primitive;
import Algorithms.SortedList.SortedList;
import Control.OperationsInterface;
import Model.Document;
import Model.Term;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

public class TestOperationTime
{
    private static final int iteration = 10000;
    private AlgorithmInterface[] Algorithms;
    private Document doc1,doc2;
    private Term[] terms;

    @Before
    public void setup()
    {
        terms = new Term[iteration];
        for (int i = 0; i < iteration; i++)
        {
            terms[i] = new Term(i);
        }
        doc1 = new Document();
        for (int i = 0; i < (iteration/2)+50; i++)
        {
            doc1.AddTerm(terms[i]);
        }
        doc2 = new Document();
        for (int i = (iteration/2)-50; i < iteration; i++)
        {
            doc2.AddTerm(terms[i]);
        }

        Algorithms = new AlgorithmInterface[]
                {new FNA(doc1, doc2),new Primitive(doc1,doc2),new BloomsFilter(doc1,doc2),new SortedList(doc1,doc2)};

    }

    @Test
    public void testSetUpTime()
    {
        String mes = " nanoseconds";
        System.out.println("\t\t-SetUp time for-");
        Instant start,end;
        start = Instant.now();
        AlgorithmInterface FNA = new FNA(doc1, doc2);
        end = Instant.now();
        System.out.println("FNA: " + Duration.between(start,end).toNanos()+mes);
        start = Instant.now();
        AlgorithmInterface PRI = new Primitive(doc1, doc2);
        end = Instant.now();
        System.out.println("Primitive: " + Duration.between(start,end).toNanos()+mes);
        start = Instant.now();
        AlgorithmInterface SRT = new SortedList(doc1, doc2);
        end = Instant.now();
        System.out.println("Sorted List: " + Duration.between(start,end).toNanos()+mes);
        start = Instant.now();
        AlgorithmInterface BLF = new BloomsFilter(doc1, doc2);
        end = Instant.now();
        System.out.println("Blooms Filter: " + Duration.between(start,end).toNanos()+mes);

        Algorithms = new AlgorithmInterface[] {PRI,BLF,SRT,FNA};
    }

    @Test
    public void testTime()
    {
        for (AlgorithmInterface al: Algorithms)
        {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Algorithm: "+al.getClass().toString()+"\tOperation: Union\nTime: "
                    +OperationsInterface.AddDocumentsTime(al).toSeconds()+"\tseconds");
            System.out.println("Algorithm: "+al.getClass().toString()+"\tOperation: Disjuction\nTime: "
                    +OperationsInterface.DisjointDocumentsTime(al).toSeconds()+"\tseconds");
            System.out.println("Algorithm: "+al.getClass().toString()+"\tOperation: Intersection\nTime: "
                    +OperationsInterface.IntersectDocumentsTime(al).toSeconds()+"\tseconds");
            System.out.println("Algorithm: "+al.getClass().toString()+"\tOperation: Subtraction\nTime: "
                    +OperationsInterface.SubtractDocumentsTime(al).toSeconds()+"\tseconds");
            System.out.println("Algorithm: "+al.getClass().toString()+"\tOperation: Find\nTime: "
                    +OperationsInterface.ContainsTermTime(al,new Term("A")).toSeconds()+"\tseconds");
        }
        System.out.println("------------------------------------------------------------------------------");
    }

}
