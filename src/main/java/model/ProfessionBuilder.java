package model;

public class ProfessionBuilder {

    private String name = "";

    public ProfessionBuilder name(String name){
        this.name = name;
        return this;
    }

    public Profession build(){
        checkProperties();
        return new Profession(name);
    }

    private void checkProperties() {
        if (name.equals("")) throw new IllegalArgumentException("No name provided.");
    }
}
