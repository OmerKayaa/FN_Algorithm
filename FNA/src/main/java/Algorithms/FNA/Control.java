package Algorithms.FNA;

import java.math.BigInteger;

public class Control
{

    public static BigInteger returnKey(Model.Term term)
    {
        for (BigInteger i:FNAModel.TermDictionary.keySet())
        {
            if(FNAModel.TermDictionary.get(i).equals(term))
                return i;
        }
        if(FNAModel.TermDictionary.size()<FNAModel.primes.size())
        {
            FNAModel.TermDictionary.put(BigInteger.valueOf(FNAModel.primes.get(FNAModel.TermDictionary.size())),term);
            return BigInteger.valueOf(FNAModel.primes.get(FNAModel.TermDictionary.size()-1));
        }
        nextPrimeNumber();
        FNAModel.TermDictionary.put(LastPrimeNumber(),term);
        return LastPrimeNumber();
    }

    public static BigInteger returnKey(Model.Document document)
    {
        for (BigInteger i:FNAModel.DocumentDictionary.keySet())
        {
            if(FNAModel.DocumentDictionary.get(i).contains(document))
                return i;
        }
        return calculateKey(document);
    }

    private static BigInteger calculateKey(Model.Document document)
    {
        BigInteger key = BigInteger.ONE;
        for (Model.Term t: document)
        {
            key= key.multiply(returnKey(t));
        }
        return key;
    }

    private static void nextPrimeNumber()
    {
        int prime = FNAModel.primes.get(FNAModel.primes.size()-1);

        do { prime +=2; }
        while(!isPrime(prime));

        FNAModel.primes.add(prime);
    }

    private static BigInteger LastPrimeNumber()
    {
        return BigInteger.valueOf(FNAModel.primes.get(FNAModel.primes.size()-1));
    }

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
