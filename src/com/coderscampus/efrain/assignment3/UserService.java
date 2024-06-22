package com.coderscampus.efrain.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	// List to hold User objects
	private List<User> users = new ArrayList<>();

	// Constructor to load users from file
	public UserService() {
		loadUsers();
	}

	// Method to read users from the file and populate the users list
	private void loadUsers() {
		try (BufferedReader FileReader = new BufferedReader(new FileReader("data.txt"))) {
			String line;
			while ((line = FileReader.readLine()) != null) {
				String[] parts = line.split(",");
				// purpose of 'if (parts.length == 3)' is to ensure that the line from the
				// file has been split into exactly three parts before attempting to create a
				// User object.
				if (parts.length == 3) {
					String username = parts[0];
					String password = parts[1];
					String name = parts[2];
					// Add new User to the list
					users.add(new User(username, password, name));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, that file could not be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Sorry, there was an I/O exception.");
			e.printStackTrace();
		}
	}

	public User validateLogin(String inputUsername, String inputPassword) {
		// Iterate over each user in the users list
		for (User user : users) {
			// Checks if the username and password inputs matches the username and password
			// information stored in the "data.txt" file provided by the user.
			if (user.getUsername().equalsIgnoreCase(inputUsername) && user.getPassword().equals(inputPassword)) {
				// If both match, return the matching User object
				return user;
			}
		}
		// If no match is found, return null
		return null;
	}
}
