import java.io.*;
import java.util.*;

class Player{
	
	int guessNum;
	
	public int guessNumber(int num){
		
		System.out.println("Player"+num+",please guess the number:");
		Scanner sc=new Scanner(System.in);
		
		guessNum=sc.nextInt();
		
		int chances=3;
		while(chances!=0) {
		if(guessNum>9 || guessNum<1) {
			System.out.println("Player"+num+",please guess the number between 1 to 9:(you have only "+chances+" chances remaining)");
			guessNum=sc.nextInt();
			chances--;
			if(chances==0)
				System.out.println("Player"+num+" is OUT of the game'-'");
		}
		
		else 
			break;
		
		}
		return guessNum;
	}	
}
class Guesser{
	
	int guessNum;
	
	public int guessNumber(){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Guesser, please guess the number:");
		
		guessNum=sc.nextInt();
		
		while(guessNum>9||guessNum<1) {
			
			System.out.println("Guesser, please guess the number with in 1 to 9:");
			
			guessNum=sc.nextInt();
			
		}
		return guessNum;
		
	}	
}
class Umpire{
	
	int numfromGusser;
	int numofPlayers;
	
	
	int[] Players;
	int[] winners;
	
	
	
	Umpire(int num){
		
		this.numofPlayers=num;
		Players=new int[numofPlayers];
		winners=new int[numofPlayers];
	}
	
	
	public void CollectNumFromGuesser() {
		
		Guesser g=new Guesser();
		numfromGusser=g.guessNumber();
	}
	
	public void CollectNumFromPlayer() {
		
		 Player[] player=new Player[numofPlayers];
		 
		 for(int i=0;i<numofPlayers;i++) {
			 player[i]=new Player();
			 int number= player[i].guessNumber(i+1);
			 
			 Players[i]=number;
		
		 }
		 	
	}
	
  public void compare() {
	  int j=0;
	  for(int i=0;i<Players.length;i++) {
		  if(Players[i]==numfromGusser) {
			  
			  winners[j]=i+1;
			  j++;
		  }
	  }
	  if(j==0) {
		  System.out.println("Sorry! No one has won the game :( \nPlease play again :)");
		  
	  }
	  else if(j==1) {
		  
		  System.out.println("Winner of the Game is:\nPlayer"+winners[0]);
		  
	  }
	  else {
		  
	  System.out.println("Winners of the Game are:");
	  
	  for(int k=0;k<j;k++ ) {
		  System.out.println("Player"+winners[k]);
	  }
	  
	  }
	  Game g=new Game();
	  g.playAgain();
  }
  

}

class Game{
	
	public void PlayGame() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of players playing game:");
		int numofPlayers=sc.nextInt();
		
		if(numofPlayers==0) {
			System.out.println("Sorry! You can't play the game \natleast One Player nedded to start game");
			Game g=new Game();
			  g.playAgain();
			  }
		else {
		Umpire ump=new Umpire(numofPlayers);
		
		ump.CollectNumFromGuesser();
		ump.CollectNumFromPlayer();
		ump.compare();
		}
	}
	
	public void playAgain() {
		  System.out.println("Do you want to play Game again.if yes,please type Y else N ");
		  Scanner sc=new Scanner(System.in);
		  String response=sc.next();
		  if(response.equals("Y")){
			  Game g=new Game();
		  	  g.PlayGame();
		  }
		  else if(response.equals("N")) {
			  
			  System.out.println("This is end of the Game,Thanks for Playing!");
		  }
		  else {
			  System.out.println("Invalid Response");
			  Game g=new Game();
			  g.playAgain();
		  }
		
	}
	
}

public class LaunchGame {
	
	public static void main(String args[]){
		
		Game game=new Game();
		game.PlayGame();
		
		
	}

}
