package Algorithms;

import Model.Document;
import Model.Term;

import java.util.List;

public interface AlgorithmInterface
{
    void setUp(Document doc1,Document doc2);

    List<Term> IntersectDocuments();
    List<Term> DisjunctDocuments();
    List<Term> AddDocuments();
    List<Term> SubtractDocuments();

}
