package Algorithms.BloomsFilter;

import Model.Term;

import java.util.HashSet;
import java.util.Set;

public class BloomFilterModel
{
    private Set<Term> uniqueTerms = new HashSet<>();

    protected void AddTerm(Term term)
    {
        uniqueTerms.add(term);
    }

    protected Term[] getTerms()
    {
        Term[] term = new Term[uniqueTerms.size()];
        int i=0;
        for(Term t:uniqueTerms)
        {
            term[i] = t;
            i++;
        }
        return term;
    }

    protected void AddAll(Term... terms)
    {
        for(Term t : terms)
            AddTerm(t);
    }

    protected int Size()
    {
        return uniqueTerms.size();
    }
}
