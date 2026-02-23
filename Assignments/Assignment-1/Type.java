public enum Type {
    PREMIUM(15), REGULAR(7), BASIC(3);
    private final int type;

    private Type(int type) { 
        this.type = type;
    }
    
    public int getType() { 
        return type;
    }
}