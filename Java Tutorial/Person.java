public abstract class Person { //Abstract methods are defined in their subclsses
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public abstract String getDescription();
    public String getName() {
        return name;
    }
}