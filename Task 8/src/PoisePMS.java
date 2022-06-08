import java.sql.*;
import java.time.LocalDate;
import java.util.*;


public class PoisePMS {

    public static void projectRegister() {
        Scanner userI = new Scanner(System.in);

        // declare driver connection
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                    "root", "Mysql@123");

            System.out.println("Enter the project number: ");
            int projectNumber = Integer.parseInt(userI.nextLine());

            System.out.println("Enter the Client name: ");
            String clientName = userI.nextLine();

            System.out.println("Enter the project name: ");
            String projectName = userI.nextLine();

            System.out.println("Enter the project erf number: ");
            String projectErfNumber = userI.nextLine();

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

            System.out.println(" Enter the architect name");
            String architectName = userI.nextLine();

            System.out.println("Enter the contractor name");
            String contractorName = userI.nextLine();

            System.out.println("Enter Finalised or Active to indicate project status");
            String projectStatus = userI.nextLine();

            System.out.println("Enter the client surname");
            String clientSurname = userI.nextLine();

            if(projectName.equalsIgnoreCase("")) {
                projectName = "House"+clientSurname;
            }

            // create a prepared statement placeholder for user inputs to be inserted
            String inputs = "Insert into projects values(?,?,?,?,?,?,?,?,?,?,?,?);";

            // declare a prepared statement connection to execute the input query
            PreparedStatement statement = connection.prepareStatement(inputs);

            //link the placeholders with the actual user inputs
            statement.setInt(1, projectNumber);
            statement.setString(2, clientName);
            statement.setString(3, projectName);
            statement.setString(4, projectErfNumber);
            statement.setString(5, projectType);
            statement.setString(6, projectAddress);
            statement.setInt(7, projectCost);
            statement.setInt(8, paidToDate);
            statement.setString(9, projectDeadLine);
            statement.setString(10, architectName);
            statement.setString(11, contractorName);
            statement.setString(12, projectStatus);

            // execute the query statement as written in input variable

            statement.executeUpdate();

            //Control statement below
            System.out.println("The project has been successfully registered");

            //close the query
            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void viewall(){
        //create connection to mySql using driver manager

       try { Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                "root", "Mysql@123");

        // create a connection statement to put through mysql

        Statement statement = connection.createStatement();

        //create the result sets as per the sql table with exact heading typing

        ResultSet results = statement.executeQuery("select ProjectNo,ClientName,ProjectName,ProjectErfNumber,ProjectType," +
                "ProjectAddress,ProjectCost,AmountPaid,ProjectDueDate,ArchitectName,ContractorName,ProjectStatus from projects");

        // print the contents of the sql "projects table" for viewing using the while results .next
        while(results.next()){
            System.out.println(results.getInt("ProjectNo") + "," + results.getString("ClientName") + "," +
                    results.getString("ProjectName") + "," + results.getString("ProjectErfNumber") + "," +
                    results.getString("ProjectType") + "," + results.getString("ProjectAddress") + "," +
                    results.getInt("ProjectCost") + "," + results.getInt("AmountPaid") + "," +
                    results.getString("ProjectDueDate") + "," + results.getString("ArchitectName") + "," +
                    results.getString("ContractorName") + "," + results.getString("ProjectStatus"));

        }
    } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }

    public static void projectEdit(){
        Scanner userI = new Scanner(System.in);

        try {//create connection to Mysql through Driver Manager
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                "root", "Mysql@123");
        //Statement statement = connection.createStatement();

        // display all the projects by calling the viewall projects method for user to view from
        System.out.println("POISE PMS: PROJECTS LIST\n");

        viewall();

        System.out.println(
                " \nWhat would you like to edit:\n" +

                        " Client name: Enter 1;\n" +

                        " Project name: Enter 2;\n" +

                        " Erf number: Enter 3;\n" +

                        " Project type: Enter 4;\n" +

                        " Project address: Enter 5;\n" +

                        " Project cost: Enter 6;\n" +

                        " Cost paid to date: Enter 7;\n" +

                        " Project due date: Enter 8;\n" +

                        " Project architect: Enter 9;\n" +

                        " Project Contractor: Enter 10;\n"+

                        " Project Status: Enter 11;\n");

        System.out.println("Enter your choice");
        int options = userI.nextInt();

        // based on the chosen option call a defined method to execute the required edit

         if (options == 1 ) {

             System.out.println("Enter the new client name\n");
             String clientUpdate = userI.next();

             clientUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String clientN = ("update projects set ClientName =" + "'" + clientUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(clientN);

             System.out.println("Client name successfully updated");

             stm.executeUpdate(clientN);
             stm.close();
             connection.close();
         }

         if (options == 2) {
             System.out.println("Enter the new project name\n");
             String projectNameUpdate = userI.next();

             projectNameUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String projectN = ("update projects set ProjectName =" + "'" + projectNameUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(projectN);

             System.out.println("Project name successfully updated");

             stm.executeUpdate(projectN);
             stm.close();
             connection.close();
             }

         if (options == 3) {
             System.out.println("Enter the new project erf number\n");
             String projectErfUpdate = userI.next();

             projectErfUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String projectE = ("update projects set ProjectErfNumber =" + "'" + projectErfUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(projectE);

             System.out.println("Project Erf Number successfully updated");

             stm.executeUpdate(projectE);
             stm.close();
             connection.close();
         }

         if (options == 4) {
             System.out.println("Enter the new project type\n");
             String projectTypeUpdate = userI.next();

             projectTypeUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String projectT = ("update projects set ProjectType =" + "'" + projectTypeUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(projectT);

             System.out.println("Project Type successfully updated");

             stm.executeUpdate(projectT);
             stm.close();
             connection.close();
             }

         if(options == 5){
             System.out.println("Enter the new project address\n");
             String projectAddressUpdate = userI.next();

             projectAddressUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String projectA = ("update projects set ProjectAddress =" + "'" + projectAddressUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(projectA);

             System.out.println("Project Address successfully updated");

             stm.executeUpdate(projectA);
             stm.close();
             connection.close();
         }

         if (options == 6) {
             System.out.println("Enter the new project cost\n");
             String projectCostUpdate = userI.next();

             projectCostUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String projectC = ("update projects set ProjectCost =" + "'" + projectCostUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(projectC);

             System.out.println("Project Cost successfully updated");

             stm.executeUpdate(projectC);
             stm.close();
             connection.close();
             }

         if (options == 7) {
             System.out.println("Enter the new amount paid to date\n");
             String amountPaidUpdate = userI.next();

             amountPaidUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String projectAP = ("update projects set AmountPaid =" + "'" + amountPaidUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(projectAP);

             System.out.println("Amount Paid successfully updated");

             stm.executeUpdate(projectAP);
             stm.close();
             connection.close();
             }

         if (options == 8) {
             System.out.println("Enter the new project due date\n");
             String projectDueUpdate = userI.next();

             projectDueUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String projectDue = ("update projects set ProjectDueDate =" + "'" + projectDueUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(projectDue);

             System.out.println("Project due date successfully updated");

             stm.executeUpdate(projectDue);
             stm.close();
             connection.close();
         }

         if (options == 9) {
             System.out.println("Enter the new project Architect\n");
             String projectArchitectUpdate = userI.next();

             projectArchitectUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String projectArchitect = ("update projects set ArchitectName =" + "'" + projectArchitectUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(projectArchitect);

             System.out.println("Project Architect successfully updated");

             stm.executeUpdate(projectArchitect);
             stm.close();
             connection.close();
             }

         if (options == 10 ){
             System.out.println("Enter the new project contractor\n");
             String projectContractorUpdate = userI.next();

             projectContractorUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String projectContractor = ("update projects set ContractorName =" + "'" + projectContractorUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(projectContractor);

             System.out.println("Project Contractor successfully updated");

             stm.executeUpdate(projectContractor);
             stm.close();
             connection.close();
         }

         if (options == 11) {
             System.out.println("Enter the new project status\n");
             String projectStatusUpdate = userI.next();

             projectStatusUpdate+=userI.nextLine();

             System.out.println("Enter the number of the project to edit");
             int projectNum = Integer.parseInt(userI.next());

             String projectStatus = ("update projects set ProjectStatus =" + "'" + projectStatusUpdate + "'" + "where ProjectNo = " + projectNum);

             PreparedStatement stm = connection.prepareStatement(projectStatus);

             System.out.println("Project Status successfully updated");

             stm.executeUpdate(projectStatus);
             stm.close();
             connection.close();
         }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void clientRegister() {
        Scanner userI = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                    "root", "Mysql@123");

            System.out.println("Enter client's name ");
            String clientName = userI.nextLine();
            clientName+= userI.nextLine();

            System.out.println("Enter client's contact number:");
            String clientContacts = userI.nextLine();

            System.out.println("Enter client email address:");
            String clientEmail = userI.nextLine();

            System.out.println("Enter client physical address:street number-street name-town-province");
            String clientAddress = userI.nextLine();
            clientAddress+= userI.nextLine();

            // create a prepared statement placeholder for user inputs to be inserted
            String inputs = "Insert into clients values(?,?,?,?);";

            // declare a prepared statement connection to execute the input query
            PreparedStatement statement = connection.prepareStatement(inputs);

            //link the placeholders with the actual user inputs

            statement.setString(1, clientName);
            statement.setString(2, clientContacts);
            statement.setString(3, clientEmail);
            statement.setString(4, clientAddress);

            // execute the query statement as written in input variable

            statement.executeUpdate();

            //Control statement below
            System.out.println("The client has been successfully registered");

            //close the query
            statement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void contractorRegister(){
        Scanner userI = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                    "root", "Mysql@123");

        System.out.println("Enter contractor's name ");
        String contractorName = userI.nextLine();
        contractorName+= userI.nextLine();

        System.out.println("Enter contractor's contact number: ");
        String contractorContacts = userI.next();

        System.out.println("Enter contractor email address: ");
        String contractorEmail = userI.next();

        userI.nextLine();

        System.out.println("Enter contractor physical address:street number-street name-town-province: ");
        String contractorAddress = userI.nextLine();
        contractorAddress+= userI.nextLine();

        // create a prepared statement placeholder for user inputs to be inserted
        String inputs = "Insert into contractors values(?,?,?,?);";

        // declare a prepared statement connection to execute the input query
        PreparedStatement statement = connection.prepareStatement(inputs);

        //link the placeholders with the actual user inputs

        statement.setString(1, contractorName);
        statement.setString(2, contractorContacts);
        statement.setString(3, contractorEmail);
        statement.setString(4, contractorAddress);

        // execute the query statement as written in input variable

        statement.executeUpdate();

        //Control statement below
        System.out.println("The contractor has been successfully registered");

        //close the query
        statement.close();
        connection.close();

    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void architectRegister(){
        Scanner userI = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                "root", "Mysql@123");

        System.out.println("Enter architect name: ");
        String architectName = userI.nextLine();
        architectName+=userI.nextLine();

        System.out.println("Enter architect contact number: ");
        String architectContacts = userI.next();

        System.out.println("Enter architect email address: ");
        String architectEmail = userI.next();

        userI.nextLine();

        System.out.println("Enter architect physical address:street number-street name-town-province: ");
        String architectAddress = userI.nextLine();
        architectAddress+= userI.nextLine();

        // create a prepared statement placeholder for user inputs to be inserted
        String inputs = "Insert into architects values(?,?,?,?);";

        // declare a prepared statement connection to execute the input query
        PreparedStatement statement = connection.prepareStatement(inputs);

        //link the placeholders with the actual user inputs

        statement.setString(1, architectName);
        statement.setString(2, architectContacts);
        statement.setString(3, architectEmail);
        statement.setString(4, architectAddress);

        // execute the query statement as written in input variable

        statement.executeUpdate();

        //Control statement below
        System.out.println("The architect has been successfully registered");

        //close the query
        statement.close();
        connection.close();

    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void viewArchitect(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                    "root", "Mysql@123");

        // create a connection statement to put through mysql

        Statement statement = connection.createStatement();

        //create the result sets as per the sql table with exact heading typing

        ResultSet results = statement.executeQuery("select ArchitectName,ArchitectContact,ArchitectEmail,ArchitectAddress from architects");

        // print the contents of the sql "projects table" for viewing using the while results .next
        while(results.next()){
            System.out.println(results.getString("ArchitectName") + "," + results.getString("ArchitectContact") + "," +
                results.getString("ArchitectEmail") + "," + results.getString("ArchitectAddress"));
        }
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void viewClient(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                    "root", "Mysql@123");

            // create a connection statement to put through mysql

            Statement statement = connection.createStatement();

            //create the result sets as per the sql table with exact heading typing

            ResultSet results = statement.executeQuery("select ClientName,ClientContact,ClientEmail,ClientAddress from clients");

            // print the contents of the sql "projects table" for viewing using the while results .next
            while(results.next()){
                System.out.println(results.getString("ClientName") + "," + results.getString("ClientContact") + "," +
                        results.getString("ClientEmail") + "," + results.getString("ClientAddress"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void viewContractor(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                    "root", "Mysql@123");

            // create a connection statement to put through mysql

            Statement statement = connection.createStatement();

            //create the result sets as per the sql table with exact heading typing

            ResultSet results = statement.executeQuery("select ContractorName,ContractorContact,ContractorEmail,ContractorAddress from contractors");

            // print the contents of the sql "projects table" for viewing using the while results .next
            while(results.next()){
                System.out.println(results.getString("ContractorName") + "," + results.getString("ContractorContact") + "," +
                        results.getString("ContractorEmail") + "," + results.getString("ContractorAddress"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void finalise(){

        // import scanner to enable  user input on which project to finalise
        Scanner userI = new Scanner(System.in);

        try{ Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                            "root", "Mysql@123");

        // create a connection statement to connect the query with the driver
        Statement statement = connection.createStatement();

        // display all the projects so that you can choose the one to finalise by calling the viewall method
        System.out.println("POISE PMS: PROJECTS LIST\n");

        viewall();

        // prompt the user to enter the project number of the project they want to finalise

        System.out.println("Enter the project number to edit from above list");
        int projectToFinalise = userI.nextInt();

        ResultSet results = statement.executeQuery("select * from projects where projectNo = " + projectToFinalise);

        while (results.next()){
           System.out.println(results.getInt("ProjectNo") + "," + results.getString("ClientName") + "," +
             results.getString("ProjectName") + "," + results.getString("ProjectErfNumber") + "," +
             results.getString("ProjectType") + "," + results.getString("ProjectAddress") + "," +
             results.getInt("ProjectCost") + "," + results.getInt("AmountPaid") + "," +
             results.getString("ProjectDueDate") + "," + results.getString("ArchitectName") + "," +
             results.getString("ContractorName") + "," + results.getString("ProjectStatus") + "\n");

            int amountPayable = results.getInt("ProjectCost") - results.getInt("AmountPaid");

            System.out.print(" CLIENTS LIST ");

            System.out.println("\nClient Name: " + results.getString("ClientName"));

            System.out.println("If the Client Name is not shown above, Please register the Client");

            System.out.println("\nClient Contact Information should show below\n");

            System.out.println("If the Client Name is not shown below, Please register the Client\n");

            viewClient();

            System.out.println("\nEnter the contact details of client: "+ results.getString("ClientName") + " from the list above");

            String clientContact = userI.next();

            System.out.println("\nEnter the email of client: "+ results.getString("ClientName") + "from the list above");

            String clientEmail = userI.next();

          if (amountPayable !=0) {
              System.out.println("\n  Customer Invoice:  \n");

              System.out.println("Client's name: " + results.getString("ClientName"));

              System.out.println("Client's contact numbers: " + clientContact);

              System.out.println("Client's email address: " + clientEmail);

              System.out.println("Outstanding amount: " + " R" + amountPayable);

              System.out.println("\nThank you for your continued support\n");

              System.out.println("Mark the project Finalised");

              /* create a finalised variable and initialise it by taking user input*/
              /* create a local date variable to take a date on which the project is finalised*/
              String finalised;
              LocalDate today = LocalDate.now();
              finalised = ("finalised on " + today);

              // create a prepared statement placeholder for user inputs to be inserted
              String inputs = "Insert into completedProjects values(?,?,?,?,?,?,?,?,?,?,?,?);";

              // declare a prepared statement connection to execute the input query
              PreparedStatement statements = connection.prepareStatement(inputs);

              //link the placeholders with the actual user inputs
              statements.setInt(1,results.getInt("ProjectNo"));
              statements.setString(2,results.getString("ClientName"));
              statements.setString(3,results.getString("ProjectName"));
              statements.setString(4,results.getString("ProjectErfNumber"));
              statements.setString(5,results.getString("ProjectType"));
              statements.setString(6,results.getString("ProjectAddress"));
              statements.setInt(7,results.getInt("ProjectCost"));
              statements.setInt(8,results.getInt("AmountPaid"));
              statements.setString(9,results.getString("ProjectDueDate"));
              statements.setString(10,results.getString("ArchitectName"));
              statements.setString(11,results.getString("ContractorName"));
              statements.setString(12,finalised);

            System.out.println("Project successfully finalised");

              statements.executeUpdate();
              statements.close();
              connection.close();
              break;
          }
          else {
              /* create a finalised variable and initialise it by taking user input*/
              /* create a local date variable to take a date on which the project is finalised*/
              String finalised;
              LocalDate today = LocalDate.now();
              finalised = ("finalised on " + today);

              // create a prepared statement placeholder for user inputs to be inserted
              String inputs = "Insert into completedProjects values(?,?,?,?,?,?,?,?,?,?,?,?);";

              // declare a prepared statement connection to execute the input query
              PreparedStatement statements = connection.prepareStatement(inputs);

              //link the placeholders with the actual user inputs
              statements.setInt(1,results.getInt("ProjectNo"));
              statements.setString(2,results.getString("ClientName"));
              statements.setString(3,results.getString("ProjectName"));
              statements.setString(4,results.getString("ProjectErfNumber"));
              statements.setString(5,results.getString("ProjectType"));
              statements.setString(6,results.getString("ProjectAddress"));
              statements.setInt(7,results.getInt("ProjectCost"));
              statements.setInt(8,results.getInt("AmountPaid"));
              statements.setString(9,results.getString("ProjectDueDate"));
              statements.setString(10,results.getString("ArchitectName"));
              statements.setString(11,results.getString("ContractorName"));
              statements.setString(12,finalised);

              System.out.println("Project successfully finalised");

              statements.executeUpdate();
              statements.close();
              connection.close();
               }
          break;
        }

    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void viewCompleted() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                "root", "Mysql@123");

            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("Select * from completedProjects");

            while (results.next()){
                System.out.println(results.getInt("ProjectNo") + "," + results.getString("ClientName") + "," +
                        results.getString("ProjectName") + "," + results.getString("ProjectErfNumber") + "," +
                        results.getString("ProjectType") + "," + results.getString("ProjectAddress") + "," +
                        results.getInt("ProjectCost") + "," + results.getInt("AmountPaid") + "," +
                        results.getString("ProjectDueDate") + "," + results.getString("ArchitectName") + "," +
                        results.getString("ContractorName") + "," + results.getString("ProjectStatus") + "\n");
            }

    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void dueProjects(){
        LocalDate today = LocalDate.now();
       try { Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                "root", "Mysql@123");
           
        Statement statement = connection.createStatement();
        
        ResultSet results = statement.executeQuery("select * from projects where ProjectDueDate <  now() and ProjectStatus = 'Active'");
        

        while(results.next()){  System.out.println(results.getInt("ProjectNo") + "," + results.getString("ClientName") + "," +
                results.getString("ProjectName") + "," + results.getString("ProjectErfNumber") + "," +
                results.getString("ProjectType") + "," + results.getString("ProjectAddress") + "," +
                results.getInt("ProjectCost") + "," + results.getInt("AmountPaid") + "," +
                results.getString("ProjectDueDate") + "," + results.getString("ArchitectName") + "," +
                results.getString("ContractorName") + "," + results.getString("ProjectStatus") + "\n");
        }
    } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }

    public static void viewIncomplete() {
        Scanner userI = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                    "root", "Mysql@123");

            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("select*from projects where ProjectStatus = 'Active'");

            while (results.next()) {
                System.out.println(results.getInt("ProjectNo") + "," + results.getString("ClientName") + "," +
                results.getString("ProjectName") + "," + results.getString("ProjectErfNumber") + "," +
                results.getString("ProjectType") + "," + results.getString("ProjectAddress") + "," +
                results.getInt("ProjectCost") + "," + results.getInt("AmountPaid") + "," +
                results.getString("ProjectDueDate") + "," + results.getString("ArchitectName") + "," +
                results.getString("ContractorName") + "," + results.getString("ProjectStatus") + "\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String [] args){
        Scanner userI = new Scanner(System.in);

      while (true) {
          System.out.println("\n" + "Welcome to Poise Project Management Page");

          System.out.println("\nEnter the corresponding words to action what you need to do, eg to view all projects enter view");

          System.out.println("\nNew Project: Register; View all projects: View; Edit project: Edit; New contractor: AddC;" +
            "New architect: Adda;\n" + "New client: AddCl;  View client info: ClientInfo; View architect info: ArchInfo;" +
            "Protects to complete: Incomplete; View contractor info: ContraInfo;\n" + "View overdue projects: Due;" +
            " Finalise with invoice: finalise; View completed: Completed ; Exit");

          System.out.println("\n   Enter your option  ");

          String options = userI.nextLine();
          /* based on the option entered, called a method displaying or computing that information*/

        if (options.equalsIgnoreCase("Register")){
            projectRegister();
            }

        if (options.equalsIgnoreCase("View")){
            viewall();
          }

        if (options.equalsIgnoreCase("edit")){
            projectEdit();
        }

        if (options.equalsIgnoreCase("AddCl")) {
            clientRegister();
        }

        if (options.equalsIgnoreCase("Adda")) {
            architectRegister();
        }

        if (options.equalsIgnoreCase("AddC")) {
            contractorRegister();
        }

        if (options.equalsIgnoreCase("ArchInfo")) {
            viewArchitect();
        }

        if (options.equalsIgnoreCase("ClientInfo")) {
            viewClient();
        }

        if (options.equalsIgnoreCase("ContraInfo")) {
            viewContractor();
        }

        if (options.equalsIgnoreCase("Finalise")) {
              finalise();
        }

        if (options.equalsIgnoreCase("Incomplete")){
            viewIncomplete();
        }

        if (options.equalsIgnoreCase("Completed")) {
            viewCompleted();
        }

        if(options.equalsIgnoreCase("Due")){
            dueProjects();
        }

        if (options.equalsIgnoreCase("Exit")){
            break;
                }

            }
    }
}


