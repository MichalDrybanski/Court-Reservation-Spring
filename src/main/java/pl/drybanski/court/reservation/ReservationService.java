package pl.drybanski.court.reservation;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public void createReservation(ReservationDTO reservationDTO){
        Reservation reservation = new Reservation(reservationDTO.getLocalDateTime(), reservationDTO.getUser());
    }
    public List<ReservationDTO> getAllReservation(){
        List<Reservation> reservationsFromDB = reservationRepository.findAll();
        return reservationsFromDB.stream()
                .map(reservation -> new ReservationDTO(reservation.getLocalDateTime(), reservation.getUser()))
                .toList();
    }
    private ReservationDTO convertToDTO(Reservation reservation){
        return new ReservationDTO(reservation.getLocalDateTime(), reservation.getUser());
    }
    private Reservation convertToEntity(ReservationDTO reservationDTO){
        return new Reservation(reservationDTO.getLocalDateTime(), reservationDTO.getUser());
    }
    public void deleteReservation(ReservationDTO reservationDTO){
        Reservation reservation = convertToEntity(reservationDTO);

        Optional<Reservation> existingReservation = reservationRepository.findById(reservation.getId());

        if(existingReservation.isPresent()){
            reservationRepository.deleteById(reservation.getId());
        }
    }
    public void deleteReservationById(Long reservationId){
        reservationRepository.deleteById(reservationId);
    }
}
