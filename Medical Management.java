import java.util.ArrayList;
import java.util.Scanner;
class Patient {
    private final int id;
    private final String name;
    private final int age;
    private final String contactInfo;
    public Patient(int id, String name, int age, String contactInfo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Contact Info: " + contactInfo;
    }
}
class Doctor {
    private final int id;
    private final String name;
    private final String specialization;
    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Doctor ID: " + id + ", Name: " + name + ", Specialization: " + specialization;
    }
}
class Appointment {
    private final int id;
    private final int patientId;
    private final int doctorId;
    public Appointment(int id, int patientId, int doctorId) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }
    @Override
    public String toString() {
        return "Appointment ID: " + id + ", Patient ID: " + patientId + ", Doctor ID: " + doctorId;
    }
}
public class MedicalManagementSystem {
    private static final ArrayList<Patient> patients = new ArrayList<>();
    private static final ArrayList<Doctor> doctors = new ArrayList<>();
    private static final ArrayList<Appointment> appointments = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Medical Management System ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Register Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> registerDoctor();
                case 3 -> scheduleAppointment();
                case 4 -> viewAppointments();
                case 5 -> {
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void registerPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();
        patients.add(new Patient(id, name, age, contactInfo));
        System.out.println("Patient registered successfully!");
    }
    private static void registerDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        doctors.add(new Doctor(id, name, specialization));
        System.out.println("Doctor registered successfully!");
    }
    private static void scheduleAppointment() {
        System.out.print("Enter Appointment ID: ");
        int id = scanner.nextInt();
        System.out.println("\nAvailable Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();

        System.out.println("\nAvailable Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        appointments.add(new Appointment(id, patientId, doctorId));
        System.out.println("Appointment scheduled successfully!");
    }
    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("\n=== Scheduled Appointments ===");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
}
