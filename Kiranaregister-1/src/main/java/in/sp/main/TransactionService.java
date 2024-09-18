package in.sp.main;
//TransactionService.java
@Service
public class TransactionService {
 
 @Autowired
 private TransactionRepository transactionRepository;
 
 @Autowired
 private CurrencyConversionService currencyConversionService;
 
 public Transaction createTransaction(Transaction transaction) {
     // Convert currency using the reference API
     transaction.setAmount(convertCurrency(transaction.getAmount(), transaction.getCurrency()));
     return transactionRepository.save(transaction);
 }
 
 public List<Transaction> getTransactions() {
     return transactionRepository.findAll();
 }
 
 private double convertCurrency(double amount, String currency) {
     // Call the reference API to get the latest exchange rate
     CurrencyConversionResponse response = currencyConversionService.getLatestExchangeRate();
     double exchangeRate = response.getRates().get(currency);
     return amount * exchangeRate;
 }
}