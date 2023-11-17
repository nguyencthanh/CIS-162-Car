import java.text.DecimalFormat;
import java.util.Random;

public class Car
{
    // instance variables - replace the example below with your own
    private String make;
    private String model;
    private int year;
    private double mpg;
    private double odometer;
    private double nextOilChange;
    private double gas;
    private static final double TANK_CAPACITY = 12.5;
    private static final int MILES_BETWEEN_OIL_CHANGE = 5000;
    private static DecimalFormat df = new DecimalFormat("###,##0.00");
    private boolean engineOn = false;
    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        // initialise instance variables
        make = "Ford";
        model = "Explorer";
        year = 2020;
        mpg = 29.0;
        gas = TANK_CAPACITY;
        odometer = 0.0;
        nextOilChange = MILES_BETWEEN_OIL_CHANGE;
    }

    public Car (String make, String model, int y, double mpg) {
        this.make = make;
        this.model = model;
        this.year = y;
        this.mpg = mpg;
        this.gas = TANK_CAPACITY;
        this.odometer = 0.0;
        this.nextOilChange = MILES_BETWEEN_OIL_CHANGE;
    }

    public String getMake (){
        return make;
    }

    public String getModel (){
        return model;
    }

    public double getMpg ( ){
        return mpg;
    }

    public int getYear(){
        return year;
    }

    public double getMileageNextOilChange ( ){
        return nextOilChange;
    }

    public double checkOdometer ( ){
        return odometer;
    }

    public double checkGasGauge ( ){
        return gas;
    }

    public void setMake (String make){
        this.make = make;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public void setMpg (double value) {
        this.mpg = value;
    }

    public void setYear (int y) {
        this.year = y; 
    }

    public void honkHorn ( ) {
        System.out.println("honk honk");
    }

    public void addGas (double gallons){
        if (isEngineOn() == false) {
            if (gallons > 0){
                if(isGasSpilling(gallons)){
                    gas = TANK_CAPACITY;
                    System.out.printf("%s %s %d tank overflowed - ",
                        make, model, year);
                    System.out.println("Gas in Tank after the fill up: " +
                        df.format(gas));
                }
                else{
                    gas += gallons;
                    System.out.printf("%s %s %d added gas: %.2f ",
                        make, model, year, gallons);
                }
            }
            else {
                System.out.printf("%s %s %d gallons cannot be a negative number - ",
                    make, model, year);
                System.out.println("Gas in Tank after the fill up: " +
                    df.format(gas));
            }
        } 
        else {
            System.out.println(make + " " + model + " " + year + " must be OFF to add gas.");  
        }
    }

    private boolean isGasSpilling(double gallons){
        boolean isGasSpilling = false; 
        double gasNeededToFill = calcGasNeededToFillTank();
        if(gallons > gasNeededToFill){
            isGasSpilling = true;
        }
        return isGasSpilling;
    }

    private double calcGasNeededToFillTank(){
        return TANK_CAPACITY - gas;
    }

    private double calcRange(){
        return gas * mpg;
    }

    public void drive (double miles){
        if (isEngineOn()){
            if(miles > 0){
                double range = gas * mpg;
                if(miles > calcRange()) {
                    gas = 0;
                    odometer += range;
                    System.out.println(make + " " + model + " " +year + 
                        " ran out of gas after driving " + miles + " miles");
                    engineOn = false;

                }
                else{
                    odometer += miles;
                    System.out.println(make + " " + model + " " + year + 
                        " drove " + miles + " miles");
                    gas -= miles / mpg;
                }
            }
            else {
                System.out.println(make + " " + model + " " + year + 
                    " cannot drive negative miles");
            }
        }else {
            System.out.println(make + " " + model + " " + year + " must be ON to drive.");   
        }
    }

    public void changeOil(){
        if(isEngineOn() == false ){
            double oilChangeReminder = odometer + 
                MILES_BETWEEN_OIL_CHANGE;
            System.out.println(make + " " + model + " " + year + 
                " oil change, next mileage to change oil is: " + 
                oilChangeReminder);
        }
        else {
            System.out.println(make + " " + model + " " + year + " must be OFF to change the oil."); 
        }
    }

    public void checkOil(){
        if (isEngineOn() == false){
            double isOilNeeded = odometer + 
                MILES_BETWEEN_OIL_CHANGE;
            if(odometer < isOilNeeded){
                System.out.println(make + " " + model + " " + year + 
                    " Oil is OK, no need to change.");
            }
            else{
                System.out.println(make + " " + model + " " + year + 
                    " It is time to change the oil."); 
            }
        }
        else {
            System.out.println(make + " " + model + " " + year + " must be OFF to check oil.");
        }
    }

    public String toString() {
        String carString = make + " " + model + " " + year + " Odometer: " + df.format(odometer)
            + " Gas in Tank: " + df.format(gas);
        return carString;
    }

    public boolean equals (Car other){
        if(make == other.make && model == other.model && 
        year == other.year){
            return true;
        }
        else{
            return false;
        }
    }

    public void startEngine(){
        engineOn = true;
        System.out.println(make + " " + model + " " + year + 
            " - engine started.");
    }

    public void stopEngine(){
        engineOn = false;
        System.out.println(make + " " + model + " " + year + 
            " - engine stopped.");
    }

    public boolean isEngineOn(){
        if(engineOn) {
            return true;
        }
        else{
            return false;
        }
    }

    public void simulateMultiCityTrip(int numberCities){
        Random r = new Random();
        for (int i = 1; i <= numberCities; i++){
            startEngine();
            int maxRange = (int)calcRange();
            drive( r.nextInt(maxRange) + 1);
            stopEngine();
            addGas(calcGasNeededToFillTank());
        }
    }
}