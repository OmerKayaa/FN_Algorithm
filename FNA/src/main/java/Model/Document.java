package Model;

import java.util.ArrayList;
import java.util.List;

public class Document
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

    public void SubTerm(Term term)
    {
        Terms.remove(term);
    }
}
