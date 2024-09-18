package in.sp.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//CurrencyConversionService.java
@Service
public class CurrencyConversionService {
 
 @Value("${fx.rates.api.url}")
 private String fxRatesApiUrl;
 
 @Cacheable("currencyConversionResponse")
 public CurrencyConversionResponse getLatestExchangeRate() {
     RestTemplate restTemplate = new RestTemplate();
     CurrencyConversionResponse response = restTemplate.getForObject(fxRatesApiUrl, CurrencyConversionResponse.class);
     return response;
 }
}