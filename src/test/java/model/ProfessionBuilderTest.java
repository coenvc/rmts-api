package model;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


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

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No name provided.");
        Profession profession = new ProfessionBuilder()
                .build();
    }
}
