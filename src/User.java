import java.util.*;

public class User {
    private String username;
    private String password;
    private int userId;
    private ArrayList<Flight> flights;

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int userId) {
        this(username, password);
        this.userId = userId;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void addFlights(ArrayList<Flight> flights) {
       /* boring version/for (Flight flight : flights)
            this.flights.add(flight);*/
        this.flights.addAll(flights);
    }

    public void removeFlights(ArrayList<Flight> flights) {
        for (Flight flight : flights)
            this.flights.remove(flight);
    }

    public User() {
        flights = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }

    /*/public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }*/

    public String getPassword() {
        return password;
    }


    /*.public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        if (userId < 10000) {
            System.out.println("\t\t>>Error");
            return;
        }
        this.userId = userId;
    }*/


    @Override
    public String toString() {
        return String.format("userID :%d \t username :%s \t\tpassword :%s \n"
                , userId
                , username
                , password);
    }
}
