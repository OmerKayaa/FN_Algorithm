package Algorithms.SortedList;

import Algorithms.AlgorithmsAbs;
import Model.Document;
import Model.Term;

import java.util.*;

public class SortedList extends AlgorithmsAbs
{
    LinkedList<Term> sorteddoc1 = new LinkedList<>();
    LinkedList<Term> sorteddoc2 = new LinkedList<>();

    public SortedList(Document doc1,Document doc2)
    {
        super.setUp(doc1,doc2);
        for(Term t : doc1)
        {
            sorteddoc1.add(t);
        }
        for(Term t : doc2)
        {
            sorteddoc2.add(t);
        }
        sorteddoc1.sort(SortedList::compare);
        sorteddoc2.sort(SortedList::compare);
    }

    @Override
    public List<Term> IntersectDocuments()
    {
        List<Term> list = new ArrayList<>();
        Iterator<Term> it1 = sorteddoc1.listIterator();
        Iterator<Term> it2 = sorteddoc2.listIterator();
        Term t1 = it1.next(),t2 = it2.next();
        while(it1.hasNext() && it2.hasNext())
        {
            int i = compare(t1,t2);
            if (i < 0)
            {
                t1 = it1.next();
            }
            else if (i == 0)
            {
                list.add(t1);
                t1 = it1.next();
                t2 = it2.next();
            }
            else
            {
                t2 = it2.next();
            }
        }
        return list;
    }

    @Override
    public List<Term> DisjunctDocuments()
    {
        List<Term> list = new ArrayList<>();
        Iterator<Term> it1 = sorteddoc1.listIterator();
        Iterator<Term> it2 = sorteddoc2.listIterator();
        Term t1 = it1.next(),t2 = it2.next();
        while(it1.hasNext() && it2.hasNext())
        {
            int i = compare(t1,t2);
            if (i < 0)
            {
                list.add(t1);
                t1 = it1.next();
            }
            else if (i == 0)
            {
                t1 = it1.next();
                t2 = it2.next();
            }
            else
            {
                list.add(t2);
                t2 = it2.next();
            }
        }
        int i = compare(t1,t2);

        if (i > 0)
        {
            list.add(t1);
            list.add(t2);
        }
        if (i < 0)
        {
            list.add(t2);
            list.add(t1);
        }

        if(it1.hasNext())
        {
            it1.forEachRemaining(list::add);
        }
        if(it2.hasNext())
        {
            it2.forEachRemaining(list::add);
        }

        return list;
    }

    @Override
    public List<Term> AddDocuments()
    {
        List<Term> list = new ArrayList<>();
        Iterator<Term> it1 = sorteddoc1.listIterator();
        Iterator<Term> it2 = sorteddoc2.listIterator();
        Term t1 = it1.next(),t2 = it2.next();
        while(it1.hasNext() && it2.hasNext())
        {
            int i = compare(t1,t2);
            if (i < 0)
            {
                list.add(t1);
                t1 = it1.next();
            }
            else if (i == 0)
            {
                list.add(t1);
                t1 = it1.next();
                t2 = it2.next();
            }
            else
            {
                list.add(t2);
                t2 = it2.next();
            }
        }
        int i = compare(t1,t2);
        if (i < 0)
        {
            list.add(t1);
            list.add(t2);
        }
        else if (i == 0)
        {
            list.add(t1);
        }
        else
        {
            list.add(t2);
            list.add(t1);
        }
        if(it1.hasNext())
        {
            it1.forEachRemaining(list::add);
        }
        if(it2.hasNext())
        {
            it2.forEachRemaining(list::add);
        }

        return list;
    }

    @Override
    public List<Term> SubtractDocuments()
    {
        List<Term> list = new ArrayList<>();
        Iterator<Term> it1 = sorteddoc1.listIterator();
        Iterator<Term> it2 = sorteddoc2.listIterator();
        Term t1 = it1.next(),t2 = it2.next();
        while(it1.hasNext() && it2.hasNext())
        {
            int i = compare(t1,t2);
            if (i < 0)
            {
                list.add(t1);
                t1 = it1.next();
            }
            else if (i == 0)
            {
                t1 = it1.next();
                t2 = it2.next();
            }
            else
            {
                t2 = it2.next();
            }
        }
        int i = compare(t1,t2);
        if (i < 0)
        {
            list.add(t1);
        }
        it1.forEachRemaining(list::add);
        return list;
    }

    @Override
    public boolean Contains(Term t)
    {
        return sorteddoc1.contains(t);
    }

    private static int compare(String s1,String s2)
    {
        return s1.compareTo(s2);
    }

    private static int compare(Integer i1,Integer i2)
    {
        return i1.compareTo(i2);
    }

    private static int compare(Term t1,Term t2)
    {
        if(t1.getTerm().getClass().equals(String.class)&&t2.getTerm().getClass().equals(String.class))
            return compare(((String)(t1.getTerm())),(((String)(t2.getTerm()))));
        else if (t1.getTerm().getClass().equals(Integer.class)&&t2.getTerm().getClass().equals(Integer.class))
            return compare(((Integer)(t1.getTerm())),(((Integer)(t2.getTerm()))));
        else return 0;
    }
}
