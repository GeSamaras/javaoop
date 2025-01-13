abstract class Vehicle {
	private String name;
	private int speed;
	abstract void move();
}

class Car extends Vehicle implements Repairable{
	private String fuelType;
	public void refuel() {
		System.out.println("refueled");
	}

	public void repair() {
		System.out.println("car's been repaired");
	}

	void move() {
		
	}
}


interface Repairable {
	void repair();
}