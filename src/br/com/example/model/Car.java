package br.com.example.model;

public class Car {
	
	private int id;
    private String name;
    private String model;
    private String plate;
    
    public Car() {
    }

    public Car(int id, String name, String model, String plate) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.plate = plate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    
}
