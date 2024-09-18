package in.sp.main;

//RateLimiter.java
@Component
public class RateLimiter {
 
 @Value("${txn.record.api.rate.limit}")
 private int txnRecordApiRateLimit;
 
 private final ConcurrentHashMap<String, AtomicInteger> requestCounts = new ConcurrentHashMap<>();
 
 public boolean isAllowed(String apiEndpoint) {
     AtomicInteger requestCount = requestCounts.computeIfAbsent(apiEndpoint, k -> new AtomicInteger(0));
     int currentCount = requestCount.incrementAndGet();
     if (currentCount > txnRecordApiRateLimit) {
         return false;
     }
     return true;
 }
}