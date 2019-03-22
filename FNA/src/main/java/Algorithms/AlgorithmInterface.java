package Algorithms;

import Model.Document;
import Model.Term;

public interface AlgorithmInterface
{
    void AddDocument(Document doc);

    Term[] IntersectDocuments   (Document... doc);
    Term[] DisjointDocuments    (Document... doc);
    Term[] AddDocuments         (Document... doc);
    Term[] SubtractDocuments    (Document... doc);

}
