package in.sp.main;

//UserRepository.java
@Repository
public interface UserRepository extends MongoRepository<User, String> {
 
}