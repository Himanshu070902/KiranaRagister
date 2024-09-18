package in.sp.main;

//UserService.java
@Service
public class UserService {
 
 @Autowired
 private UserRepository userRepository;
 
 public User authenticateUser(String username, String password) {
     // Authenticate user
     User user = userRepository.findByUsernameAndPassword(username, password);
     return user;
 }
 
 public User registerUser(User user) {
     // Register user
     return userRepository.save(user);
 }
}