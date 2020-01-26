package VamshiSpring.BoookingDemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Marriott" , 20000, 3));
        bookings.add(new HotelBooking( "Hyatt", 25000, 5 ));

        bookingRepository.saveAll(bookings);


    }
}
