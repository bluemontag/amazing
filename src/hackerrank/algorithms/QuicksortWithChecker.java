package hackerrank.algorithms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

//Write your Checker class here
class Checker implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {

		int ageC = (-1)*(new Integer(o1.score).compareTo(new Integer(o2.score)));
		
		if (ageC==0) {
			return o1.name.compareTo(o2.name);
		} else {
			return ageC;
		}
	}
	
}

class QuicksortWithChecker {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}