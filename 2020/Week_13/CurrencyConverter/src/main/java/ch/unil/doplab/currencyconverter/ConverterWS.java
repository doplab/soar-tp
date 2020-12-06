package ch.unil.doplab.currencyconverter;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@WebService(serviceName = "ConverterWS")
@Stateless()
public class ConverterWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "convert")
    public double convert(
            @WebParam(name = "sourceCurrency") String sourceCurrency, 
            @WebParam(name = "destinationCurrency") String destinationCurrency, 
            @WebParam(name = "amount") double amount) {
        return CurrencyList.getInstance().getCurrencyList().get(sourceCurrency).get(destinationCurrency) * amount;
    }

}
