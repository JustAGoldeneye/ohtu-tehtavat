package statistics.matcher;

public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new All();
    }
    
    public Matcher build() {
        Matcher copy = this.matcher;
        this.matcher = new All();
        return copy;   
    }
    
    public QueryBuilder playsIn(String team) {
        this.and(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.and(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.and(new HasFewerThan(value, category));
        return this;
    }
    
    private QueryBuilder and(Matcher matcher) {
        this.matcher = new And(this.matcher, matcher);
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher = new Or(m1, m2);
        return this;
    }
}
