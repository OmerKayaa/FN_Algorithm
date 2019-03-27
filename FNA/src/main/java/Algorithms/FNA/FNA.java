package Algorithms.FNA;

import Algorithms.AlgorithmsAbs;
import Model.Document;
import Model.Term;

import java.math.BigInteger;
import java.util.List;

public class FNA extends AlgorithmsAbs
{
    private final FNAModel model = new FNAModel();
    private final BigInteger k1,k2;

    public FNA(Document doc1,Document doc2)
    {
        super.setUp(doc1,doc2);
        k1 = Control.returnKey(doc1,model);
        k2 = Control.returnKey(doc2,model);
    }

    @Override
    public List<Term> IntersectDocuments()
    {
        return Control.getTerms(Control.EuclideanGCD(k1,k2),model.TermDictionary);
    }

    @Override
    public List<Term> DisjunctDocuments()
    {
        return Control.getTerms(Control.DisJoint(k1,k2),model.TermDictionary);
    }

    @Override
    public List<Term> AddDocuments()
    {
        return Control.getTerms(k1.multiply(k2),model.TermDictionary);
    }

    @Override
    public List<Term> SubtractDocuments()
    {
        return Control.getTerms(k1.divideAndRemainder(k2)[1],model.TermDictionary);
    }
}
