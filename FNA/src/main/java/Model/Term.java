package Model;

public class Term<T>
{
    private final T term;

    public Term(T term)
    {
        this.term = term;
    }

    public T getTerm()
    {
        return term;
    }
}
