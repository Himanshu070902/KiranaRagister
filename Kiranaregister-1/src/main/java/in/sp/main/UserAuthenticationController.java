package in.sp.main;

//UserAuthenticationController.java
@RestController
@RequestMapping("/api/auth")
public class UserAuthenticationController {
 
 @Autowired
 private UserService userService;
 
 @PostMapping("/login")
 public ResponseEntity<User> login(@RequestBody User user) {
     User authenticatedUser = userService.authenticateUser(user.getUsername(), user.getPassword());
     return ResponseEntity.ok(authenticatedUser);
 }
 
 @PostMapping("/register")
 public ResponseEntity<User> register(@RequestBody User user) {
     User registeredUser = userService.registerUser(user);
     return ResponseEntity.ok(registeredUser);
 }
}