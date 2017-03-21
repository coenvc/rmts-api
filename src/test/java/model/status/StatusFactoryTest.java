package model.status;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatusFactoryTest {

    @Test
    public void Given_ACTIVE() {
        Status status = new StatusFactory().build(StatusCode.ACTIVE);
        assertEquals("active", status.getContent());
    }

    @Test
    public void Given_NON_ACTIVE() {
        Status status = new StatusFactory().build(StatusCode.NON_ACTIVE);
        assertEquals("non-active", status.getContent());
    }

    @Test
    public void Given_ENDED() {
        Status status = new StatusFactory().build(StatusCode.ENDED);
        assertEquals("ended", status.getContent());
    }

    @Test
    public void Given_DENIED() {
        Status status = new StatusFactory().build(StatusCode.DENIED);
        assertEquals("denied", status.getContent());
    }
}