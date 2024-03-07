package com.rays.instance;

public class ServiceLocator {

	private static ServiceLocator instance;

	private ServiceLocator() {
	}

	public static ServiceLocator getInstance() {

		if (instance == null) {

			instance = new ServiceLocator();
			System.out.println("Service Locator");
		}
		return instance;
	}

}
