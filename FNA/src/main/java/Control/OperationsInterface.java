package Control;

import Algorithms.AlgorithmInterface;
import Model.Term;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public interface OperationsInterface
{
    static List<Term> IntersectDocuments(AlgorithmInterface algorithm)
    {
        return algorithm.IntersectDocuments();
    }

    static Duration IntersectDocumentsTime(AlgorithmInterface algorithm)
    {
        Instant start = Instant.now();
        algorithm.IntersectDocuments();
        Instant end = Instant.now();
        return Duration.between(start,end);
    }

    static List<Term> DisjunctDocuments(AlgorithmInterface algorithm)
    {
        return algorithm.DisjunctDocuments();
    }

    static Duration DisjointDocumentsTime(AlgorithmInterface algorithm)
    {
        Instant start = Instant.now();
        algorithm.DisjunctDocuments();
        Instant end = Instant.now();
        return Duration.between(start,end);
    }

    static List<Term> AddDocuments(AlgorithmInterface algorithm)
    {
        return algorithm.AddDocuments();
    }

    static Duration AddDocumentsTime(AlgorithmInterface algorithm)
    {
        Instant start = Instant.now();
        algorithm.AddDocuments();
        Instant end = Instant.now();
        return Duration.between(start,end);
    }

    static List<Term> SubtractDocuments(AlgorithmInterface algorithm)
    {
        return algorithm.SubtractDocuments();
    }

    static Duration SubtractDocumentsTime(AlgorithmInterface algorithm)
    {
        Instant start = Instant.now();
        algorithm.SubtractDocuments();
        Instant end = Instant.now();
        return Duration.between(start,end);
    }

    static boolean ContainsTerm(AlgorithmInterface algorithm,Term term)
    {
        return algorithm.Contains(term);
    }

    static Duration ContainsTermTime(AlgorithmInterface algorithm,Term term)
    {
        Instant start = Instant.now();
        algorithm.Contains(term);
        Instant end = Instant.now();
        return Duration.between(start,end);
    }
}
