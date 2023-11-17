
/**
 * Write a description of class MyCarTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyCarTest
{
    public static void main(String [] args){
        //Testing Car for the equal method
        Car testCar0 = new Car("Lexus", "ES 350", 2019, 20.0); 
        Car testCar1 = new Car("Jeep", "Wrangler", 2017, 13.0);
        Car testCar2 = new Car("Honda", "Wrangler", 2017, 13.0);
        Car testCar3 = new Car("Jeep", "Passport", 2017, 13.0);
        Car testCar4 = new Car("Jeep", "Wrangler", 2020, 13.0);
        /*Testing Car 1*/
        Car yourCar = new Car("Jeep", "Wrangler", 2017, 13.0);

        System.out.println("\n**Testing - Get make of car");
        System.out.println("Make: " + yourCar.getMake());

        System.out.println("\n**Testing - Get model of car");
        System.out.println("Model: " + yourCar.getModel());

        System.out.println("\n**Testing - Get year of car");
        System.out.println("Year: " + yourCar.getYear());

        System.out.println("\n**Testing - Get mpg of car");
        System.out.println("Mpg: " + yourCar.getMpg());

        System.out.println("\n**Testing - Use horn of car");
        yourCar.honkHorn();

        System.out.println("\n**Testing - Driving until out of gas with engine off"); 
        yourCar.drive(200);

        System.out.println("\n**Testing - Driving without running out of gas with engine off");
        yourCar.drive(30);

        System.out.println("\n**Testing - Driving until out of gas with engine on"); 
        yourCar.startEngine();
        yourCar.drive(300);

        System.out.println("\n**Testing - Driving without running out of gas with engine on");
        yourCar.startEngine();
        yourCar.drive(20);

        System.out.println("\n**Testing - Driving negative miles");
        yourCar.startEngine();
        yourCar.drive(-3);

        System.out.println("\n**Testing - Driving negative miles with engine off");
        yourCar.drive(-3); 

        System.out.println("\n**Testing - Overflowing tank with gas with engine off");
        yourCar.startEngine();
        yourCar.drive(20);
        yourCar.stopEngine();
        yourCar.addGas(200);

        System.out.println("\n**Testing - Adding gas to tank with engine off");
        yourCar.startEngine();
        yourCar.drive(20);
        yourCar.stopEngine();
        yourCar.addGas(1.0);

        System.out.println();

        System.out.println("\n**Testing - Overflowing tank with gas with engine off");
        yourCar.startEngine();
        yourCar.drive(20);
        yourCar.startEngine();
        yourCar.addGas(100);

        System.out.println("\n**Testing - Adding gas to tank with engine off");
        yourCar.startEngine();
        yourCar.drive(20);
        yourCar.startEngine();
        yourCar.addGas(1.0);

        System.out.println("\n**Testing - Adding negative gas");
        yourCar.stopEngine();
        yourCar.addGas(-2);

        System.out.println("\n**Testing - Checking Oil with engine on");
        yourCar.startEngine();
        yourCar.checkOil();

        System.out.println("\n**Testing - Checking Oil with engine off");
        yourCar.stopEngine();
        yourCar.checkOil();

        System.out.println("\n**Testing - Change Oil with engine off");
        yourCar.stopEngine();
        yourCar.changeOil();

        System.out.println("\n**Testing - Change Oil with engine on");
        yourCar.startEngine();
        yourCar.changeOil();

        System.out.println("\n**Testing - ToString");
        System.out.println(yourCar.toString());

        System.out.println("\n**Testing - Two cars are equal");
        System.out.println(yourCar.equals(testCar1));

        System.out.println("\n**Testing - Two make are not equal");
        System.out.println(yourCar.equals(testCar2));

        System.out.println("\n**Testing - Two model are not equal");
        System.out.println(yourCar.equals(testCar3));

        System.out.println("\n**Testing - Two year are not equal");
        System.out.println(yourCar.equals(testCar4));

        System.out.println("\n**Testing - Driving multiple cities");
        yourCar.simulateMultiCityTrip(3);

        System.out.println();

        System.out.println("\n**Testing - Starting engine");
        yourCar.startEngine();

        System.out.println("\n**Testing - Stopping engine");
        yourCar.stopEngine();

        /*Testing Car 2*/
        Car yourCar2 = new Car("Lexus", "ES 350", 2019, 20.0);

        System.out.println("\n**Testing - Get make of car");
        System.out.println("Make: " + yourCar2.getMake());

        System.out.println("\n**Testing - Get model of car");
        System.out.println("Model: " + yourCar2.getModel());

        System.out.println("\n**Testing - Get year of car");
        System.out.println("Year: " + yourCar2.getYear());

        System.out.println("\n**Testing - Get mpg of car");
        System.out.println("Mpg: " + yourCar2.getMpg());

        System.out.println("\n**Testing - Use horn of car");
        yourCar2.honkHorn();

        System.out.println("\n**Testing - Driving until out of gas with engine off"); 
        yourCar2.drive(200);

        System.out.println("\n**Testing - Driving without running out of gas with engine off");
        yourCar2.drive(30);

        System.out.println("\n**Testing - Driving until out of gas with engine on"); 
        yourCar2.startEngine();
        yourCar2.drive(300);

        System.out.println("\n**Testing - Driving without running out of gas with engine on");
        yourCar2.startEngine();
        yourCar2.drive(20);

        System.out.println("\n**Testing - Driving negative miles");
        yourCar2.startEngine();
        yourCar2.drive(-3);

        System.out.println("\n**Testing - Driving negative miles with engine off");
        yourCar2.drive(-3); 

        System.out.println("\n**Testing - Overflowing tank with gas with engine off");
        yourCar2.startEngine();
        yourCar2.drive(20);
        yourCar2.stopEngine();
        yourCar2.addGas(200);

        System.out.println("\n**Testing - Adding gas to tank with engine off");
        yourCar2.startEngine();
        yourCar2.drive(20);
        yourCar2.stopEngine();
        yourCar2.addGas(1.0);

        System.out.println();

        System.out.println("\n**Testing - Overflowing tank with gas with engine off");
        yourCar2.startEngine();
        yourCar2.drive(20);
        yourCar2.startEngine();
        yourCar2.addGas(100);

        System.out.println("\n**Testing - Adding gas to tank with engine off");
        yourCar2.startEngine();
        yourCar2.drive(20);
        yourCar2.startEngine();
        yourCar2.addGas(1.0);

        System.out.println("\n**Testing - Adding negative gas");
        yourCar2.stopEngine();
        yourCar2.addGas(-2);

        System.out.println("\n**Testing - Checking Oil with engine on");
        yourCar2.startEngine();
        yourCar2.checkOil();

        System.out.println("\n**Testing - Checking Oil with engine off");
        yourCar2.stopEngine();
        yourCar2.checkOil();

        System.out.println("\n**Testing - Change Oil with engine off");
        yourCar2.stopEngine();
        yourCar2.changeOil();

        System.out.println("\n**Testing - Change Oil with engine on");
        yourCar2.startEngine();
        yourCar2.changeOil();

        System.out.println("\n**Testing - ToString");
        System.out.println(yourCar2.toString());

        System.out.println("\n**Testing - Two cars are equal");
        System.out.println(yourCar2.equals(testCar1));

        System.out.println("\n**Testing - Two make are not equal");
        System.out.println(yourCar2.equals(testCar2));

        System.out.println("\n**Testing - Two model are not equal");
        System.out.println(yourCar2.equals(testCar3));

        System.out.println("\n**Testing - Two year are not equal");
        System.out.println(yourCar2.equals(testCar4));

        System.out.println("\n**Testing - Driving multiple cities");
        yourCar2.simulateMultiCityTrip(3);

        System.out.println();

        System.out.println("\n**Testing - Starting engine");
        yourCar2.startEngine();

        System.out.println("\n**Testing - Stopping engine");
        yourCar2.stopEngine();
        }
        }
