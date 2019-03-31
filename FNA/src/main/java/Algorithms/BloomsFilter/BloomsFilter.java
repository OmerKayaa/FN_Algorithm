package Algorithms.BloomsFilter;

import Algorithms.AlgorithmsAbs;
import Model.Document;
import Model.Term;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BloomsFilter extends AlgorithmsAbs
{
    private final BloomFilterModel uniqueTerms;
    private BigInteger k1,k2;
    private Term[] terms;

    public BloomsFilter(Document doc1,Document doc2)
    {
        super.setUp(doc1,doc2);
        uniqueTerms = new BloomFilterModel();

        for(Term t:doc1)
            uniqueTerms.AddTerm(t);
        for(Term t:doc2)
            uniqueTerms.AddTerm(t);

        k1 = BigInteger.ZERO;
        k2 = BigInteger.ZERO;
        terms = uniqueTerms.getTerms();

        for (int i = 0; i < terms.length; i++)
        {
            if(doc1.Exist(terms[i]))
                k1 = k1.setBit(i);
            if(doc2.Exist(terms[i]))
                k2 = k2.setBit(i);
        }
    }

    @Override
    public List<Term> IntersectDocuments()
    {
        return getTerms(k1.and(k2));
    }

    @Override
    public List<Term> DisjunctDocuments()
    {

        return getTerms(k1.xor(k2));
    }

    @Override
    public List<Term> AddDocuments()
    {
        return getTerms(k1.or(k2));
    }

    @Override
    public List<Term> SubtractDocuments()
    {

        return getTerms(k1.and(k1.andNot(k2)));
    }

    @Override
    public boolean Contains(Term t)
    {
        for (int i = 0; i < terms.length; i++)
        {
            if(t.equals(terms[i]))
                return k1.testBit(i);
        }
        return false;
    }

    private List<Term> getTerms(BigInteger integer)
    {
        List<Term> list = new ArrayList<>();
        for (int i = 0; i < terms.length; i++)
        {
            if(integer.testBit(i))
                list.add(terms[i]);
        }
        return list;
    }
}
