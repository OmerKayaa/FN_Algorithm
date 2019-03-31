package Algorithms.FNA;

import Model.Term;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Control
{

    static BigInteger disjunct(BigInteger a, BigInteger b)
    {
        BigInteger gcd = a.gcd(b);
        a = a.divide(gcd);
        b = b.divide(gcd);
        return a.multiply(b);
    }

    static BigInteger add(BigInteger a,BigInteger b)
    {
        return a.multiply(b).divide(a.gcd(b));
    }

    static BigInteger sub(BigInteger a,BigInteger b)
    {
        return a.divide((a.gcd(b)));
    }

    /**
     * Finds key of the term if exist if not generate new one
     * @param term  Term searching for
     * @param TermDictionary    Terms and keys map
     * @return  key of the term
     */
    static BigInteger returnKey(Model.Term term,Map<BigInteger, Term> TermDictionary)
    {
        for (BigInteger i:TermDictionary.keySet())
        {
            if(TermDictionary.get(i).equals(term))
                return i;
        }
        if(TermDictionary.size()<FNAModel.primes.size())
        {
            TermDictionary.put(BigInteger.valueOf(FNAModel.primes.get(TermDictionary.size())),term);
            return BigInteger.valueOf(FNAModel.primes.get(TermDictionary.size()-1));
        }
        nextPrimeNumber();
        TermDictionary.put(LastPrimeNumber(),term);
        return LastPrimeNumber();
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     * At that case use {@code calculateKey} method to generate a
     * key for document.
     * @param document  Document to be search for
     * @param model Document key maps
     * @return key of the document or {@code null} if not exist
     */
    static BigInteger returnKey(Model.Document document, FNAModel model)
    {
        for (BigInteger i:model.DocumentDictionary.keySet())
        {
            if(model.DocumentDictionary.get(i).contains(document))
                return i;
        }
        return calculateKey(document,model.TermDictionary);
    }

    static List<Term> getTerms(BigInteger key, Map<BigInteger, Term> TermDictionary)
    {
        if(key.equals(BigInteger.ZERO))
            return new ArrayList<>();
        List<Term> result = new LinkedList<>();
        for (BigInteger keys: TermDictionary.keySet())
        {
            if(key.remainder(keys).equals(BigInteger.ZERO))
            {
                result.add(TermDictionary.get(keys));
            }
        }
        return result;
    }

    /**
     * Used for calculaing key if {@code returnKey} method doesnt
     * find a key in document key dictionary
     * @param document  document to be key generated for.
     * @param TermDictionary    term dictionary
     * @return  key
     */
    private static BigInteger calculateKey(Model.Document document,Map<BigInteger, Term> TermDictionary)
    {
        BigInteger key = BigInteger.ONE;
        for (Model.Term t: document)
        {
            key= key.multiply(returnKey(t,TermDictionary));
        }
        return key;
    }

    /**
     * Finds next prime number and adds it to static prime number list
     * {@code FNAModel.primes}
     */
    private static void nextPrimeNumber()
    {
        int prime = FNAModel.primes.get(FNAModel.primes.size()-1);

        do { prime +=2; }
        while(!isPrime(prime));

        FNAModel.primes.add(prime);
    }

    /**
     * @return last prime number of {@code FNAModel.primes}
     */
    private static BigInteger LastPrimeNumber()
    {
        return BigInteger.valueOf(FNAModel.primes.get(FNAModel.primes.size()-1));
    }

    /**
     * Approve next prime number to be added to list {@code FNAModel.primes}
     * cant be use for any number only find next prime number.
     * @param i number checked whether prime or not
     * @return true if prime
     */
    private static boolean isPrime(int i)
    {
        for (int j: FNAModel.primes)
        {
            if (i % j == 0)
                return false;
        }
        return true;
    }
}
