package testService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.HashMap;
import java.nio.file.*;

@WebService
public class TestService {
        private HashMap map = new HashMap();

    @WebMethod
        public double getPrice(String symbol) {
            Double price = (Double) map.get(symbol);
            if(price != null){
                return price.doubleValue();
            }
            return 42.00;
        }
     @WebMethod
        public void update(String symbol, double price) {
            map.put(symbol, new Double(price));
        }
}
