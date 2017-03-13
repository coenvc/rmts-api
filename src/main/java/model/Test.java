package model;

import javax.persistence.*;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;

    @Column
    private String _test;

    public Test(String _test) {
        this._test = _test;
    }

    public Test() {
    }

    //region Getters & Setters

    public int get_id() {
        return _id;
    }

    public String get_test() {
        return _test;
    }

    public void set_test(String _test) {
        this._test = _test;
    }

    //endregion
}
