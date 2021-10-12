package es.gosssan.assistant.domain;

public class Service {
	private int id;
	private String name;
	private double amount;

	public Service(int id, String name, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public double getAmount() { return amount; }
	public void setAmount(double amount) { this.amount = amount; }

	@Override
	public boolean equals(Object obj) {
        if (obj == this) return true;

        if (obj instanceof Service) {
	        Service service = (Service) obj;
	
	        return service.name.equals(name);
        }

        return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return String.format("Service [id=%s, name=%s, amount=%s]", id, name, amount);
	}

}