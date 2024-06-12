package Java_Assignments.Java_Assignment2.Question3;

import javax.xml.bind.JAXB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BikeProgram {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Path settingsFile = Paths.get("./settings/settings.xml");

        if (Files.notExists(settingsFile)) {
            try (BufferedWriter output = Files.newBufferedWriter(settingsFile)) {
                Settings settings = new Settings();
                System.out.println("A settings file does not exist, creating file... \n");

                System.out.println("Please enter your name:");
                String uName = input.nextLine();

                System.out.println("Please enter your height:");
                String uHeight = input.nextLine();

                System.out.println("Please enter your weight:");
                String uWeight = input.nextLine();

                System.out.println("Please enter your birthday:");
                String uBirthday = input.nextLine();

                System.out.println("Please enter your Function Threshold Power:");
                String uFTP = input.nextLine();

                settings.setName(uName);
                settings.setHeight(uHeight);
                settings.setWeight(uWeight);
                settings.setBirthday(uBirthday);
                settings.setFunctionalThresholdPower(uFTP);

                JAXB.marshal(settings, output);

            } catch (IOException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        } else if (Files.exists(settingsFile)) {
            Scanner scanner = new Scanner(System.in);
            try (BufferedReader br = Files.newBufferedReader(settingsFile)) {
                Settings settings = JAXB.unmarshal(br, Settings.class);
                int option = -1;

                while (option != 0) {
                    System.out.println("Enter an option:");
                    System.out.println("1. View the settings.");
                    System.out.println("2. Edit the settings.");
                    System.out.println("3. Save the edited settings.");
                    System.out.println("0. Exit.");
                    option = scanner.nextInt();
                    scanner.nextLine();

                    switch (option) {
                        case 1:
                            System.out.printf("Settings for %s:\n", settings.getName());
                            System.out.printf("Height: %s\n", settings.getHeight());
                            System.out.printf("Weight: %s\n", settings.getWeight());
                            System.out.printf("Birthday: %s\n", settings.getBirthday());
                            System.out.printf("Functional Threshold Power: %s\n\n", settings.getFunctionalThresholdPower());
                            break;
                        case 2:
                            System.out.println("What setting would you like to update?");
                            System.out.println("1. Name");
                            System.out.println("2. Height");
                            System.out.println("3. Weight");
                            System.out.println("4. Birthday");
                            System.out.println("5. Functional Threshold Power");
                            System.out.println("6. Cancel");

                            int settingsEditOption = scanner.nextInt();
                            scanner.nextLine();

                            switch (settingsEditOption) {
                                case 1:
                                    System.out.println("What would you like to change the name to?");
                                    String newName = scanner.nextLine();
                                    settings.setName(newName);
                                    break;
                                case 2:
                                    System.out.println("What would you like to change the height to?");
                                    String newHeight = scanner.nextLine();
                                    settings.setHeight(newHeight);
                                    break;
                                case 3:
                                    System.out.println("What would you like to change the weight to?");
                                    String newWeight = scanner.nextLine();
                                    settings.setWeight(newWeight);
                                    break;
                                case 4:
                                    System.out.println("What would you like to change the birthday to?");
                                    String newBirthday = scanner.nextLine();
                                    settings.setBirthday(newBirthday);
                                    break;
                                case 5:
                                    System.out.println("What would you like to change the Functional Threshold Power to?");
                                    String newFTP = scanner.nextLine();
                                    settings.setFunctionalThresholdPower(newFTP);
                                    break;
                                case 6:
                                    System.out.println("Exiting without saving...");
                                    break;
                                default:
                                    System.out.println("Invalid option. Please try again.");
                            }
                            break;
                        case 3:
                            try (BufferedWriter output = Files.newBufferedWriter(settingsFile)) {
                                JAXB.marshal(settings, output);
                                System.out.println("Settings saved.");
                            } catch (IOException e) {
                                e.printStackTrace();
                                System.err.println(e.getMessage());
                            }
                        case 0:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
                scanner.close();
            }
        }
    }
}
