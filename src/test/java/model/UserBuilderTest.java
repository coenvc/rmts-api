package model;

import org.junit.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class UserBuilderTest {

    @Rule
    public ExpectedException expected= ExpectedException.none();

    @Test
    public void All_Properties_Set_In_Right_Order(){
        User u1 = new UserBuilder()
                .username("hbollen")
                .password("12345test")
                .name("Henk Bollen")
                .active(true)
                .build();

        assertEquals(u1.getUsername(), "hbollen");
        assertEquals(u1.getName(), "Henk Bollen");
        assertEquals(u1.isActive(), true);
    }

    @Test
    public void All_Properties_Set_In_Random_Order(){
        User u2 = new UserBuilder()
                .name("Frits Band")
                .password("12345")
                .active(true)
                .username("fband")
                .build();
    }

    @Test
    public void PropertiesNullValueExceptionName(){

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No name provided");

        User u3 = new UserBuilder()
                .username("bvmierd")
                .password("test56")
                .name("")
                .active(true)
                .build();
    }

    @Test
    public void PropertiesNullValueExceptionUsername(){

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No username provided.");

        User u4 = new UserBuilder()
                .name("Bernd van Mierd")
                .username("")
                .password("test56")
                .active(true)
                .build();
    }

    @Test
    public void PropertiesNullValueExceptionPassword(){

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("No password provided.");

        User u5 = new UserBuilder()
                .name("Bernd van Mierd")
                .username("bvmierd")
                .password("")
                .active(true)
                .build();
    }


}