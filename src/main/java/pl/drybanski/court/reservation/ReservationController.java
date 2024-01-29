package pl.drybanski.court.reservation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping("/create")
    public void createReservation(@RequestBody ReservationDTO reservationDTO){
        reservationService.createReservation(reservationDTO);
    }
    @GetMapping("/all")
    public void getAllReservation(@RequestBody ReservationDTO reservationDTO){
        reservationService.getAllReservation();
    }
    @DeleteMapping("/delete/{reservationId}")
    public void deleteReservation(@PathVariable Long reservationId){
        reservationService.deleteReservationById(reservationId);
    }
}
