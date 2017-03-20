package model;

public class ProfessionBuilder {

    private String name;

    public ProfessionBuilder name(String name){
        if(name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        return this;
    }

    public Profession build(){
        return new Profession(name);
    }
}
