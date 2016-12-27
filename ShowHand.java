package ShowHand;
//import ShowHand.*;
import java.util.*;

import com.sun.prism.j2d.J2DPipeline;
/**
 * Description:
 * <br/> <a href="http://www.crazyit.org"> </a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ShowHand
{
	// define player#
	private final int PLAY_NUM = 5;
	// define cards type & values
	private String[] types = {"spade" , "heart" ,"club"  , "diamond"};
	private String[] values = {"2" , "3" , "4" , "5"
		, "6" , "7" , "8" , "9", "10"
		, "J" , "Q" , "K" , "A"};
	private int[] bidding = new int[PLAY_NUM];
	// define all cards
	private List<String> cards = new LinkedList<String>();
	// players
	private String[] players = new String[PLAY_NUM];
	// player's card
	private LinkedList<String>[] playersCards = new LinkedList[PLAY_NUM];
	/**
	 * initial cards
	 */
	public void initCards()
	{
		for (int i = 0 ; i < types.length ; i++ )
		{
			for (int j = 0; j < values.length ; j++ )
			{
				cards.add(types[i] + "-" + values[j]);
				//System.out.println("Initial Card is:"+cards);
			}
		}
		// shuffle cards
		Collections.shuffle(cards);
	}
	/**
	 * initial players
	 */
	public void initPlayer(String... names)
	{
		if (names.length > PLAY_NUM || names.length < 2)
		{
			System.out.println("Illegal players");
			return ;
		}
		else
		{
			for (int i = 0; i < names.length ; i++ )
			{
				players[i] = names[i];
				//initial bidding
				//System.out.println("inintial bidding# is:" + bidding[i]);
			}
		}
	}
	
	
	/**
	 * Initial player's cards
	 */
	public void initPlayerCards()
	{
		for (int i = 0; i < players.length ; i++ )
		{
			if (players[i] != null && !players[i].equals(""))
			{
				playersCards[i] = new LinkedList<String>();
			}
		}
	}
	/**
	 * Show all cards, for testing only
	 */
	public void showAllCards()
	{
		for (String card : cards )
		{
			System.out.println(card);
		}
		System.out.println("Cards # is:" + cards.size());
	}
	/**
	 * deliver card for specific/powerful player
	 */
	public void deliverCard(String first)
	{
		// get specific/powerful player's position
		int firstPos = ArrayUtils.search(players,first);
		System.out.println("target player's position is:" + firstPos);
		// deliver next card to this player and subsequent players
		for (int i = firstPos; i < PLAY_NUM ; i ++)
		{
			if (players[i] != null)
			{
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
		// delivery next card to players prior to this player
		for (int i = 0; i < firstPos ; i ++)
		{
			if (players[i] != null)
			{
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
	}
	/**
	 * show player's card, players shouldn't see each other's cards (hasn't impl)
	 */
	public void showPlayerCards()
	{
		for (int i = 0; i < PLAY_NUM ; i++ )
		{
			if (players[i] != null)
			{
				//
				System.out.print(players[i] + ":" );
				// 
				for (String card : playersCards[i])
				{
					System.out.print(card + "\t");
				}
			}
			System.out.print("\n");
			
		}
		System.out.println("Show Player Cards End...");
	}
	
	/**
	 * Who's card is bigger, get the winner
	 */
	
  public void CardsComparison()
	{
    //each player cards'color give to playerCardsSplit1, number give to playerCardsSplit2
    ArrayList<String>[] playerCardsSplit1 = new ArrayList[PLAY_NUM];
    ArrayList<String>[] playerCardsSplit2 = new ArrayList[PLAY_NUM];
    int ComparisonResultInt = 0;
    //initialize playerCardsSplit1&2
    
    
		for (int i = 0; i < players.length ; i++ ){
			if (players[i] != null){
					playerCardsSplit1[i] = new ArrayList<String>();
					playerCardsSplit2[i] = new ArrayList<String>();
					//System.out.println("playerCardsSplit1 initialized..." + playerCardsSplit1[i]);
					//System.out.println("playerCardsSplit2 initialized..." + playerCardsSplit2[i]);
      
					String[] tempGetEle = new String[PLAY_NUM];
					for (int j = 0; j < playersCards[i].size(); j++){
						tempGetEle[j] = playersCards[i].get(j);
						String[] cardsParts = tempGetEle[j].split("-");
						playerCardsSplit1[i].add(cardsParts[0]);
						playerCardsSplit2[i].add(cardsParts[1]);
					}
					System.out.println("Player-" +i +"-Colors:" + playerCardsSplit1[i]);
					System.out.println("Player-" +i +"-Numbers:" +playerCardsSplit2[i]);
      }
    }
		int k = 1;
		
    
    //compare player cards numbers, firstly

    switch (k){
      case (1):
      {
    	  //compare number only
    	  System.out.println("playerCardsSplit2[0] & [1]:" +playerCardsSplit2[0] +"and" + playerCardsSplit2[1]);
    	  System.out.println(playerCardsSplit2[0].get(0).compareTo("4"));
    	  ComparisonResultInt = OneNumber(playerCardsSplit2);
    	  System.out.println("Round One - bigger player is:" + ComparisonResultInt);
    	  break;
      }
          
      
    /**

      case (k=2):
        //see if double is there, otherwise compare number only
      case (k=3):
        //see if triple is there, then see if double exist, other wise compare # only
      case (k=4):
        // see if 4 same # is there, see if triple is there, then see if double exist, other wise compare # only
      case (k=5):
        //see if 5 consecutive # with same color is there, then see if 5 consecutive# is there,see if 4 same # is there, see if triple is there, 
        //then see if double exist, other wise compare # only
        */     
    }

      
		//return cardNum;
	}

  
    public int OneNumber(ArrayList<String>[] playerCardsInt){
    	String biggerTemp = new String();
    	int returnPlayerIndex = 0;
		for (int i = 0; i < players.length; i++){
			//player one and player two have same #
			//int testxx = playerCardsInt[i].get(0).compareTo(biggerTemp);
			//System.out.println("testxx:" +testxx +"and biggerTemp" +biggerTemp +"and" +playerCardsInt[i].get(0));
			if (players[i] != null && playerCardsInt[i].get(0).compareTo(biggerTemp) == 0){
				//CompareColor (i, i-1);
				//if equals, then compare color: "spade" , "heart" ,"club"  , "diamond"
				returnPlayerIndex = i;
				System.out.println("Round One - Bossy Player:" + i + "And i-1");
			}
			
			//current player got J-Q-K-A
			else if (playerCardsInt[i].contains("J") || playerCardsInt[i].contains("Q") || playerCardsInt[i].contains("K") || playerCardsInt[i].contains("A")){
				//current player bigger than last powerful player
				if (playerCardsInt[i].contains("A")){
					biggerTemp = playerCardsInt[i].get(0);
					returnPlayerIndex = i;
				}
				else if (playerCardsInt[i].contains("K") && biggerTemp.compareTo("A") != 0){
					biggerTemp = playerCardsInt[i].get(0);
					returnPlayerIndex = i;
				}
				else if (playerCardsInt[i].contains("Q") && (biggerTemp.compareTo("A") != 0 || biggerTemp.compareTo("K") != 0) ){
					biggerTemp = playerCardsInt[i].get(0);
					returnPlayerIndex = i;
				}
				else if (playerCardsInt[i].contains("J") && (biggerTemp.compareTo("A") != 0 || biggerTemp.compareTo("K") != 0 || biggerTemp.compareTo("Q") != 0)){
					biggerTemp = playerCardsInt[i].get(0);
					returnPlayerIndex = i;
				}	
			}
			
			//current player got 1-10
			else if (players[i] != null && playerCardsInt[i].get(0).compareTo(biggerTemp) > 0){
				//
				biggerTemp = playerCardsInt[i].get(0);
				System.out.println("Round One - Bossy Player:" + i + "current player got 1-10" +biggerTemp);
			}
			
		}
		System.out.println("biggerTemp value:" +biggerTemp +"-And return index:" +returnPlayerIndex);
		return returnPlayerIndex;
	
    }


    /**
	public boolean DoubleNumber(ArrayList<Integer>[] alInt, int arrayListSize){
		for (i = 0; i < PLAY_NUM; i++){
			if (alInt[i].get(0) >=
		}
		return true;
    }
    */

  
	public static void main(String[] args)
	{
		ShowHand sh = new ShowHand();
		sh.initPlayer("player1" , "player2");
		sh.initCards();
		sh.initPlayerCards();
		// 
		//sh.showAllCards();
		System.out.println("Start: ---------------");
		// 
		sh.deliverCard("player1");
		sh.showPlayerCards();
		sh.CardsComparison();
		/*
		*
		*/
		//
		//sh.deliverCard("player2");
		//sh.showPlayerCards();
		//sh.CardsComparison();
	}
}
