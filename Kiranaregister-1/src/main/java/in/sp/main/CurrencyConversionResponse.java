package in.sp.main;

import java.util.Map;

//CurrencyConversionResponse.java
public class CurrencyConversionResponse {
 
 private Map<String, Double> rates;
 
 public Map<String, Double> getRates() {
     return rates;
 }
 
 public void setRates(Map<String, Double> rates) {
     this.rates = rates;
 }
}