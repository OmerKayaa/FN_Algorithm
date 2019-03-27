package Algorithms;

import Model.Document;

public abstract class AlgorithmsAbs implements AlgorithmInterface
{
    private Document doc1,doc2;

    @Override
    public void setUp(Document doc1, Document doc2)
    {
        this.doc1 = doc1; this.doc2 = doc2;
    }
}
