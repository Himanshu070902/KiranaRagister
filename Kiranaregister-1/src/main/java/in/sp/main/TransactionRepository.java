package in.sp.main;

//TransactionRepository.java
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
 
}