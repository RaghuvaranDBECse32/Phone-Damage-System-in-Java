import java.util.*;

public class PhoneDamageSystem {

    // Inner Class for Phone
    static class Phone {
        private String brand;
        private String model;
        private String damageType;
        private String timestamp;

        public Phone(String brand, String model, String damageType, String timestamp) {
            this.brand = brand;
            this.model = model;
            this.damageType = damageType;
            this.timestamp = timestamp;
        }

        public String getBrand() { return brand; }
        public String getModel() { return model; }
        public String getDamageType() { return damageType; }
        public String getTimestamp() { return timestamp; }

        public void setDamageType(String damageType) { this.damageType = damageType; }
        public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

        @Override
        public String toString() {
            return brand + " | " + model + " | " + damageType + " | " + timestamp;
        }
    }

    // List to store phone records
    private static ArrayList<Phone> phones = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Second Hand Phone Damage System ====");
            System.out.println("1. Add Phone Record");
            System.out.println("2. View All Records");
            System.out.println("3. Update Damage Type");
            System.out.println("4. Delete Record");
            System.out.println("5. Search By Brand/Model");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch(choice) {
                case 1:
                    addPhone(sc);
                    break;
                case 2:
                    viewPhones();
                    break;
                case 3:
                    updateDamage(sc);
                    break;
                case 4:
                    deletePhone(sc);
                    break;
                case 5:
                    searchPhone(sc);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addPhone(Scanner sc) {
        System.out.print("Enter Brand (e.g. ONEPLUS): ");
        String brand = sc.nextLine();
        System.out.print("Enter Model (e.g. Nord CE4 Lite): ");
        String model = sc.nextLine();
        System.out.print("Enter Damage Type (No Damage/Scratch/30% Damage): ");
        String damageType = sc.nextLine();
        System.out.print("Enter Timestamp: ");
        String timestamp = sc.nextLine();

        phones.add(new Phone(brand, model, damageType, timestamp));
        System.out.println("Phone added successfully.");
    }

    private static void viewPhones() {
        System.out.println("\n--- Phone Records ---");
        for (int i = 0; i < phones.size(); i++) {
            System.out.println((i+1) + ". " + phones.get(i));
        }
    }

    private static void updateDamage(Scanner sc) {
        viewPhones();
        System.out.print("Enter record number to update: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();
        if (idx < 0 || idx >= phones.size()) {
            System.out.println("Invalid record number.");
            return;
        }
        System.out.print("Enter new Damage Type: ");
        String newDamage = sc.nextLine();
        System.out.print("Enter new Timestamp: ");
        String newTime = sc.nextLine();

        phones.get(idx).setDamageType(newDamage);
        phones.get(idx).setTimestamp(newTime);
        System.out.println("Record updated.");
    }

    private static void deletePhone(Scanner sc) {
        viewPhones();
        System.out.print("Enter record number to delete: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();
        if (idx < 0 || idx >= phones.size()) {
            System.out.println("Invalid record number.");
            return;
        }
        phones.remove(idx);
        System.out.println("Record deleted.");
    }

    private static void searchPhone(Scanner sc) {
        System.out.print("Enter Brand or Model to Search: ");
        String query = sc.nextLine().toLowerCase();
        System.out.println("--- Search Results ---");
        for (Phone phone : phones) {
            if (phone.getBrand().toLowerCase().contains(query) ||
                phone.getModel().toLowerCase().contains(query)) {
                System.out.println(phone);
            }
        }
    }
}
