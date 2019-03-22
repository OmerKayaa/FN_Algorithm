package Control;

import Algorithms.AlgorithmInterface;
import Model.Document;
import Model.Term;

import java.time.Duration;
import java.time.Instant;

public interface OperationsInterface
{
    static Term[] IntersectDocuments(AlgorithmInterface algorithm,Document... doc)
    {
        return algorithm.IntersectDocuments(doc);
    }

    static Duration IntersectDocumentsTime(AlgorithmInterface algorithm, Document... doc)
    {
        Instant start = Instant.now();
        algorithm.IntersectDocuments(doc);
        Instant end = Instant.now();
        return Duration.between(start,end);
    }

    static Term[] DisjointDocuments(AlgorithmInterface algorithm,Document... doc)
    {
        return algorithm.DisjointDocuments(doc);
    }

    static Duration DisjointDocumentsTime(AlgorithmInterface algorithm,Document... doc)
    {
        Instant start = Instant.now();
        algorithm.DisjointDocuments(doc);
        Instant end = Instant.now();
        return Duration.between(start,end);
    }

    static Term[] AddDocuments(AlgorithmInterface algorithm,Document... doc)
    {
        return algorithm.AddDocuments(doc);
    }

    static Duration AddDocumentsTime(AlgorithmInterface algorithm ,Document... doc)
    {
        Instant start = Instant.now();
        algorithm.AddDocuments(doc);
        Instant end = Instant.now();
        return Duration.between(start,end);
    }

    static Term[] SubtractDocuments(AlgorithmInterface algorithm, Document... doc)
    {
        return algorithm.SubtractDocuments();
    }

    static Duration SubtractDocumentsTime(AlgorithmInterface algorithm , Document... doc)
    {
        Instant start = Instant.now();
        algorithm.SubtractDocuments(doc);
        Instant end = Instant.now();
        return Duration.between(start,end);
    }
}
