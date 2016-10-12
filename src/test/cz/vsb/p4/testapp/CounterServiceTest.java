package cz.vsb.p4.testapp;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by ruz76 on 12.10.2016.
 */
public class CounterServiceTest {

    private static final Integer INIT_VAL = 123;
    private static final Double INIT_D = 100.5;
    private CounterService counterService;

    @Before
    public void setup() {
        this.counterService = new CounterService(INIT_VAL, 100.5);
    }

    @Test
    public void shouldReturnInitValueOnFirstCall() {
        CounterValue value = counterService.getAndIncrement();
        Assert.assertEquals(INIT_VAL, value.getValue());
    }

    @Test
    public void shouldReturnInitPlusOneValueOnSecondCall() {
        Integer expectedValue = new Integer(INIT_VAL + 1);
        counterService.getAndIncrement();
        CounterValue value = counterService.getAndIncrement();
        Assert.assertEquals(expectedValue, value.getValue());
    }

    @Test
    public void shouldReturnInitDoubleValueOnFirstCall() {
        double value = counterService.getTestDouble(10);
        Assert.assertEquals(INIT_D + 10, value, 0.0);
    }

}