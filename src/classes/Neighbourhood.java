package src.classes;

class Neighbourhood {
    public String group;
    public String street;
    
    public Neighbourhood(String group, String street) {
        this.group = group;
        this.street = street;
    }

    @Override
    public String toString() {
        return group + "," + street;
    }
}
