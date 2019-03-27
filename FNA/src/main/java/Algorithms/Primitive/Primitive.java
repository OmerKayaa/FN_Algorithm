package Algorithms.Primitive;

import Algorithms.AlgorithmsAbs;
import Model.Document;
import Model.Term;

import java.util.ArrayList;
import java.util.List;

public class Primitive extends AlgorithmsAbs
{

    public Primitive(Document d1,Document d2)
    {
        super.setUp(d1,d2);
    }

    @Override
    public List<Term> IntersectDocuments()
    {
        return new ArrayList<>();
    }

    @Override
    public List<Term> DisjunctDocuments()
    {
        return new ArrayList<>();
    }

    @Override
    public List<Term> AddDocuments()
    {
        return new ArrayList<>();
    }

    @Override
    public List<Term> SubtractDocuments()
    {
        return new ArrayList<>();
    }

    @Override
    public boolean Contains(Term t)
    {
        for(Term term:doc1)
        {
            if(term.equals(t))
                return true;
        }
        return false;
    }
}
