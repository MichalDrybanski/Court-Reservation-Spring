package pl.drybanski.court;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourtReservationSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourtReservationSpringApplication.class, args);
	}

}
//aplikacja posiada:

//Kazdy moze utwozyc uzytkownika - wraz z nim tworzy się jego awatar - gracz
//Kazdy gracz moze utwozyc grupe -> zostanie organizatorem
//Kazdy organizator moze zaprosic do swojej grupy graczy
//Kazdy organizator moze zorganizowac glosowanie w ramach grupy
//Kazdy gracz w grupie moze oddać głos w głosowaniu
//Organizator moze zamknąć(rozstrzygnąć) głosowanie
//Organizator moze dopisać płatności do głosujących


//Uzytkownicy(User)
//Gracz(Player)
//Grupa(Group)
//Glosowanie(Voting)
//Glos(Vote)
//Platnosc(Payment)