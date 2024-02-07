package pl.drybanski.court.player;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(PlayerDTO playerDTO){
        Player player = new Player(playerDTO.getName());
        playerRepository.save(player);
        return player;
    }

    public List<PlayerDTO> getPlayers(){
        List<Player> playersDB = playerRepository.findAll();

        return playersDB.stream()
                .map(player -> new PlayerDTO(player.getName()))
                .toList();
    }
    public void createGroup(){

    }
}
