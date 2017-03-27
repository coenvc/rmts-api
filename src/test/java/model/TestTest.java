package model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestTest {
    @Test
    public void get_test() throws Exception {
        model.Test test = new model.Test("Henk");
        assertEquals("Henk", test.get_test());
    }

    @Test
    public void set_test() throws Exception {
        model.Test test = new model.Test("Henk");
        test.set_test("Freek");
        assertEquals("Freek", test.get_test());
    }
}