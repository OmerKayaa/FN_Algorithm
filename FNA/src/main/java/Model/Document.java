package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Document implements Iterable<Term>
{
    private List<Term> Terms = new ArrayList<>();
    private final String Name;

    public Document(String name)
    {
        Name = name;
    }

    public Document()
    {
        Name = "";
    }

    public void AddTerm(Term term)
    {
        Terms.add(term);
    }

    public void AddAll(Term... terms)
    {
        for (Term t: terms)
        {
            AddTerm(t);
        }
    }

    public boolean Exist(Term t)
    {
        return Terms.contains(t);
    }

    public void SubTerm(Term term)
    {
        Terms.remove(term);
    }

    @Override
    public Iterator iterator()
    {
        return Terms.iterator();
    }
}
