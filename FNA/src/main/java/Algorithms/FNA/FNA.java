package Algorithms.FNA;

import Algorithms.AlgorithmInterface;
import Model.Document;
import Model.Term;

public class FNA implements AlgorithmInterface
{
    @Override
    public void AddDocument(Document doc)
    {

    }

    @Override
    public Term[] IntersectDocuments(Document... doc)
    {
        return new Term[0];
    }

    @Override
    public Term[] DisjointDocuments(Document... doc)
    {
        return new Term[0];
    }

    @Override
    public Term[] AddDocuments(Document... doc)
    {
        return new Term[0];
    }

    @Override
    public Term[] SubtractDocuments(Document... doc)
    {
        return new Term[0];
    }
}
