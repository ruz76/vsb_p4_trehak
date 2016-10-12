package cz.vsb.p4.testapp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by ruz76 on 12.10.2016.
 */
public class RESTResourceTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getAndIncrementCounterValue() throws Exception {
        CounterService cs = mock(CounterService.class);

        RESTResource resource =  new RESTResource(cs);
        resource.getAndIncrementCounterValue();
        resource.getAndIncrementCounterValue();
        resource.getAndIncrementCounterValue();

        CounterValue andIncrement = Mockito.verify(cs, Mockito.times(2)).getAndIncrement();

        Mockito.verifyNoMoreInteractions(cs);

    }

    @Test
    public void echo() throws Exception {

    }

    @Test
    public void echoint() throws Exception {

    }

}