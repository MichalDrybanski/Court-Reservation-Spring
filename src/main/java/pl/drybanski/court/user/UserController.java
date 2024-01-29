package pl.drybanski.court.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/addNewUser")
    public void addNewUser(@RequestBody UserDTO userDTO){
        userService.addNewUser(userDTO);
    }
    @GetMapping("/addNewUser")
    public void getAllUsers(@RequestBody UserDTO userDTO){
        userService.getAllUsers(userDTO);
    }
}
