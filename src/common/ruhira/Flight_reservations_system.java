package common.ruhira;
import java.awt.desktop.ScreenSleepEvent;
import java.text.BreakIterator;
import java.util.Random;
import java.util.Scanner;

abstract class Passanger1{
    int id;
    String name;
    String contactNo;
    String mailId;
    String city;
    String state;


    public Passanger1(){
        System.out.println("Register Here For Booking a Ticket");
    }
    abstract public int id();
    abstract public String name();
    abstract public String contactNo();
    abstract public String mailId();
    abstract public String city();
    abstract public String state();

}
class Address_pass extends Passanger1{


    @Override
    public int id() {
        int id= 1;
        id ++;

        return id;
    }

    @Override
    public String name() {

        return name;
    }
    @Override
    public String contactNo(){
        return contactNo;
    }
    @Override
    public String mailId(){
        return mailId;
    }
    @Override
    public String city(){
        return city;

    }
    @Override
    public String state(){
        return state;
    }

}

// ticket class//
interface Regular_t{

    String special_service();
    String typeOfService ();


}


interface Tourist_t{
    int maxloc =5;
    String touristLoc();
    int maxLocAvailable();
    int addTouristLoc();
    int deleteTouristLoc();
    int updateTouristLOc();
}



class Ticket implements Regular_t,Tourist_t {

    public String special_service() {
        System.out.println("Do you want any special service ??  enter yes /no");
        Scanner r11 = new Scanner(System.in);
      String service = r11.nextLine();
      return service;
    }

    public String typeOfService() {
        Scanner t6= new Scanner(System.in);
        String service_type = t6.next();
        if (special_service().equals("yes")) {
            System.out.println("What type of Special service you want??" + service_type);

        } else {
            System.out.println("no special service required");
        }
        return service_type;
    }


   @Override
    public int maxLocAvailable() {
        System.out.println("Maximum Available Locations Are :" + "  " +  maxloc);
        return maxloc;
    }

    @Override
    public int addTouristLoc() {
        Scanner t1 = new Scanner(System.in);
        System.out.println("add no of tourist location you want : ");
        int addition = t1.nextInt();

        int no = maxloc + addition;
        System.out.println(" you have Added location & total location in your list is :" + " " + no);
        return no;
    }

    public String touristLoc() {
        System.out.println("Add  name of tourist location you want :");
        Scanner r1 = new Scanner(System.in);
        String Location = r1.nextLine();
        System.out.println(" Tourist location " + " " + Location + " " + "is added successfully");
        return Location;
    }


    @Override
    public int deleteTouristLoc() {
        System.out.println("delete no of tourist location you don't want : ");
        Scanner t2 = new Scanner(System.in);
        int delete = t2.nextInt();
        int no = maxloc - delete;
        System.out.println(" you have deleted location & now total location in your list is :" + " " + no);
        return no;
    }

    public int updateTouristLOc() {
        System.out.println(" updated successfully");
        return 1;
    }
}
abstract class Flight{
int capacity;
int no_ofseats;
String flight_id;
int no_ofFlights;
String flight_name;

//ticket//
 String flight_type;
 int PNR_no;
 String booking_type;
 String departure_loc;
 String destination_loc;
 String booking_date;
 String booking_time;
 String arrival_time;
 String arrival_date;
 int booked_seats;
 int seat_no;
 int ticket_id;
 int ticket_type;
 boolean status;

 // methods//
    abstract public int getNo_ofseats_available();
    abstract public boolean is_flight_availble();
    abstract public String getBooking_type();
    abstract public int cancle_booking();
    abstract public int getNo_ofseats_booked();
    abstract public boolean isticket_genarated();
    abstract public int generate_PNR_no();
}

class Ticket_t extends Flight {
    @Override
    public int getNo_ofseats_available() {
        Random random = new Random();
        this.no_ofseats = random.nextInt(20);
        System.out.println(no_ofseats +" "+ " Seats available");

        return no_ofseats;
    }

    @Override
    public boolean is_flight_availble() {
        if (no_ofseats >=0) {

            System.out.println("Flights are available");

        } else {
            System.out.println("Flights are not available");

        }
        return true;
    }


    @Override
    public String getBooking_type() {
        System.out.println(" enter ticket type you want Regular/ Tourist  ");
        Scanner b1=new Scanner(System.in);
        String booking_type=b1.nextLine();
        if (booking_type == "Regular") {
            System.out.println("you choose regular ticket");

        } else if (booking_type == "Tourist") {
            System.out.println("you choose tourist ticket");
        }
        return booking_type;
    }


    @Override
    public int getNo_ofseats_booked() {
        Random r1 = new Random();
        this.booked_seats = r1.nextInt(15);
        System.out.println("No of seats booked are " + booked_seats);
        return booked_seats;
    }
    @Override
    public boolean isticket_genarated() {
        if ((no_ofseats - booked_seats) != 0) {
            System.out.println(" Ticket is generated");
            return true;
        } else {
            System.out.println("Ticket is not generated");
            return false;
        }
    }
    @Override
    public int cancle_booking() {
        System.out.println("press 0 for cancle booking or continue with other no");
        Scanner c1= new Scanner(System.in);
        int n= c1.nextInt();
        if (n == 0) {
            System.out.println("your booking is cancle");
        } else {
            System.out.println("Your ticket is generated & Pnr no as follows");
        }
        return n;
    }

    @Override
    public int generate_PNR_no(){
        Random r2= new Random();
        this.PNR_no = r2.nextInt(12354);
        System.out.println(" PNR NO  :" + PNR_no );
        return PNR_no;
    }

}





    public class Flight_reservations_system {
    public static void main(String[] args) {

        // passenger class//
        Passanger1 p=new Address_pass();
        /* generate id// */

        //System.out.println("Passanger id is"+" "+p.id());
        Scanner p1= new Scanner(System.in);

// Accept user input name//
        System.out.print("Enter your name here: ");
        String name= p1.nextLine();


//Accept user input contact no//
        System.out.println("Enter Your contact no :");
        Scanner p2=new Scanner(System.in);
        String contactNo = p2.next();

// Accept user input mail id//
        System.out.println("Enter Your mail id :");
        Scanner p3 = new Scanner(System.in);
        String mailId = p3.next();

        //Accept User input Aaddress Details//
        System.out.println(" Enter Your address :" + " city  and  state");
        Scanner p4 =new Scanner(System.in);
        String city = p4.nextLine();
        String state =p4 .nextLine();


        // Printing all inputs together//
        System.out.println("Passanger id is"+" "+p.id());
        System.out.println("Passanger name is "+" "+ name);
        System.out.println("Passanger Contact Details :"+" "+ contactNo);
        System.out.println("Passenger MAil id is : "+" "+ mailId);
        System.out.println(" Address details of passenger :" );
        System.out.println(" city : " + city);
        System.out.println(" state : " + state);


        //ticket class objects //

        //  object for regular ticket//
        Ticket regul =new Ticket();
        regul.special_service();
        regul.typeOfService();



        //   object for tourist ticket//
        Ticket tour =new Ticket();
        tour.maxLocAvailable();
        tour.addTouristLoc();
        tour.deleteTouristLoc();
        tour.maxLocAvailable();
        tour.updateTouristLOc();
        tour.touristLoc();

        // flight details and ticket genration//
        Ticket_t tickets= new Ticket_t();
        tickets.is_flight_availble();
        tickets.getNo_ofseats_available();
        tickets.getBooking_type();
        tickets.getNo_ofseats_booked();
        tickets.cancle_booking();
        tickets.generate_PNR_no();
    }
    }




