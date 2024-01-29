package pl.drybanski.court.user;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
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
    @PostConstruct
    private void saveUsers(){
        if(userRepository.count() == 0)
            userRepository.saveAll(createUsers());
    }
    public void addNewUser(UserDTO userDTO){
        User user = convertFromDTO(userDTO);
        userRepository.save(user);
    }
    public List<UserDTO> getAllUsers(){
        List<User> usersFromDB = userRepository.findAll();

        return usersFromDB.stream()
                .map(user -> new UserDTO(user.getName(), user.getSurname() ))
                .toList();
    }
    private User convertFromDTO(UserDTO userDTO){
        return new User(userDTO.getName(), userDTO.getSurname());
    }
}
