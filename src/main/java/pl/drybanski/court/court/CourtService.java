package pl.drybanski.court.court;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourtService {
    private CourtRepository courtRepository;

    public CourtService(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    public List<Court> createCourt(){
        List<Court> courtList = new ArrayList<>(List.of(
                new Court("Orlik Czestochowa", true, CourtType.BASKETBALL),
                new Court("Orlik Rybnik", true, CourtType.VOLLEYBALL),
                new Court("Orlik Wroclaw", true, CourtType.FOOTBALL),
                new Court("Orlik Gdynia", true, CourtType.HANDBALL),
                new Court("Orlik Gliwice", true, CourtType.BASKETBALL),
                new Court("Orlik Sopot", true, CourtType.FOOTBALL)
        ));
        return courtList;
    }
    private void saveCourts(){
        if(courtRepository.count() == 0){
            courtRepository.saveAll(createCourt());
        }
    }
    private Court convertToDTO(CourtDTO courtDTO){
        return new Court(courtDTO.getName(), courtDTO.isAvailable(), courtDTO.getCourtType());
    }
    public List<CourtDTO> getAllCourts(CourtDTO courtDTO){
        List<Court> courtsFromDB = courtRepository.findAll();

        return courtsFromDB.stream()
                .map(court -> new CourtDTO(court.getName(), court.getCourtType(),  court.isAvailable()))
                .toList();
    }
}
