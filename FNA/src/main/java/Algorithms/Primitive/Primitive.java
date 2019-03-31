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
        List<Term> list = new ArrayList<>();
        for(Term t:doc2)
        {
            if(Contains(t))
                list.add(t);
        }
        return list;
    }

    @Override
    public List<Term> DisjunctDocuments()
    {
        List<Term> l = new ArrayList<>(AddDocuments());
        l.removeAll(IntersectDocuments());
        return l;
    }

    @Override
    public List<Term> AddDocuments()
    {
        List<Term> list = new ArrayList<>();
        for(Term t:doc2)
        {
            if(!Contains(t))
                list.add(t);
        }
        for(Term t:doc1)
        {
            list.add(t);
        }
        return list;
    }

    @Override
    public List<Term> SubtractDocuments()
    {
        List<Term> list = new ArrayList<>();
        for(Term t:doc1)
        {
            list.add(t);
        }
        for(Term t:doc2)
        {
            if(Contains(t))
                list.remove(t);
        }
        return list;
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
