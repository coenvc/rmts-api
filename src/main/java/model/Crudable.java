package model;

import java.util.List;

public interface Crudable {
    boolean isIncomplete();
    List<String> getIncompleteProperties();
}
