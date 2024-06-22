package com.coderscampus.efrain.assignment3;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		UserService userService = new UserService();
		Scanner scanner = new Scanner(System.in);
		int attempts = 0;
		final int MAX_ATTEMPTS = 5;

		while (attempts < MAX_ATTEMPTS) {
			System.out.println("Enter username: ");
			String username = scanner.nextLine();

			System.out.println("Enter password: ");
			String password = scanner.nextLine();

			User user = userService.validateLogin(username, password);

			if (user != null) {
				System.out.println("Welcome " + user.getName());
				break;
			} else {
				System.out.println("Invalid login, please try again.");
				attempts++; // Increment the attempts counter by 1
			}

			if (attempts == MAX_ATTEMPTS) {
				System.out.println("Too many failed login attempts, you are now locked out.");
			}
		}
	}
}
