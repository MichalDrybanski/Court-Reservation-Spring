package pl.drybanski.court.player;

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
}
