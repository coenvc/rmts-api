package model;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserBuilderTest {

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

    @Test (expected = NullPointerException.class)
    public void Properties_Null_Value_Exception(){
        User u3 = new UserBuilder()
                .username("bvmierd")
                .password("test56")

                .active(true)
                .build();
    }
}