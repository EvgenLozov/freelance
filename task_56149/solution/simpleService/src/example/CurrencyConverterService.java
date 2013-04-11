package example;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CurrencyConverterService {
    enum Currency{USD, GBR, EUR}

   @WebMethod
    public Double convert(String pairCurrency)
    {
        String[] pair = pairCurrency.split("/");
        Currency formCurrency = Currency.valueOf(pair[0].toUpperCase());
        Currency toCurrency = Currency.valueOf(pair[1].toUpperCase());

        switch (formCurrency){
            case USD:
                switch (toCurrency){
                    case EUR: return 2.0;
                    case GBR: return 3.0;
                }
                break;
            case EUR:
                switch (toCurrency){
                    case USD: return 1.0;
                    case GBR: return 2.0;
                }
                break;
            case GBR:
                switch (toCurrency){
                    case USD: return 2.5;
                    case EUR: return 1.2;
                }
                break;
        }
        return 0.0;
    }


}
