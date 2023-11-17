import org.junit.*;
/****************************************************
 * MyCarTestPhase1 - to test the class Car Phase1
 *
 * @author  Ana Posada
 * @version February 2020
 ****************************************************/
public class MyCarTestPhase1 {
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
}