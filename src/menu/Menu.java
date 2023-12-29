package menu;
import dao.InsuranceServiceImpl;
import entity.Policy;
import theExceptions.PolicyNotFoundException;


import java.util.Scanner;

@SuppressWarnings("unused")
public class Menu {

    private static final InsuranceServiceImpl insuranceService = new InsuranceServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createPolicy();
                    break;
                case 2:
                    getPolicy();
                    break;
                case 3:
                    getAllPolicies();
                    break;
                case 4:
                    updatePolicy();
                    break;
                case 5:
                    deletePolicy();
                    break;
                case 6:
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }

        } while (choice != 6);
    }

    private static void displayMenu() {
        System.out.println("===== Insurance Management System Menu =====");
        System.out.println("1. Create Policy");
        System.out.println("2. Get Policy");
        System.out.println("3. Get All Policies");
        System.out.println("4. Update Policy");
        System.out.println("5. Delete Policy");
        System.out.println("6. Exit");
    }

    private static void createPolicy() {
        // Implement the logic to create a new policy
        System.out.println("Creating a new policy...");

        // Example: Getting input from the user
        System.out.print("Enter policy Id: ");
        int policyId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter policy name: ");
        String policyName = scanner.nextLine();
        System.out.print("Enter policy type: ");
        String policyType = scanner.nextLine();
        System.out.print("Enter coverage amount: ");
        double coverageAmount = scanner.nextDouble();

        Policy newPolicy = new Policy(policyId, policyName, policyType, coverageAmount);

        // Example: Calling the createPolicy method from the service
        boolean success = insuranceService.createPolicy(newPolicy);

        if (success) {
            System.out.println("Policy created successfully.");
        } else {
            System.out.println("Failed to create policy. Please try again.");
        }
    }

    private static void getPolicy()  {
        // Implement the logic to get a policy by policyId
        System.out.println("Getting a policy...");

        // Example: Getting input from the user
        System.out.print("Enter policy ID: ");
        int policyId = scanner.nextInt();

        // Example: Calling the getPolicy method from the service
		Policy policy = insuranceService.getPolicy(policyId);
		System.out.println("Policy details:\n" + policy);
    }

    private static void getAllPolicies() {
        // Implement the logic to get all policies
        System.out.println("Getting all policies...");

        // Example: Calling the getAllPolicies method from the service
        insuranceService.getAllPolicies().forEach(policy -> System.out.println(policy));
    }

    private static void updatePolicy() {
        // Implement the logic to update an existing policy
    	getAllPolicies();
        System.out.println("Updating a policy...");

        // Example: Getting input from the user
        System.out.print("Enter policy ID to update: ");
        int policyId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter new policy name: ");
        String newPolicyName = scanner.nextLine();
        System.out.print("Enter new policy type: ");
        String newPolicyType = scanner.nextLine();
        System.out.print("Enter new coverage amount: ");
        double newCoverageAmount = scanner.nextDouble();

        Policy updatedPolicy = new Policy(policyId, newPolicyName, newPolicyType, newCoverageAmount);

        // Example: Calling the updatePolicy method from the service
        boolean success = insuranceService.updatePolicy(updatedPolicy);

        if (success) {
            System.out.println("Policy updated successfully.");
        } 
      }

    private static void deletePolicy() {
        // Implement the logic to delete an existing policy
        System.out.println("Deleting a policy...");

        // Example: Getting input from the user
        System.out.print("Enter policy ID to delete: ");
        int policyId = scanner.nextInt();

        // Example: Calling the deletePolicy method from the service
        boolean success = insuranceService.deletePolicy(policyId);

        if (success) {
            System.out.println("Policy deleted successfully.");
        } 
    }
}