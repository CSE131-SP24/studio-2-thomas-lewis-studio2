package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Start Amount?");
		double startAmount = in.nextDouble();
		System.out.println("Win Chance?");
		double winChance = in.nextDouble();
		System.out.println("Win Limit?");
		double winLimit = in.nextDouble();
		System.out.println("Total Simulations?");
		int totalSimulations = in.nextInt();
		boolean stop = false;
		int Simulations = 0;
		int WinNum = 0;
		double RuinNum = 0;
		double Expected = 0;
		while (Simulations < totalSimulations)
		{
		int plays = 0;
		double Current = startAmount;
			while (stop == false)
			{
				double RanNum = Math.random();
		
				if (RanNum < winChance)
				{
				Current++;
				}
				else
				{
				Current--;
				}
				
				if (Current == winLimit)
				{
				stop = true;
				System.out.println("Day " + (Simulations+1) + " Win!");
				System.out.println("Plays:" + plays+1);
				WinNum++;
				}
				else if (Current <= 0)
				{
				stop = true; 
				System.out.println("Day " + (Simulations+1) + " Ruin. :(");
				RuinNum++;
				System.out.println("Plays:" + plays+1);
				}
			plays++;
			}
			
			stop = false;
			
		Simulations++;	
		
		}
		
		double Rate = (RuinNum / totalSimulations);
		System.out.println("Wins:" + WinNum);
		System.out.println("Losses:" + RuinNum);
		System.out.println("Simulations:" + totalSimulations);
		System.out.println("Ruin Rate: " + Rate);
		if (winChance == 0.5)
				{
			Expected = (1-(startAmount/winLimit));
				}
		else
			{
			double a = (1-winChance)/winChance;
			Expected = ((Math.pow(a, startAmount))-(Math.pow(a, winLimit)))/(1-(Math.pow(a, winLimit)));
			}
		System.out.println("Expected Ruin Rate: " + Expected);
		double money = (WinNum*winLimit) - (Simulations*startAmount);
		System.out.println("Money Made/Lost: " + money);

	}

}
