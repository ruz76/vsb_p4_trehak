package cz.vsb.p4.testapp;

import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by trehak on 10.10.2016.
 */
@Service
public class CounterService {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final AtomicDouble testconstant = new AtomicDouble(0);

    public CounterService(@Value("${counter.init.value}") int initialValue, @Value("${counter.test.value}") double testc) {
        counter.set(initialValue);
        testconstant.set(testc);
    }

    public CounterValue getAndIncrement() {
        return new CounterValue(counter.getAndIncrement());
    }

    public double getTestDouble(double vstup) {
        return vstup + testconstant.get();
    }
}
