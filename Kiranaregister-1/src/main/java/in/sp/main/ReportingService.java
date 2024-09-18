package in.sp.main;

//ReportingService.java
@Service
public class ReportingService {
 
 @Autowired
 private TransactionRepository transactionRepository;
 
 public WeeklyReport getWeeklyReport() {
     // Generate weekly report
     List<Transaction> transactions = transactionRepository.findByDateBetween(LocalDate.now().minusWeeks(1), LocalDate.now());
     WeeklyReport report = new WeeklyReport();
     report.setTotalCredits(getTotalCredits(transactions));
     report.setTotalDebits(getTotalDebits(transactions));
     report.setNetFlow(getNetFlow(transactions));
     return report;
 }
 
 public MonthlyReport getMonthlyReport() {
     // Generate monthly report
     List<Transaction> transactions = transactionRepository.findByDateBetween(LocalDate.now().minusMonths(1), LocalDate.now());
     MonthlyReport report = new MonthlyReport();
     report.setTotalCredits(getTotalCredits(transactions));
     report.setTotalDebits(getTotalDebits(transactions));
     report.setNetFlow(getNetFlow(transactions));
     return report;
 }
 
 public YearlyReport getYearlyReport() {
     // Generate yearly report
     List<Transaction> transactions = transactionRepository.findByDateBetween(LocalDate.now().minusYears(1), LocalDate.now());
     YearlyReport report = new YearlyReport();
     report.setTotalCredits(getTotalCredits(transactions));
     report.setTotalDebits(getTotalDebits(transactions));
     report.setNetFlow(getNetFlow(transactions));
     return report;
 }
 
 private double getTotalCredits(List<Transaction> transactions) {
     return transactions.stream().filter(t -> t.getType().equals("credit")).mapToDouble(Transaction::getAmount).sum();
 }
 
 private double getTotalDebits(List<Transaction> transactions) {
     return transactions.stream().filter(t -> t.getType().equals("debit")).mapToDouble(Transaction::getAmount).sum();
 }
 
 private double getNetFlow(List<Transaction> transactions) {
     return getTotalCredits(transactions) - getTotalDebits(transactions);
 }
}