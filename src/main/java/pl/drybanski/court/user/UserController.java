package pl.drybanski.court.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public void addNewUser(@RequestBody UserDTO userDTO){
        userService.addNewUser(userDTO);
    }
    @GetMapping //todo ustawić tylko dla admina
    public List<UserDTO> getAllUsers(){
       return userService.getAllUsers();
    }
}


// GET: localhost8080/api/v1/users
// POST: localhost8080/api/v1/users
// PUT: localhost8080/api/v1/users/id
// DELETE: localhost8080/api/v1/users/id