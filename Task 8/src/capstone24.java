
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.time.LocalDate;

    public class capstone24 {

        /* This first section of the code presents Methods only*/
        /* The second section runs the code*/
        /* the view method displays all the projects in the system*/

        public static void view() throws IOException {

            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above*/
            allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

            try {
                for (int i = 0; i < allProjects.size() ; i++) {
                    /* get all projects from the arraylist and store them in allProjects1*/
                    String allProjects1 = allProjects.get(i);
                    /* change the arraylist to an array with all projects*/
                    /* split the all  the projects in the array called allProjects1 to enable getting indexes*/
                    String [] all1Projects2 = allProjects1.split(",");

                    System.out.println("Project number: "+ all1Projects2[0]);

                    System.out.println("Client name: " + all1Projects2[1]);

                    System.out.println("Project name: " + all1Projects2[2]);

                    System.out.println("Project erf number: " + all1Projects2[3]);

                    System.out.println("Project type:  " + all1Projects2[4]);

                    System.out.println("Project address: " + all1Projects2[5]);

                    System.out.println("Project cost: " + "R"+ all1Projects2[6]);

                    System.out.println("Amount paid to date: " + "R" + all1Projects2[7]);

                    System.out.println("Project due date: " + all1Projects2[8]);

                    System.out.println("Architect's name: " + all1Projects2[9]);

                    System.out.println("Contractor's name: " + all1Projects2[10]);

                    System.out.println("Project Status: " + all1Projects2[11]);

                    System.out.println("");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("All projects displayed");
            }
        }
        public static void clientsReg() {
            try {
                Scanner userI = new Scanner(System.in);

                System.out.println("Enter client's name ");
                String clientName = userI.nextLine();

                System.out.println("Enter client's contact number:");
                String clientContacts = userI.nextLine();

                System.out.println("Enter client email address:");
                String clientEmail = userI.nextLine();

                System.out.println("Enter client physical address:street number-street name-town-province");
                String clientAddress = userI.nextLine();

                /* this appending format ensure that the next input is written below each other in the text file*/
                try (FileWriter f = new FileWriter("clients.txt", true);
                     BufferedWriter b = new BufferedWriter(f);
                     PrintWriter p = new PrintWriter(b)) {
                    p.println(clientName + "," + clientContacts + "," + clientEmail+ "," + clientAddress);

                } catch (IOException i) {
                    i.printStackTrace();
                }
            }catch (InputMismatchException e){
                System.out.println("Error check your data types");
            }
        }

        public static void architectReg(){

            try {
                Scanner userI = new Scanner(System.in);

                System.out.println("Enter architect name: ");
                String architectName = userI.nextLine();

                System.out.println("Enter architect contact number: ");
                String architectContacts = userI.next();

                System.out.println("Enter architect email address: ");
                String architectEmail = userI.next();

                userI.nextLine();

                System.out.println("Enter architect physical address:street number-street name-town-province: ");
                String architectAddress = userI.nextLine();

                /* this appending format ensure that the next input is written below each other in the text file*/
                try (FileWriter f = new FileWriter("architects.txt", true);
                     BufferedWriter b = new BufferedWriter(f);
                     PrintWriter p = new PrintWriter(b)) {
                    p.println(architectName + "," +   architectContacts + "," + architectEmail+ "," + architectAddress);

                } catch (IOException i) {
                    i.printStackTrace();
                }
            }catch (InputMismatchException e){
                System.out.println("Error check your datatype");
            }
        }

        public static void contractorReg(){
            try {
                Scanner userI = new Scanner(System.in);

                System.out.println("Enter contractor's name ");
                String contractorName = userI.nextLine();

                System.out.println("Enter contractor's contact number: ");
                String contractorContacts = userI.next();

                System.out.println("Enter contractor email address: ");
                String contractorEmail = userI.next();

                userI.nextLine();

                System.out.println("Enter contractor physical address:street number-street name-town-province: ");
                String contractorAddress = userI.nextLine();

                try (FileWriter f = new FileWriter("contractors.txt", true);
                     BufferedWriter b = new BufferedWriter(f);
                     PrintWriter p = new PrintWriter(b)) {
                    p.println(contractorName + "," + contractorContacts + "," + contractorEmail+ "," + contractorAddress);

                } catch (IOException i) {
                    i.printStackTrace();
                }
            }catch (InputMismatchException e){
                System.out.println("Error check input type");
            }
        }

        public static Object viewClients(){
            ArrayList<String>clientsInfo = new ArrayList<>();
            try {
                clientsInfo = (ArrayList<String>) Files.readAllLines(Paths.get("clients.txt"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(int i= 0; i < clientsInfo.size();i++){
                String clientInfo1 = clientsInfo.get(i);

                String[] clientInfo2 = clientInfo1.split(",");

                System.out.println("Client name:" + clientInfo2[0]);

                System.out.println("Client contact:" + clientInfo2[1]);

                System.out.println("Client e-mail:" + clientInfo2[2]);

                System.out.println("Client address:" + clientInfo2[3]);

                System.out.println("");
            }
            return null;
        }

        public static void viewArchitect(){
            ArrayList<String>architectInfo = new ArrayList<>();
            try {
                architectInfo = (ArrayList<String>) Files.readAllLines(Paths.get("architects.txt"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i= 0; i < architectInfo.size();i++){
                String architectInfo1 = architectInfo.get(i);

                String[] architectInfo2 = architectInfo1.split(",");

                System.out.println("Architect name:" + architectInfo2[0]);

                System.out.println("Architect contact:" + architectInfo2[1]);

                System.out.println("Architect e-mail:" + architectInfo2[2]);

                System.out.println("Architect address:" + architectInfo2[3]);

                System.out.println("");
            }
        }

        public static void viewContractor(){
            ArrayList<String>contractorInfo = new ArrayList<>();
            try {
                contractorInfo = (ArrayList<String>) Files.readAllLines(Paths.get("contractors.txt"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i= 0; i < contractorInfo.size();i++){
                String contractorInfo1 = contractorInfo.get(i);

                String[] contractorInfo2 = contractorInfo1.split(",");

                System.out.println("Contractor name:" + contractorInfo2[0]);

                System.out.println("Contractor contact:" + contractorInfo2[1]);

                System.out.println("Contractor e-mail:" + contractorInfo2[2]);

                System.out.println("Contractor address:" + contractorInfo2[3]);

                System.out.println("");
            }
        }

        public static void projectReg() {

            Scanner userI = new Scanner(System.in);

            System.out.println("Enter the project number: ");
            int projectNumber = Integer.parseInt(userI.nextLine());

            System.out.println("Choose client from this list of registered clients, If client is not here register the client first");
            System.out.println("Enter client's name: ");

            ArrayList<String> clientsInfo = new ArrayList<>();
            try {
                clientsInfo = (ArrayList<String>) Files.readAllLines(Paths.get("clients.txt"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < clientsInfo.size(); i++) {
                String clientInfo1 = clientsInfo.get(i);

                String[] clientInfo2 = clientInfo1.split(",");

                System.out.println("Client name:" + clientInfo2[0]);}

            String clientName = userI.nextLine();

            System.out.println("Enter the Client Surname: ");
            String clientSurname = userI.nextLine();

            System.out.println("Enter the project name: ");
            String projectName = userI.nextLine();

            System.out.println("Enter the project erf number: ");
            int projectErfNumber = Integer.parseInt(userI.nextLine());

            System.out.println("Enter the project type: ");
            String projectType = userI.nextLine();

            System.out.println("Enter the project address as: street number-street name-town-province");
            String projectAddress = userI.nextLine();

            System.out.println("Enter the project cost");
            int projectCost = Integer.parseInt(userI.nextLine());

            System.out.println("Enter the cost paid to date");
            int paidToDate = Integer.parseInt(userI.nextLine());

            System.out.println("Enter the project deadline as: yyy-MM-dd");
            String projectDeadLine = userI.nextLine();

            System.out.println("Choose architect from this list of registered architects," +
                    " If architect is not here register the architect first");
            System.out.println(" Enter the architect name");

            ArrayList<String>architectInfo = new ArrayList<>();
            try {
                architectInfo = (ArrayList<String>) Files.readAllLines(Paths.get("architects.txt"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(int i= 0; i < architectInfo.size();i++){
                String architectInfo1 = architectInfo.get(i);
                String[] architectInfo2 = architectInfo1.split(",");
                System.out.println("Architect name:" + architectInfo2[0]);
            }

            String architectName = userI.nextLine();

            System.out.println("Choose contractor from this list of registered contractors," +
                    " If contractor is not here register the contractor first");
            System.out.println("Enter the contractor name");

            ArrayList<String>contractorInfo = new ArrayList<>();
            try {
                contractorInfo = (ArrayList<String>) Files.readAllLines(Paths.get("contractors.txt"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(int i= 0; i < contractorInfo.size(); i++){
                String contractorInfo1 = contractorInfo.get(i);
                String[] contractorInfo2 = contractorInfo1.split(",");
                System.out.println("Contractor name:" + contractorInfo2[0]);}

            String contractorName = userI.nextLine();

            System.out.println("Enter Finalised or Active to indicate project status");
            String projectStatus = userI.nextLine();

            if (projectName.equalsIgnoreCase("") ) {
                projectName = "House  " + clientSurname;
            }

            try (FileWriter f = new FileWriter("projects.txt", true);
                 BufferedWriter b = new BufferedWriter(f);
                 PrintWriter p = new PrintWriter(b)) {
                p.println(projectNumber + "," + clientName + "," + projectName + "," + projectErfNumber + "," + projectType +
                        "," + projectAddress + "," + projectCost + "," + paidToDate + "," + projectDeadLine +
                        ","+ architectName + "," + contractorName + "," + projectStatus);

            } catch (IOException i) {
                i.printStackTrace();
            }
        }

        public static void dueProjects() throws IOException {
            Scanner userI = new Scanner(System.in);

            /* store the all the projects in the arraylist created above*/
            ArrayList<String> allDueProjects;
            allDueProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

            /* create today's date variable*/
            LocalDate today = LocalDate.now();

            String status;
            status = "active";
            try {int i;
                for (i = 0; i < allDueProjects.size() ; i++) {
                    /* get all projects from the arraylist and store them in allProjects1*/
                    String allDueProjects1 = allDueProjects.get(i);
                    /* change the arraylist to an array with all projects*/
                    /* split the all  the projects in the array called allProjects1 to enable getting indexes*/
                    String[] allDueProjects2 = allDueProjects1.split(",");
                    /* all due projects should be before today's date and active. set the if statement looking for this condition*/

                    if (today.isAfter(LocalDate.parse(allDueProjects2[8])) &&allDueProjects2[11].equalsIgnoreCase(status)) {

                        System.out.println("Project number: " + allDueProjects2[0]);

                        System.out.println("Client name: " + allDueProjects2[1]);

                        System.out.println("Project name: " + allDueProjects2[2]);

                        System.out.println("Project erf number: " + allDueProjects2[3]);

                        System.out.println("Project type:  " + allDueProjects2[4]);

                        System.out.println("Project address: " + allDueProjects2[5]);

                        System.out.println("Project cost: " + "R" + allDueProjects2[6]);

                        System.out.println("Amount paid to date: " + "R" + allDueProjects2[7]);

                        System.out.println("Project due date: " + allDueProjects2[8]);

                        System.out.println("Architect's name: " + allDueProjects2[9]);

                        System.out.println("Contractor's name: " + allDueProjects2[10]);

                        System.out.println("");

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void toBeCompleted() throws IOException {

            Scanner userI = new Scanner(System.in);

            ArrayList<String> incomplete;

            incomplete = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

            try {
                System.out.println(" To view projects to be completed type Active");

                String toBeCompleted = userI.nextLine();

                for (int i = 0; i < incomplete.size() ; i++) {
                    /* get all projects from the arraylist and store them in allProjects1*/

                    String incomplete1 = incomplete.get(i);
                    /* change the arraylist to an array with all projects*/
                    /* split the allProjects in the array called allProjects1 to enable getting indexes*/
                    String [] incomplete2 = incomplete1.split(",");

                    if (incomplete2[11].equalsIgnoreCase(toBeCompleted)) {

                        System.out.println("Project number: "+ incomplete2[0]);

                        System.out.println("Client name: " + incomplete2[1]);

                        System.out.println("Project name: " + incomplete2[2]);

                        System.out.println("Project erf number: " + incomplete2[3]);

                        System.out.println("Project type:  " + incomplete2[4]);

                        System.out.println("Project address: " + incomplete2[5]);

                        System.out.println("Project cost: " + "R"+ incomplete2[6]);

                        System.out.println("Amount paid to date: " + "R" + incomplete2[7]);

                        System.out.println("Project due date: " + incomplete2[8]);

                        System.out.println("Architect's name: " + incomplete2[9]);

                        System.out.println("Contractor's name: " + incomplete2[10]);

                        System.out.println("Project status: " + incomplete2[11]);

                        System.out.println("");
                    }
                }
            } catch (IndexOutOfBoundsException ignored){}
        }

        // this is a method to invoice and finalise the project
        public static void invoice() throws IOException {
            Scanner userI = new Scanner(System.in);

            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");

            /* take userinput to indicate the project they want to edit*/
            int projectNum = userI.nextInt();

            /*create a local variable for project to edit*/
            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the textfile*/
            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above (allprojects)*/
            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allprojects1*/
                /* create an array called allprojects2 and split to get indexes to manipulate*/

                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);

                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to finalise " + Arrays.toString(allProjects2));
                        int answer = Integer.parseInt(allProjects2[6]) - Integer.parseInt(allProjects2[7]);

                        if (answer != 0) {
                            System.out.println("Below is the  registered clients details\n" +
                                    "Confirm  the details from here\n");

                            System.out.println(viewClients());

                            System.out.print("\nChoose and enter the clients contact details from above\n");

                            System.out.println("Enter the clients contact details");
                            String contactDetails = userI.next();

                            System.out.println("Enter the clients e-mail address");
                            String emailAddress = userI.next();

                            /* customer invoice takes the information from the project details based on the amount paid*/
                            /* client contact details are read and manual inputted in the invoice*/

                            System.out.println("\n  Customer Invoice:  \n");

                            System.out.println("Client's name: " + allProjects2[1]);

                            System.out.println("Client's contact numbers: " + contactDetails);

                            System.out.println("Client's email address: " + emailAddress);

                            System.out.println("Outstanding amount: " + answer);

                            System.out.println("\nThank you for your continued support\n");

                            try (FileWriter fw = new FileWriter("completed projects.txt",true);

                                 BufferedWriter bw = new BufferedWriter(fw);
                                 PrintWriter pw = new PrintWriter(bw)){
                                System.out.println("Mark the project Finalised");

                                /* create a finalised variable and initialise it by taking user input*/
                                /* create a local date variable to take a date on which the project is finalised*/
                                String finalised;
                                finalised = userI.next();
                                LocalDate today = LocalDate.now();

                                pw.println(allProjects2[0] + "," + allProjects2[1] + "," + allProjects2[2] + "," + allProjects2[3] + ","
                                        + allProjects2[4] + "," + allProjects2[5] + "," + allProjects2[6] + "," + allProjects2[7] + ","
                                        + allProjects2[8] + "," + allProjects2[9] + "," + allProjects2[10] + "," + finalised + " on " + today );
                            }
                        }
                        else {
                            try (FileWriter fw = new FileWriter("completed projects.txt",true);

                                 BufferedWriter bw = new BufferedWriter(fw);

                                 PrintWriter pw = new PrintWriter(bw)){
                                System.out.println("Mark the project Finalised");

                                /* create a finalised variable and initialise it by taking user input*/
                                /* create a local date variable to take a date on which the project is finalised*/
                                String finalised;
                                finalised = userI.next();
                                LocalDate today = LocalDate.now();

                                pw.println(allProjects2[0] + "," + allProjects2[1] + "," + allProjects2[2] + "," + allProjects2[3] + ","
                                        + allProjects2[4] + "," + allProjects2[5] + "," + allProjects2[6] + "," + allProjects2[7] + ","
                                        + allProjects2[8] + "," + allProjects2[9] + "," + allProjects2[10] + "," + finalised + " on " + today );
                            }
                        }
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public static void completed() throws IOException {

            try { ArrayList<String> completed = (ArrayList<String>) Files.readAllLines(Paths.get("completed projects.txt"), StandardCharsets.UTF_8);

                for (int i = 0; i < completed.size(); i++) {
                    String completed1 = completed.get(i);
                    String[] completed2 = completed1.split(",");

                    System.out.println("Project number: " + completed2[0]);

                    System.out.println("Client name: " + completed2[1]);

                    System.out.println("Project name: " + completed2[2]);

                    System.out.println("Project erf number: " + completed2[3]);

                    System.out.println("Project type:  " + completed2[4]);

                    System.out.println("Project address: " + completed2[5]);

                    System.out.println("Project cost: " + "R" + completed2[6]);

                    System.out.println("Amount paid to date: " + "R" + completed2[7]);

                    System.out.println("Project due date: " + completed2[8]);

                    System.out.println("Architect's name: " + completed2[9]);

                    System.out.println("Contractor's name: " + completed2[10]);

                    System.out.println("Project status: " + completed2[11]);

                    System.out.println("");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        public static void clientName()throws IOException{

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/

            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");

            /* take userinput to indicate the project they want to edit*/
            int projectNum = userI.nextInt();

            /** create a local variable for project to edit*/
            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the textfile*/
            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above (allprojects)*/
            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allprojects1*/
                /* create an array called allprojects2 and split to get indexes to manipulate*/

                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);

                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));
                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        System.out.println(" Enter new Client's name: \n");

                        String clientName;

                        clientName = userI.next();

                        /* set index 0 to the new project number chosen*/
                        newList.set(1, String.valueOf(clientName));

                        allProjects.remove(projectToEdit);

                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("Allprojects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ) {
                            String newList1 = "";
                            newList1+= allProjects.get(x);
                            System.out.println("this is updated " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for( i =0; i < allProjects.size();i++){
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public static void edit() throws IOException {

            Scanner userI = new Scanner(System.in);

            System.out.println(
                    " What would you like to edit:\n" + "\n" +

                            " Project number: Enter 1;\n" +

                            " Client name: Enter 2;\n" +

                            " Project name: Enter 3;\n" +

                            " Erf number: Enter 4;\n" +

                            " Project type: Enter 5;\n" +

                            " Project address: Enter 6;\n" +

                            " Project cost: Enter 7;\n" +

                            " Cost paid to date: Enter 8;\n" +

                            " Project due date: Enter 9;\n" +

                            " Project architect: Enter 10;\n" +

                            " Project Contractor: Enter 11;\n"+

                            " Project Status: Enter 12;\n");

            System.out.println("Enter your choice");

            int options = userI.nextInt();

            if (options == 1) {
                projectNumber();/* call method to edit project number*/
            }
            if (options == 2) {
                clientName();/* call method to edit client's name*/
            }
            if  (options == 3) {
                projectName();/* call method to edit project name*/
            }
            if  (options == 4) {
                erfNumber(); /* call method to edit erfnumber*/
            }
            if  (options == 5) {
                projectType(); /* call method to edit project type*/
            }
            if  (options == 6) {
                projectAddres();  /* call a method to edit adress*/
            }
            if (options == 7) {
                projectCost();  /* call a method to edit project cost*/
            }
            if (options == 8) {
                amountPaid();    /* call a method to edit amount paid*/
            }
            if (options == 9) {
                dueDate();      /* call a method to edit due date*/
            }
            if (options == 10) {
                architect();     /* call a method to edit architect*/
            }
            if (options == 11) {
                contractor();   /* call a method to edit contractor*/
            }
            if (options == 12) {
                projectStatus();  /* call a method to edit project status*/
            }
        }

        public static void projectNumber() throws IOException {

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/

            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");
            /* take userinput to indicate the project they want to edit*/

            int projectNum = userI.nextInt();
            /* create a local variable for project to edit*/

            /* initialised arraylist to store all projects as read from the textfile*/
            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above (allprojects)*/
            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allprojects1*/

                /* create an array called allprojects2 and split to get indexes to manipulate*/
                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);

                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        int projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        int pnumber = 0;

                        System.out.println("\nEnter the new project number");
                        pnumber = userI.nextInt();

                        /* set index 0 to the new project number chosen*/
                        newList.set(0, String.valueOf(pnumber));

                        allProjects.remove (projectToEdit);

                        allProjects.add (newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("This allprojects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ){
                            String newList1 = "";
                            newList1+= allProjects.get(x);

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for ( i =0; i < allProjects.size();i++) {
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        public static void projectName() {

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/

            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");
            /* take userinput to indicate the project they want to edit*/

            int projectNum = userI.nextInt();
            /* create a local variable for project to edit*/

            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the textfile*/
            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above (allprojects)*/
            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allprojects1*/
                /* create an array called allprojects2 and split to get indexes to manipulate*/

                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);

                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        String projectName;

                        System.out.println("\nEnter the new project name");
                        projectName = userI.next();

                        /*set index 0 to the new project name chosen*/
                        newList.set(2, String.valueOf(projectName));

                        /* remove the old project from the list*/

                        allProjects.remove(projectToEdit);
                        /* add new edited project to the list*/

                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("This allprojects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ){
                            String newList1 = "";

                            newList1+= allProjects.get(x);

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for( i =0; i < allProjects.size();i++){
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public static void erfNumber(){

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/
            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");
            /* take userinput to indicate the project they want to edit*/
            int projectNum = userI.nextInt();
            /* create a local variable for project to edit*/

            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the textfile*/
            ArrayList<String> allProjects;

            /* store the all the projects in the arraylist created above (allprojects)*/
            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allprojects1*/
                /* create an array called allprojects2 and split to get indexes to manipulate*/
                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);

                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }
                        String erfNumber;

                        System.out.println("\nEnter the new erf number");
                        erfNumber = userI.next();

                        /* set index 3 to the new project name chosen*/
                        newList.set(3, String.valueOf(erfNumber));
                        /* remove the old project from the list*/

                        allProjects.remove(projectToEdit);
                        /* add new edited project to the list*/

                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("This allprojects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ) {
                            String newList1 = "";

                            newList1+= allProjects.get(x);

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for ( i =0; i < allProjects.size();i++){
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }

        public static void projectType(){

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/
            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");
            /* take userinput to indicate the project they want to edit*/

            int projectNum = userI.nextInt();
            /* create a local variable for project to edit*/

            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the textfile*/
            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above (allprojects)*/
            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allprojects1*/
                /* create an array called allprojects2 and split to get indexes to manipulate*/
                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);

                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        String projectType;

                        System.out.println("\nEnter the new project type");
                        projectType = userI.next();

                        /* set index 4 to the new project name chosen*/
                        newList.set(4, String.valueOf(projectType));
                        /* remove the old project from the list*/

                        allProjects.remove(projectToEdit);
                        /* add new edited project to the list*/

                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("This allprojects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ) {
                            String newList1 = "";
                            newList1+= allProjects.get(x);

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for ( i =0; i < allProjects.size();i++) {
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }
        public static void projectAddres() {

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/
            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");
            /* take userinput to indicate the project they want to edit*/

            int projectNum = userI.nextInt();
            /* create a local variable for project to edit*/

            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the textfile*/
            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above (allprojects)*/
            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allprojects1*/
                /* create an array called allprojects2 and split to get indexes to manipulate*/
                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);

                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        String projectAddress;

                        System.out.println("\nEnter the new project address");
                        projectAddress = userI.next();

                        /* set index 5 to the new project name chosen*/
                        newList.set(5, String.valueOf(projectAddress));
                        /* remove the old project from the list*/

                        allProjects.remove(projectToEdit);
                        /* add new edited project to the list*/
                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("This allprojects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ) {
                            String newList1 = "";
                            newList1+= allProjects.get(x);

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for( i =0; i < allProjects.size();i++){
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public static void projectCost() {

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/

            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");
            /* take userinput to indicate the project they want to edit*/

            int projectNum = userI.nextInt();
            /* create a local variable for project to edit*/

            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the textfile*/
            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above (allprojects)*/

            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allprojects1*/
                /* create an array called allprojects2 and split to get indexes to manipulate*/

                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);

                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        int projectCost;

                        System.out.println("\nEnter the new project cost");
                        projectCost = userI.nextInt();

                        /* set index 6 to the new project name chosen*/
                        newList.set(6, String.valueOf(projectCost));
                        /* remove the old project from the list*/
                        allProjects.remove(projectToEdit);
                        /* add new edited project to the list*/

                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("This allprojects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ) {
                            String newList1 = "";
                            newList1+= allProjects.get(x);

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for ( i =0; i < allProjects.size();i++) {
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public static void amountPaid() {

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/

            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");
            /* take userinput to indicate the project they want to edit*/

            int projectNum = userI.nextInt();
            /* create a local variable for project to edit*/

            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the textfile*/

            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above (allprojects)*/

            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allprojects1*/
                /* create an array called allprojects2 and split to get indexes to manipulate*/
                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);
                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        int amountPaid;

                        System.out.println("\nEnter the new amount paid");
                        amountPaid = userI.nextInt();

                        /* set index 7 to the new project name */
                        newList.set(7, String.valueOf(amountPaid));

                        /* remove the old project from the list*/
                        allProjects.remove(projectToEdit);
                        /* add new edited project to the list*/

                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("This allprojects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ) {
                            String newList1 = "";
                            newList1+= allProjects.get(x);

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for ( i =0; i < allProjects.size();i++) {
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public static void dueDate() {

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/

            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");
            /* take user input to indicate the project they want to edit*/
            int projectNum = userI.nextInt();

            /* create a local variable for project to edit*/
            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the text file*/
            ArrayList<String> allProjects;
            /*store the all the projects in the arraylist created above (all projects)*/
            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called all projects1*/
                /* create an array called all projects2 and split to get indexes to manipulate*/
                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);
                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        String projectDueDate;

                        System.out.println("\nEnter the new project due date");
                        projectDueDate = userI.next();

                        /* set index 8 to the new project name chosen*/
                        newList.set(8, String.valueOf(projectDueDate));
                        /* remove the old project from the list*/

                        allProjects.remove(projectToEdit);
                        /* add new edited project to the list*/
                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("This allprojects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ) {
                            String newList1 = "";
                            newList1+= allProjects.get(x);

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for ( i =0; i < allProjects.size();i++) {
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public static void architect() {

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/

            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");
            int projectNum = userI.nextInt();
            /* create a local variable for project to edit*/

            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the text file*/
            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above (all projects)*/
            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allProjects1*/
                /* create an array called allProjects2 and split to get indexes to manipulate*/
                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);
                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        String projectArchitect;

                        System.out.println("\nEnter the new project architect");

                        projectArchitect = userI.next();

                        /* set index 9 to the new project name chosen*/
                        newList.set(9, String.valueOf(projectArchitect));
                        /* remove the old project from the list*/

                        allProjects.remove(projectToEdit);
                        /* add new edited project to the list*/

                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("This allProjects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ) {
                            String newList1 = "";
                            newList1+= allProjects.get(x);

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for ( i =0; i < allProjects.size();i++) {
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public static void contractor() {

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/

            System.out.println("PROJECTS LIST");

            try {
                view();/* call method to display all projects for the user to view and choose*/
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter the project number to edit from above list");
            /* take userinput to indicate the project they want to edit*/

            int projectNum = userI.nextInt();
            /* create a local variable for project to edit*/

            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the text file*/
            ArrayList<String> allProjects;

            // store the all the projects in the arraylist created above (allProjects)
            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called allProjects1*/
                /* create an array called allProjects2 and split to get indexes to manipulate*/

                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);
                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        String projectContractor;

                        System.out.println("\nEnter the new project contractor");
                        projectContractor = userI.next();

                        /* set index 10 to the new project name chosen*/
                        newList.set(10, String.valueOf(projectContractor));
                        /* remove the old project from the list*/

                        allProjects.remove(projectToEdit);
                        /* add new edited project to the list*/

                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));

                        System.out.println("This allProjects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ) {
                            String newList1 = "";
                            newList1+= allProjects.get(x);

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for ( i =0; i < allProjects.size();i++) {
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public static void projectStatus() {

            Scanner userI = new Scanner(System.in);
            /* When edit is chosen, display all projects in the system to allow user to choose from*/

            System.out.println("FOR EASE OF REFERENCE: BELOW IS A LIST OF ALL FINALISED PROJECT" );
            try {
                completed(); /*call method to display all finalised projects for the user to view and choose */
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Enter the project number to edit from above list");
            /* take userinput to indicate the project they want to edit*/

            int projectNum = userI.nextInt();
            /* create a local variable for project to edit*/

            int projectToEdit = 0;

            /* initialised arraylist to store all projects as read from the text file*/
            ArrayList<String> allProjects;
            /* store the all the projects in the arraylist created above (all projects)*/

            try {
                allProjects = (ArrayList<String>) Files.readAllLines(Paths.get("projects.txt"), StandardCharsets.UTF_8);

                ArrayList<String> newList = new ArrayList<>();
                /* loop through the size of the arraylist and store projects into a new string called all projects1*/
                /* create an array called all projects2 and split to get indexes to manipulate*/

                for (int i = 0; i < allProjects.size(); i++) {
                    String allProjects1 = allProjects.get(i);
                    String[] allProjects2 = allProjects1.split(",");

                    if (projectNum == Integer.parseInt(allProjects2[0])) {
                        projectToEdit = i;

                        System.out.println("This is the project number to edit " + allProjects2[0]);

                        System.out.println("This is project to edit " + Arrays.toString(allProjects2));

                        for (int x = 0; x < allProjects2.length; x++) {
                            newList.add(allProjects2[x]);
                        }

                        String projectStatus;

                        System.out.println("\nEnter the new project status ");

                        projectStatus = userI.next();

                        /* set index 11 to the new project name chosen*/
                        newList.set(11, String.valueOf(projectStatus));

                        /* remove the old project from the list*/
                        allProjects.remove(projectToEdit);

                        /* add new edited project to the list*/
                        allProjects.add(newList.get(0) + "," + newList.get(1) + "," + newList.get(2) + "," + newList.get(3) +
                                "," + newList.get(4) + "," + newList.get(5) + "," + newList.get(6) + "," +newList.get(7) +
                                "," + newList.get(8) + "," + newList.get(9) + "," + newList.get(10) + "," + newList.get(11));
                        // this is a control statement

                        System.out.println("This allProjects" + allProjects);

                        for (int x = 0;x < allProjects.size();x++ ) {
                            String newList1 = "";
                            newList1+= allProjects.get(x);
                            // this is a control statement

                            System.out.println("This is updated  " + newList1);

                            FileWriter fw = new FileWriter("projects.txt");

                            for ( i =0; i < allProjects.size();i++) {
                                fw.write(String.valueOf(allProjects.get(i)+"\n"));
                            }
                            fw.close();
                        }
                    }
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) throws Exception {
            Scanner userI = new Scanner(System.in);

            while (true) {
                System.out.println("\n" + "Welcome to Poise Project Management Page");

                System.out.println("\nEnter the corresponding words to action what you need to do, eg to view all projects enter view");

                System.out.println("\nNew Project: Register; View all projects: View; Edit project: Edit; New contractor: AddC;" +
                        "New architect: Adda;\n" + "New client: AddCl;  View client info: ClientInfo; View architect info: ArchInfo;" +
                        "Protects to complete: Incomplete; View contractor info: ContraInfo;\n" + "View overdue projects: Due;" +
                        "Finalise project with zero outstanding: Close; Finalise with invoice: Invoice; View completed: Completed ; Exit");

                System.out.println("\n   Enter your option  ");

                String options = userI.nextLine();
                /* based on the option entered, called a method displaying or computing that information*/

                if (options.equalsIgnoreCase("Adda")) {
                    architectReg();
                }

                if (options.equalsIgnoreCase("completed")) {
                    completed();
                }

                if (options.equalsIgnoreCase("invoice")) {
                    invoice();
                }

                if (options.equalsIgnoreCase("Incomplete")) {
                    toBeCompleted();
                }

                if (options.equalsIgnoreCase("due")) {
                    dueProjects();
                }

                if (options.equalsIgnoreCase("ArchInfo")) {
                    viewArchitect();
                }

                if (options.equalsIgnoreCase("AddC")) {
                    contractorReg();
                }

                if (options.equalsIgnoreCase("contraInfo")) {
                    viewContractor();
                }

                if (options.equalsIgnoreCase("clientInfo")) {
                    viewClients();
                }

                if (options.equalsIgnoreCase("AddCl")) {
                    clientsReg();
                }

                if (options.equalsIgnoreCase("Register")) {
                    projectReg();
                }

                if (options.equalsIgnoreCase("View")) {
                    view();
                }

                if (options.equalsIgnoreCase("Edit")) {
                    edit();
                }

                if (options.equalsIgnoreCase("Exit")){
                    break;
                }
            }
        }
    }



