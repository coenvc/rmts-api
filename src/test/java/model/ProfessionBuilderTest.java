package model;

import model.Profession;
import model.ProfessionBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfessionBuilderTest {

    @Test
    public void propertiesSetInRightOrder_buildsCorrectly() {

        Profession profession = new ProfessionBuilder()
                .name("CEO")
                .build();

        assertEquals(profession.getName(), "CEO");
    }

    @Test
    public void propertyIsNull_throwsException() throws IllegalArgumentException{
        Profession profession = new ProfessionBuilder()
                .build();
    }
}
