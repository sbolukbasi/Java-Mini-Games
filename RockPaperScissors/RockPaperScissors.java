import java.util.Scanner;
import java.util.Random;
public class RockPaperScissors {
    
    //Computer and player overall score tracking
    static int computerScore=0;
    static int playerScore=0;
    
    public static void main(String[] args) {
        
        System.out.println("------Rock,Paper,Scissors------");
        System.out.println("Welcome to game!");
        System.out.println("How to play: The player enters one of the options rock, paper, scissors into the console. ");
        System.out.println("             This is compared to the computer's choice, and a score is assigned.");
        System.out.println("             If the player and the computer give the same answer, neither side receives a score.");
        System.out.println("             The player will play 3 rounds against the computer.");
        System.out.println("Rule: Rock crushes Scissors, Paper covers Rock, Scissors cuts Paper.");
        
        Scanner input=new Scanner(System.in);
        Random random=new Random();
   
        String[] options={"rock", "paper", "scissors"};
        
        //Player enters their name
        System.out.print("Enter your nickname: ");
        String playerName=input.nextLine();
        
        //Game loop control
        boolean playAgain=false;
        
        do{
            //Number of tours available
            int currentRound=0;
            
            //Resets scores for the new game
            computerScore=0;
            playerScore=0;
            
            while(currentRound<3){
            
                //The computer randomly choose one
                int chosenIndex=random.nextInt(options.length);
                String computerChoice=options[chosenIndex];
            
                //The player enters their choice
                System.out.print("Enter your choice: ");
                String playerChoice=input.next();
            
                //Input control
                if (!isValid(playerChoice)) {
                System.out.println("Invalid choice! Please try again.");
                continue; //Returning to the beginning of the cycle without increasing the number of laps
                }
        
                //Calling method
                compareChoices(computerChoice, playerChoice);
                displayScore(playerName);
            
                currentRound++;
            }
            
            //Determines and prints the game winner
            if(computerScore>playerScore){
                System.out.println("Computer won!");
            }else if(playerScore>computerScore){
                System.out.println(playerName+" won!");
            }else{
                System.out.println("Scoreless!");
            }
            
            //Handles the play again prompt and user decision
            System.out.print("Do you want play again?(yes/no): ");
            String userAnswer=input.next();
            playAgain=userAnswer.equalsIgnoreCase("yes");
        
        }while(playAgain);
        
        System.out.println("Thanks for playing! See you next time.");
        
        input.close();
    }
    
    private static boolean isValid(String playerChoice) {
    //Invalid input status check
    return playerChoice.equalsIgnoreCase("rock") || playerChoice.equalsIgnoreCase("paper") || playerChoice.equalsIgnoreCase("scissors");
    }
    
    //Compares choices to update scores and displays computer's guess
    protected static void compareChoices(String computerChoice, String playerChoice){
        
        System.out.println("Computer choice: "+computerChoice);
        
        if(computerChoice.equalsIgnoreCase(playerChoice)){
            System.out.println("You chose the same thing.");
        }else{
            if(computerChoice.equals("rock") && playerChoice.equalsIgnoreCase("scissors")){
                computerScore++;
            }else if(computerChoice.equals("paper") && playerChoice.equalsIgnoreCase("rock")){
                computerScore++;
            }else if(computerChoice.equals("scissors") && playerChoice.equalsIgnoreCase("paper")){
                computerScore++;
            }else if(computerChoice.equals("scissors") && playerChoice.equalsIgnoreCase("rock")){
                playerScore++;
            }else if(computerChoice.equals("rock") && playerChoice.equalsIgnoreCase("paper")){
                playerScore++;
            }else if(computerChoice.equals("paper") && playerChoice.equalsIgnoreCase("scissors")){
                playerScore++;
            }
        }
    }
    
    private static void displayScore(String playerName){
        System.out.println("Computer   "+playerName);
        System.out.println("   "+computerScore+"         "+playerScore);
    }
}
