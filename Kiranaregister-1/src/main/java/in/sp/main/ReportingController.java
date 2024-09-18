package in.sp.main;

//ReportingController.java
@RestController
@RequestMapping("/api/reports")
public class ReportingController {
 
 @Autowired
 private ReportingService reportingService;
 
 @GetMapping("/weekly")
 public ResponseEntity<WeeklyReport> getWeeklyReport() {
     WeeklyReport report = reportingService.getWeeklyReport();
     return ResponseEntity.ok(report);
 }
 
 @GetMapping("/monthly")
 public ResponseEntity<MonthlyReport> getMonthlyReport() {
     MonthlyReport report = reportingService.getMonthlyReport();
     return ResponseEntity.ok(report);
 }
 
 @GetMapping("/yearly")
 public ResponseEntity<YearlyReport> getYearlyReport() {
     YearlyReport report = reportingService.getYearlyReport();
     return ResponseEntity.ok(report);
 }
}