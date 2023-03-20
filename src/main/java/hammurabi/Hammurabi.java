package hammurabi;               // package declaration
import java.util.Random;         // imports go here
import java.util.Scanner;

public class Hammurabi {         // must save in a file named Hammurabi.java
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);
    int price = 19;
    int population = 100;
    int immigrantsEntered = 5;
    int bushels = 2800;
    int bushelsHarvested = 3000;
    int bushelsDestroyed = 200;
    int acresOwned = 1000;
    int bushelsFedToPeople = 0;
    int howManyBushelsToPurchase = 0;
    int bushelsUsedAsSeed = 0;
    int newCostOfLand = 19;
    int year = 1;
    int starvedPeople = 0;
    int rats = 0;
    int acresPlanted = 0;
    boolean bought;

    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    public void playGame() {
        for (int i = 1; i<=10;i++) {
            year = i;
            // declare local variables here: grain, population, etc.
            // statements go after the declarations
            startOfYear();
            askHowManyAcresToPurchase();
            askHowManyAcresToSell();
            askHowMuchGrainToFeedPeople();
            askHowManyAcresToPlant();
        }

    }

    private void startOfYear() {
        System.out.println("O great Hammurabi!\n" +
                "You are in year " + year + " of your ten year rule.\n" +
                "In the previous year " + starvedPeople + " people starved to death.\n" +
                "In the previous year " + immigrantsEntered + " people entered the kingdom.\n" +
                "The population is now " + population + "\n" +
                "We harvested " + bushelsHarvested + " at 3 bushels per acre.\n" +
                "Rats destroyed " + bushelsDestroyed + " bushels, leaving " + bushels + " bushels in storage.\n" +
                "The city owns " + acresOwned + " acres of land.\n" +
                "Land is currently worth " + price + " bushels per acre.");
    }

    public int askHowManyAcresToPurchase(){
        System.out.println("How many acres would you like to purchase?");
        int total = Integer.parseInt(scanner.nextLine());
        if (total * price >bushels){
            System.out.println("O Great Hamurabi, surely you jest! we only have "+bushels+" left!");
        }else{
            System.out.println("As you command!");
            if (total == 0){
                bought = true;
            }
            bushels-= total * price;
        }
        return total;
    }

    public int askHowManyAcresToSell(){
        System.out.println("How many acres would you like to sell?");
        int total = Integer.parseInt(scanner.nextLine());
        if (total >= acresOwned){
            System.out.println("You mustn\'t sell all the land!");
        }else{
            System.out.println("As you command!");
            bushels += total * newCostOfLand;
        }while (true)
        return total;
    }

    public int askHowMuchGrainToFeedPeople(){
        System.out.println("How much grain would you like to feed the people?");
        int total = Integer.parseInt(scanner.nextLine());
        if (total>bushels){
            System.out.println("O Great Hamurabi, surely you jest! we only have "+bushels+" left!");
        }else {
            System.out.println("As you command!");
        }
        return total;
    }

    public int askHowManyAcresToPlant(){
        System.out.println("How many acres would you like to plant?");
        int total = Integer.parseInt(scanner.nextLine());
        if (total > bushels){
            System.out.println("There isn\'t enough to plant.");
        }else if (total>acresOwned){
            System.out.println("We do not have that much land as of now.");
        }else if (total > population * 10){
            System.out.println("There is not enough manpower for this.");
        }else{
            System.out.println("As you command!");
        }
        return total;
    }

    public int plagueDeaths() {
        if (rand.nextInt(100) <= 14) {
            System.out.println("A plague has hit thy land");
            return population / 2;
        }
        return 0;
    }

    public int starvationDeaths(){
        if (population *20 <=bushelsFedToPeople){
            System.out.println("The people will be pleased.");
            return 0;
        }else{
            System.out.println("The people are starving.");
            return population - bushelsFedToPeople/20;
        }
    }

    public boolean uprising(){
        return  starvedPeople/ population > .45;
    }

    public int immigrants(){
        int total = (20 * acresOwned + bushels)/(100 * population) +1;
        System.out.println(total + " people have moved into your city.");

        return total;
    }


}


    //other methods go here
