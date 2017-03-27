package model;

import com.sun.javaws.exceptions.InvalidArgumentException;
import model.Profession;
import model.ProfessionBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfessionBuilderTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void propertiesSetInRightOrder_buildsCorrectly() {

        Profession profession = new ProfessionBuilder()
                .name("CEO")
                .build();

        assertEquals(profession.getName(), "CEO");
    }

    @Test
    public void nameIsNull_throwsException() {

        expected.expect(InvalidArgumentException.class);
        expected.expectMessage("No name specified.");

        Profession profession = new ProfessionBuilder()
                .build();
    }
}
