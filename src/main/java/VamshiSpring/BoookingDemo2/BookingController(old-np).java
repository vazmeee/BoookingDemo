
//Rename the file to BookingController to use regular list type non persistent storage
package VamshiSpring.BoookingDemo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/bookings")
//TODO remove the old from class to use the list non persistent way
public class BookingControllerold {
    private List<HotelBooking> bookings;

    public BookingController(){
        bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Marriott" , 20000, 3));
        bookings.add(new HotelBooking( "Hyatt", 25000, 5 ));
        bookings.add(new HotelBooking( "Ibis", 4000, 5 ));
    }

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<HotelBooking> getAll(){
        return bookings;
    }

    @RequestMapping(value="/affordable/{price}", method=RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){
        return bookings.stream().filter(x->x.getPricePerNight() <= price)
                .collect(Collectors.toList());

    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookings.add(hotelBooking);

        return bookings;
    }


}
