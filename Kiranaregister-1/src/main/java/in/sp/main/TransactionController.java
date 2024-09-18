package in.sp.main;

//TransactionController.java
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
 
 @Autowired
 private TransactionService transactionService;
 
 @PostMapping
 public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
     Transaction createdTransaction = transactionService.createTransaction(transaction);
     return ResponseEntity.ok(createdTransaction);
 }
 
 @GetMapping
 public ResponseEntity<List<Transaction>> getTransactions() {
     List<Transaction> transactions = transactionService.getTransactions();
     return ResponseEntity.ok(transactions);
 }
}