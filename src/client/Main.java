package client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import connection.DBConnection;

public class Main {

//    public static void instantiateJDBC() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//        } catch (InstantiationException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    public static void processCommand(DBConnection connection, String[] args) {
        if (args.length == 2) {
            // it must be check command
            if (args[1].equalsIgnoreCase("check")) {
                // TODO implement your logic here
            } else {
                System.out.println("Unexpected command!");
            }
        } else if (args.length == 3) {
            // it can be 'add products' or 'query'
            if (args[1].equalsIgnoreCase("add") && args[2].equalsIgnoreCase("products")) {
                // TODO implement your logic here
            } else if (args[1].equalsIgnoreCase("query")) {
                // TODO implement your logic here
            } else {
                System.out.println("Unexpected command!");
            }
        } else if (args.length == 4) {
            if (args[1].equalsIgnoreCase("add")) {
                if (args[2].equalsIgnoreCase("product")) {
                    // TODO implement your logic here
                } else if (args[2].equalsIgnoreCase("productkeyword")) {
                    // TODO implement your logic here
                } else if (args[2].equalsIgnoreCase("website")) {
                    // TODO implement your logic here
                } else if (args[2].equalsIgnoreCase("websitephone")) {
                    // TODO implement your logic here
                } else if (args[2].equalsIgnoreCase("externalsupplier")) {
                    // TODO implement your logic here
                } else if (args[2].equalsIgnoreCase("sell")) {
                    // TODO implement your logic here
                } else {
                    System.out.println("Unexpected command!");
                }

            } else if(args[1].equalsIgnoreCase("delete")) {
                if (args[2].equalsIgnoreCase("product")) {
                    // TODO implement your logic here
                } else if (args[2].equalsIgnoreCase("productkeyword")) {
                    // TODO implement your logic here
                } else if (args[2].equalsIgnoreCase("website")) {
                    // TODO implement your logic here
                } else if (args[2].equalsIgnoreCase("websitephone")) {
                    // TODO implement your logic here
                } else if (args[2].equalsIgnoreCase("externalsupplier")) {
                    // TODO implement your logic here
                } else if (args[2].equalsIgnoreCase("sell")) {
                    // TODO implement your logic here
                } else {
                    System.out.println("Unexpected command!");
                }

            } else {
                System.out.println("Unexpected command!");
            }

        } else {
            System.out.println("Unexpected command!");
        }
    }

    public static String readConfig() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/user/Desktop/startup_project/src/properties.conf"));
        try {
            String ip = reader.readLine();
            String port = reader.readLine();
            String username = reader.readLine();
            String password = reader.readLine();

            String url = String.format("jdbc:mysql://%s/%s?user=%s&password=%s",
                    ip, port, username, password);
            return url;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        DBConnection database_connection = null;

//        instantiateJDBC();

//        if(args.length < 2) {
//            System.err.println("Wrong number of arguments!");
//        }

        String url = readConfig();

        try {
            database_connection = new DBConnection(url);

            System.out.println("Connection established");

            processCommand(database_connection, args);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(database_connection != null){
                database_connection.close();
            }
        }

    }

}
