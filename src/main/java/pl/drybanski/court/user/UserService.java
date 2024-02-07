package pl.drybanski.court.user;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pl.drybanski.court.player.Player;
import pl.drybanski.court.player.PlayerDTO;
import pl.drybanski.court.player.PlayerService;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    private PlayerService playerService;
    private UserRepository userRepository;

    public UserService(PlayerService playerService, UserRepository userRepository) {
        this.playerService = playerService;
        this.userRepository = userRepository;
    }
    private List<UserDTO> createUsers() {
        List<UserDTO> userList = new ArrayList<>(List.of(
                new UserDTO("john.doe@example.com", "p@ssw0rd!", "John Doe"),
                new UserDTO("jane.smith@example.com", "securePW123", "Jane Smith"),
                new UserDTO("alex.wong@example.com", "aWong9876", "Alex Wong"),
                new UserDTO("emily.jones@example.com", "EJones2022", "Emily Jones"),
                new UserDTO("michael.brown@example.com", "brownie123", "Michael Brown"),
                new UserDTO("sarah.miller@example.com", "SMiller!456", "Sarah Miller"),
                new UserDTO("david.wilson@example.com", "wilsonD@789", "David Wilson"),
                new UserDTO("olivia.taylor@example.com", "olive@123", "Olivia Taylor"),
                new UserDTO("ryan.clark@example.com", "rClark2023!", "Ryan Clark"),
                new UserDTO("natalie.white@example.com", "NWhite876", "Natalie White")
        ));
        return userList;
    }
    //todo: SaveUsers tworzyla obiekty przy pomocy wielokrotnego wywolywania addNewUser
    @PostConstruct
    private void saveUsers(){
        if(userRepository.count() == 0){
            List<UserDTO> userList = createUsers();
            userList.forEach(userDTO -> addNewUser(userDTO));
        }
    }
    public void addNewUser(UserDTO userDTO){
        User user = convertFromDTO(userDTO);
        Player player = playerService.createPlayer(new PlayerDTO(userDTO.getName()));
        user.setPlayer(player);
        userRepository.save(user);
    }
    public List<UserDTO> getAllUsers(){
        List<User> usersFromDB = userRepository.findAll();

        return usersFromDB.stream()
                .map(user -> new UserDTO(user.getEmail(), user.getPassword(), user.getPlayer().getName()))
                .toList();
    }
    private User convertFromDTO(UserDTO userDTO){
        return new User(userDTO.getEmail(), userDTO.getPassword());
    }
}
