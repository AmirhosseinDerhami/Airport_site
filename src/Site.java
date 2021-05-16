import java.util.*;

public class Site {
    private final int siteLenLine;
    private int usersLength;
    private final Data data = Data.gIns();

    public Site(int siteLenLine) {
        this.siteLenLine = siteLenLine;
        usersLength = data.getUsers().size();
    }

    /**
     * welcome panel
     * - Register - Login - Exit
     * @throws Exception Exception
     */
    public void welcomePanel() throws Exception {
        while (true) {
            ClearConsul.clsLn();
            new Text(" welcome to myAir console site ")
                    .makeCenter(siteLenLine, '=')
                    .colorText(5, 10)
                    .println();
            new Text().menu(">> user panel :",
                    "- Register", "- Login", "- Exit").println();

            switch (getCommendCodeWithCls(2, 10,
                    "enter the commend code :", 1, 2, 3, -3)) {
                case 1 -> registration();
                case 2 -> LoggingPanel();
                case 3 -> {
                    new Text(" good bye ")
                            .colorText(6, 10)
                            .makeCenter(siteLenLine, '>')
                            .addFirst("\n").printByDelayChar(25, 2500);
                    return;
                }
                case -3 -> {
                    System.out.print(">> password:");
                    if (new Scanner(System.in).nextLine().equalsIgnoreCase("Admin")) {
                        List<User> users = data.getUsers();
                        for (int n = 0; n < users.size(); n++) {
                            System.out.println("\n===>  user:" + (n + 1) + "\t" + users.get(n));
                            Flight.printSchedule(users.get(n).getFlights(), siteLenLine);
                            System.out.print("\n" + "=".repeat(siteLenLine));
                        }
                    } else System.out.println("wrong");
                }
            }
            new Text("").makeCenter(siteLenLine, '.')
                    .addFirst("\n").colorText(4, 10).println();
            new Text("please enter any key to continue ...")
                    .colorText(1, 18)
                    .addFirst(">>").print();
            new Scanner(System.in).nextLine();
        }
    }

    /**
     * find user by username and password and if there was current go to guidancePanel
     * @throws InterruptedException InterruptedException
     */
    public void LoggingPanel() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int userIndex;
        new Text(" welcome to logging ")
                .makeCenter(siteLenLine, '.')
                .colorText(5, 10).println();

        for (int limit = 5; ; limit--) {
            if (limit <= 0) {
                System.out.println("\n\t>too many try please wait and try again");
                return;
            }
            new Text("enter your username : ")
                    .colorText(7, 10).addFirst(">>").print();
            userIndex = data.searchUser(scanner.nextLine());
            if (userIndex == -1)
                System.out.println("\t >there is no user by this username :(   " +
                        "don't forgot to register ;)");
            else break;
        }

        for (int limit = 5; ; limit--) {
            if (limit <= 0) {
                System.out.println("\t\t>too many try please wait and try again");
                return;
            }
            new Text("enter your password : ")
                    .colorText(7, 10).addFirst(">>").print();
            String password = scanner.nextLine();
            if (!data.getUser(userIndex).getPassword().equals(password))
                System.out.println("\t >password doesn't match :( " + " try again ;)");
            else break;
        }

        new Text("   you are in \2   ")
                .colorText(3, 10)
                .makeCenter(siteLenLine * 13 / 12, '_').println();
        Thread.sleep(1000);

        guidancePanel(data.getUser(userIndex));
    }

    /**
     * guidance panel :"
     * Show list of all flights"
     * Flights setting"
     * Logout
     * @param currentUser currentUser
     * @throws InterruptedException InterruptedException
     */
    private void guidancePanel(User currentUser) throws InterruptedException {
        while (true) {
            ClearConsul.clsLn();
            new Text(" " + currentUser.getUsername() + " welcome to myAir console site ")
                    .makeCenter(siteLenLine, '-')
                    .colorText(5, 10)
                    .println();

            new Text().menu(">> guidance panel :"
                    , "- Show list of all flights"
                    , "- Flights setting"
                    , "- Logout").println();

            switch (getCommendCodeWithCls(2, 10,
                    "enter the commend code :", 1, 2, 3, 4)) {
                case 1 -> {
                    new Text(" list of all flights ")
                            .makeCenter(siteLenLine, '.')
                            .colorText(5, 10).println("\n");
                    Flight.printSchedule(data.getFlightSchedule(), siteLenLine);
                }
                case 2 -> userFlightsPanel(currentUser);
                case 3 -> {
                    new Text(" come back soon ;) ")
                            .colorText(1, 15)
                            .makeCenter(siteLenLine * 14 / 12, '*')
                            .printByDelayChar(50);
                    return;
                }
            }
            /*.......................................................*/
            new Text("").makeCenter(siteLenLine, '.')
                    .colorText(4, 10)
                    .addFirst("\n").println();
            new Text("please enter any key to continue ...")
                    .colorText(1, 18)
                    .addFirst(">>").print();
            new Scanner(System.in).nextLine();
        }
    }

    /**
     * user flight setting by using adding or removing flight(s)
     * @param currentUser currentUser
     */
    public void userFlightsPanel(User currentUser) {
        while (true) {
            ClearConsul.clsLn();
            new Text(" " + currentUser.getUsername() + " flight setting console panel ")
                    .makeCenter(siteLenLine, '-')
                    .colorText(5, 10)
                    .println();

            new Text().menu(">> flight panel :"
                    , "- Show list of all flights"
                    , "- Show me flights"
                    , "- Search flights"
                    , "- Edit flights"
                    , "- Go back"
            ).println();

            switch (getCommendCodeWithCls(2, 10,
                    "enter the commend code :", 1, 2, 3, 4, 5)) {
                case 1 -> {
                    new Text(" list of all flights ")
                            .makeCenter(siteLenLine, '.')
                            .colorText(5, 10).println("\n");
                    Flight.printSchedule(data.getFlightSchedule(), siteLenLine);
                }
                case 2 -> Flight.printSchedule(currentUser.getFlights(), siteLenLine);
                case 3 -> editUserFlight(currentUser, true);
                case 4 -> editUserFlight(currentUser, false);
                case 5 -> {
                    return;
                }
            }
            /*.......................................................*/
            new Text("").makeCenter(siteLenLine, '.')
                    .colorText(4, 10)
                    .addFirst("\n").println();
            new Text("please enter any key to continue ...")
                    .colorText(1, 18)
                    .addFirst(">>").print();
            new Scanner(System.in).nextLine();
        }
    }

    /**
     * add or remove user flight
     *
     * @param currentUser currentUser
     * @param action      true for add ; false for remove
     */
    public void editUserFlight(User currentUser, boolean action) {
        ArrayList resultSchedule;
        ArrayList<String> parameter = new ArrayList();
//----------- ----------- -----------
        if (action)//true for add
        {
            resultSchedule = searchFlight(data.getFlightSchedule(), "search flight");
            parameter.add("add");
            parameter.add("all");
            parameter.add("+");
        } else // false for remove
        {
            if (currentUser.getFlights().isEmpty()) {
                System.out.println("\t>> you done have any flight yet ");
                return;
            }
            resultSchedule = searchFlight(currentUser.getFlights(), "your flight");
            parameter.add("-");
            parameter.add("delete");
            parameter.add("remove");
        }

        new Text(" final result ").makeCenter(siteLenLine, '_')
                .colorText(6, 10).add("\n").println();
        Flight.printSchedule(resultSchedule, siteLenLine);

        if (!resultSchedule.isEmpty()) {
//----------- ----------- ----------- -----------
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n\n>>to edit your flight(s) press *");
            for (String str : parameter) System.out.print(" or " + str);
            System.out.print("\n\t\t>> enter any key else to go back  : ");
            String getKey = scanner.nextLine();
            boolean check = false;
            for (String pr : parameter)
                if (getKey.equalsIgnoreCase(pr)) {
                    check = true;
                    break;
                }
            if (check || getKey.equalsIgnoreCase("*")) {
                if (action) currentUser.addFlights(resultSchedule);
                else currentUser.removeFlights(resultSchedule);

                new Text(action ? " adding is finish " : " removing is done ")
                        .colorText(5, 10)
                        .makeCenter(siteLenLine * 14 / 13, '-')
                        .addFirst("\n").println();
                return;
            }
//--------- --------- --------- --------- ---------
        }

        new Text(" no changes happened ").makeCenter(siteLenLine, '-')
                .colorText(1, 13).addFirst("\n").println();
    }

    /**
     * to search on Data flight table and narrow it down and add by user choice
     * @param table table
     * @param title title
     * @return selected flight(s) user
     */
    private ArrayList<Flight> searchFlight(ArrayList<Flight> table, String title) {
        String titleTemp = new Text(" " + title + " ")
                .makeCenter(siteLenLine, '.')
                .colorText(5, 10).add("\n").getText();
        ArrayList<Flight> schedule = table;
        boolean isFound = true;

        boolean[] isItemFull = new boolean[]
                /*isFromFull isToFull isDayFull isTimeFull*/
                {false, false, false, false};
        String[] enterOfUser = new String[5];
        ArrayList<Flight> tempSchedule = null;
        for (int num = 0; num < 4; num++) {/*-----------------------*/
            if (!isFound) return schedule;

            ClearConsul.clsLn();
            System.out.println(titleTemp);
            Flight.printSchedule(schedule, siteLenLine);
            System.out.println("\n-------> enter ALL to select all items ");
            if (isItemFull[0]) {
                System.out.println(">> From is : " + enterOfUser[1]);
                if (isItemFull[1]) {
                    System.out.println(">> To is : " + enterOfUser[2]);
                    if (isItemFull[2]) {
                        System.out.println(">> Day is : " + enterOfUser[3]);
                        if (isItemFull[3]) {
                            System.out.println(">> Time is : " + enterOfUser[4]);
                        } else tempSchedule = enterInSearchFlight(
                                " enter Time", num + 1, enterOfUser, schedule);
                    } else tempSchedule = enterInSearchFlight(
                            " enter Day", num + 1, enterOfUser, schedule);
                } else tempSchedule = enterInSearchFlight(
                        " enter To", num + 1, enterOfUser, schedule);
            } else tempSchedule = enterInSearchFlight(
                    " enter From", num + 1, enterOfUser, schedule);

            if (tempSchedule.isEmpty()) isFound = false;
            schedule = tempSchedule;
            isItemFull[num] = true;
            if (schedule.size() == 1) break;
        }/*------------------------------------------------------*/
        return schedule;
    }

    /**
     * search by 'indexItem' in table and fill the enters
     * and use the message for asking
     * @param message   message
     * @param indexItem indexItem
     * @param enters    enters
     * @param table     table
     * @return ArrayList of match flight
     */
    private ArrayList<Flight> enterInSearchFlight(String message, int indexItem
            , String[] enters, ArrayList<Flight> table) {
        ArrayList<Flight> ans = new ArrayList<>();
        String input;
        while (true) {
            new Text(message + " : ").colorText(7, 10)
                    .addFirst(">>").print();
            input = new Scanner(System.in).nextLine();
            if (input.isEmpty()) System.out.println("\t\t >input can't be empty ");
            else if (input.equalsIgnoreCase("All")) {
                enters[indexItem] = "ALL";
                return table;
            } else break;
        }
        input = input.trim();
        enters[indexItem] = input;
        for (Flight flight : table)
            if (flight.getByIndex(indexItem).toLowerCase().contains(input.toLowerCase()) ||
                    flight.getByIndex(indexItem).toLowerCase().contains(input.toUpperCase()) ||
                    flight.getByIndex(indexItem).toUpperCase().contains(input.toLowerCase()) ||
                    flight.getByIndex(indexItem).toUpperCase().contains(input.toUpperCase()))
                ans.add(flight);
        return ans;
    }

    /**
     * || registering panel  ||
     * || get username and password from user ||
     * || add this user to users ||
     * || stop on with 5 time limit ||
     */
    public void registration() {
        new Text(" welcome to Registering ")
                .makeCenter(siteLenLine, '.')
                .colorText(5, 10).println();
        Scanner scanner = new Scanner(System.in);
        String password, username;
        for (int limit = 5; ; limit--) {
            new Text("enter your username : ")
                    .colorText(7, 10)
                    .addFirst(">>").print();
            username = scanner.nextLine();
            if (limit <= 0) {
                System.out.println("\t\t>too many try please wait and try again");
                return;
            }
            if (data.checkUsername(username))
                new Text(" this username is already token :( ")
                        .colorText(2, 18).addFirst("\t\t>").println();
            else break;
        }
        new Text("enter your password : ")
                .colorText(7, 10).addFirst(">>").print();
        password = scanner.nextLine();
        int userId = (1000 + usersLength + 1) * 10;
        data.addUser(new User(username, password, userId));
        usersLength = data.getUsers().size();
        new Text("\n\t\t> registration is done \2").println();
    }

    /**
     * ask for '>>please  + message  ' with entered color.
     * if num is not in menu shows error
     *
     * @param textColor       textColor
     * @param backgroundColor backgroundColor
     * @param message         message
     * @param options         options
     * @return the num code (default is -404 )
     */
    public int getCommendCode(int textColor, int backgroundColor
            , String message, int... options) {
        Scanner scanner = new Scanner(System.in);
        int num = -404;
        while (true) {
            new Text("please " + message + " ")
                    .colorText(textColor, backgroundColor)
                    .addFirst(">>").print();
            if (options.length == 0) {
                scanner.nextLine();
                break;
            }
            try {
                num = Integer.parseInt(scanner.nextLine());

            } catch (Exception error) {
                System.out.println("\t>please use acceptable input");
                continue;
            }

            int finalNum = num;
            if (Arrays.stream(options).anyMatch(i -> i == finalNum))
                break;
            else {
                System.out.println("\t>please choose from the menu option(s)");
            }
        }
        return num;
    }

    /**
     * ask for '>>please  + message  ' with entered color.then cls.
     * if num is not in menu shows error
     *
     * @param textColor       textColor
     * @param backgroundColor backgroundColor
     * @param message         message
     * @param options         options
     * @return the num code (default is -404 )
     */
    public int getCommendCodeWithCls(int textColor, int backgroundColor,
                                     String message, int... options) {
        int num = getCommendCode(textColor, backgroundColor, message, options);
        ClearConsul.clsLn();
        return num;
    }
}

