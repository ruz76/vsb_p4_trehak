package cz.vsb.p4.testapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by trehak on 10.10.2016.
 */
@Path("/test")
@Produces("application/json")
public class RESTResource {
    /*
    Takto to nefunguje nutne pres CounterService
    @Value("${counter.test.value}")
    private double testdouble;
    */

    private final CounterService counterService;

    @Autowired
    public RESTResource(CounterService counterService) {
        this.counterService = counterService;
    }

    @GET
    public CounterValue getAndIncrementCounterValue() {
        return counterService.getAndIncrement();
    }

    @GET
    @Path("/echo/{text}")
    public String echo(@PathParam("text") String text) {
        return text;
    }

    @GET
    @Path("/echoint/{cislo}")
    public double echoint(@PathParam("cislo") double cislo) {
        return counterService.getTestDouble(cislo);
    }
}
