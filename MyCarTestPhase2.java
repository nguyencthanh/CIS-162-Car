import org.junit.*;
import java.text.*;
/****************************************************
 * MyCarTestPhase2 - to test the class Car Phase2
 *
 * @author  Ana Posada
 * @version February 2020
 ****************************************************/
public class MyCarTestPhase2 {
    /** gas tank capacity �� */
    private static final double TANK_CAPACITY = 12.5;

    /** miles in between oil change */
    private static final int MILES_BETWEEN_OIL_CHANGE = 5000;

    /******************************************************
     * Test default constructor - no input parameters
     *****************************************************/
    @Test
    public void testDefaultConstructor() {
        Car car = new Car();
        Assert.assertEquals("Car make should be ","Ford", 
            car.getMake());
        Assert.assertEquals("Car model should be ","Explorer", 
            car.getModel());
        Assert.assertEquals("Car year should be ",
            2020, car.getYear());
        Assert.assertEquals("Gas in tank should be",
            TANK_CAPACITY, car.checkGasGauge(), 0.1);
        Assert.assertEquals("Car MPG should be 29.0",
            29.0, car.getMpg(),0.1);
        Assert.assertEquals("Next oil change mileage",
            MILES_BETWEEN_OIL_CHANGE, car.getMileageNextOilChange (), 0.1);
    }

    /******************************************************
     * Test second constructor 
     *****************************************************/
    @Test
    public void testSecondConstructor() {
        Car car = new Car("Tesla", "Model 3", 2020, 148.0);
        Assert.assertEquals("Car make should be equal to value of input parameter ","Tesla", 
            car.getMake());
        Assert.assertEquals("Car model should be equal to value of input parameter","Model 3", 
            car.getModel());
        Assert.assertEquals("Car year should be equal to value of input parameter ",
            2020, car.getYear());
        Assert.assertEquals("Gas in tank should be",
            TANK_CAPACITY, car.checkGasGauge(), 0.1);
        Assert.assertEquals("Car MPG should be equal to value of input parameter",
            148.0, car.getMpg(),0.1);
        Assert.assertEquals("Next oil change mileage",
            MILES_BETWEEN_OIL_CHANGE, car.getMileageNextOilChange (), 0.1);
    }

    /******************************************************
     * Test setMake 
     *****************************************************/
    @Test
    public void testSetMake() {
        Car car = new Car("Tesla", "Model 3", 2020, 148.0);
        car.setMake("Mazda");
        Assert.assertEquals("Car make should be equal to value of input parameter ","Mazda", 
            car.getMake());
    }

    /******************************************************
     * Test setModel
     *****************************************************/
    @Test
    public void testSetModel() {
        Car car = new Car("Tesla", "Model-3", 2020, 148.0);
        car.setModel("Model S");
        Assert.assertEquals("Car model should be equal to value of input parameter","Model S", 
            car.getModel());
    }

    /******************************************************
     * Test setYear
     *****************************************************/
    @Test
    public void testSetYear() {
        Car car = new Car("Tesla", "Model-3", 2020, 148.0);
        car.setYear(2019);
        Assert.assertEquals("Car year should be equal to value of input parameter ",
            2019, car.getYear());
    }

    /******************************************************
     * Test setMpg
     *****************************************************/
    @Test
    public void testSetMpg() {
        Car car = new Car("Tesla", "Model-3", 2020, 148.0);
        car.setMpg(150.5);
        Assert.assertEquals("Car MPG should be equal to value of input parameter",
            150.5, car.getMpg(),0.1);
    }

    /******************************************************
     * Test addGas- negavite Value
     *****************************************************/
    @Test
    public void testAddGasNegativeVal() {
        Car car = new Car();
        car.addGas(-10);
        Assert.assertEquals("Gas in tank should not change" +
            " when trying to add gas with a negative value",
            TANK_CAPACITY, car.checkGasGauge(), 0.1);
    }

    /******************************************************
     * Test addGas - overflow
     *****************************************************/
    @Test
    public void testAddGasOverflow() {
        Car car = new Car();
        car.addGas(10);
        //trying to add gas when tank is full
        Assert.assertEquals("Gas in tank should not change" +
            " when trying to overflow the tank",
            TANK_CAPACITY, car.checkGasGauge(), 0.1);

        //trying to add more gas than the required to fill the tank
        car = new Car();
        car.drive(100);
        car.addGas(5.0);
        Assert.assertEquals("Gas in tank should be",
            TANK_CAPACITY , car.checkGasGauge(), 0.1);
    }

    /******************************************************
     * Test addGas - valid input parameter
     *****************************************************/
    @Test
    public void testAddGasOKVal() {
        Car car = new Car();
        car.drive(100);
        car.addGas(1);
        Assert.assertEquals("Gas in tank should be",
            10.05 , car.checkGasGauge(), 0.1);
    }

    /******************************************************
     * Test addGasIncrements 
     *****************************************************/
    @Test
    public void testAddGasOKIncrements() {
        Car car = new Car();
        car.drive(100);
        car.addGas(1.0);
        car.addGas(1.0);
        Assert.assertEquals("Gas in tank should be",
            11.05 , car.checkGasGauge(), 0.1);
    }

    /******************************************************
     * Test driveNegaviteVal
     *****************************************************/
    @Test
    public void testDriveNegativeVal() {
        Car car = new Car();
        car.drive(-50);
        Assert.assertEquals("Gas in tank should not change" +
            " when trying to drive negative miles",
            TANK_CAPACITY, car.checkGasGauge(), 0.1);

        Assert.assertEquals("Odometer should not change" +
            " when trying to drive negative miles",
            0.0, car.checkOdometer(), 0.1);

    }

    /******************************************************
     * Test driveOkVal
     *****************************************************/
    @Test
    public void testDriveOKVal() {
        Car car = new Car();
        car.drive(200);
        Assert.assertEquals("Problem with fomula to update the gas in tank" + 
            "- after driving, the gas in tank should decrement" ,
            5.60, car.checkGasGauge(), 0.1);

        Assert.assertEquals("Problem with fomula to update the odometer" + 
            "- after driving, the odometer should increment" ,
            200.0, car.checkOdometer(), 0.1);

    }

    /******************************************************
     * Test drive running out of gas
     *****************************************************/
    @Test
    public void testDriveRunningOutGas() {
        Car car = new Car();
        car.drive(1000);
        Assert.assertEquals("Problem with fomula to update the gas in tank" + 
            "- after running out of gas, the gas in tank should be" ,
            0.0, car.checkGasGauge(), 0.1);

        Assert.assertEquals("Problem with fomula to update the odometer" + 
            "- after running out of gas, the odometer should be" ,
            362.5, car.checkOdometer(), 0.1);

    }

    /******************************************************
     * Test drive - increments with valid input parameter
     *****************************************************/
    @Test
    public void testDriveOKValIncrements() {
        Car car = new Car();
        car.drive(50);
        car.drive(50);
        Assert.assertEquals("Problem with fomula to update the gas in tank" + 
            "- after driving the gas in tank should decrement" ,
            9.05, car.checkGasGauge(), 0.1);

        Assert.assertEquals("Problem with fomula to update the odometer" + 
            "- after driving the odometer should increment" ,
            100.0, car.checkOdometer(), 0.1);

    }

    /******************************************************
     * Test change oil
     *****************************************************/
    @Test
    public void testChangeOil() {
        Car car = new Car();
        car.changeOil();
        Assert.assertEquals("Mileage of next oil change shoul be " ,
            car.checkOdometer() + MILES_BETWEEN_OIL_CHANGE , car.getMileageNextOilChange (), 0.1);

    }

    /******************************************************
     * Test toString
     *****************************************************/
    @Test
    public void testToString() {
        Car car = new Car("Tesla", "Model 3", 2020, 148.0);
        DecimalFormat df = new DecimalFormat ("###,##0.00");
        
        Assert.assertTrue("Error formatting gas in tank" , 
        car.toString().contains (df.format(car.checkGasGauge ())));
        
        Assert.assertTrue("Error formatting odometer", 
        car.toString().contains (df.format(car.checkOdometer ())));
    }

    /******************************************************
     * Test equals
     *****************************************************/
    @Test
    public void testEquals() {
        Car car1 = new Car("Tesla", "Model 3", 2020, 148.0);
        Car car2 = new Car("Tesla", "Model 3", 2020, 148.0);
        Assert.assertTrue("Problems with the equal method" +
            " - the two cars have the same make, model and year", car1.equals(car2));

        car1 = new Car("Tesla", "Model S", 2020, 148.0);
        car2 = new Car("Tesla", "Model S", 2019, 148.0);
        Assert.assertFalse("Problems with the equal method" +
            " - the two cars do not have the same make, model and year", car1.equals(car2));  

        car1 = new Car("Tesla", "Model S", 2020, 148.0);
        car2 = new Car("Tesla", "Model 3", 2020, 148.0);
        Assert.assertFalse("Problems with the equal method" +
            " - the two cars do not have the same make, model and year", car1.equals(car2)); 

        car1 = new Car("Honda", "Civic", 2000, 148.0);
        car2 = new Car("Tesla", "Model 3", 2020, 148.0);
        Assert.assertFalse("Problems with the equal method" +
            " - the two cars do not have the same make, model and year", car1.equals(car2)); 

        car1 = new Car("Tesla", "Model 3", 2020, 148.0);
        car2 = new Car("Mazda", "Model 3", 2020, 148.0);
        Assert.assertFalse("Problems with the equal method" +
            " - the two cars do not have the same make, model and year", car1.equals(car2));

    }

}