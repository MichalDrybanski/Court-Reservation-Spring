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
    private List<User> createUsers(){
        List<User> userList = new ArrayList<>(List.of(
                new User("Michal", "Ara"),
                new User("Adam", "Lol"),
                new User("Michal", "D"),
                new User("Andrzej", "K"),
                new User("Dominika", "W"),
                new User("Karolina", "Z"),
                new User("Pawel", "O"),
                new User("Pawel D", "R"),
                new User("Kamil K", "M"),
                new User("Kamil P", "p")
        ));
        return userList;
    }
    //todo: SaveUsers tworzyla obiekty przy pomocy wielokrotnego wywolywania addNewUser
    @PostConstruct
    private void saveUsers(){
        if(userRepository.count() == 0)
            userRepository.saveAll(createUsers());
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
