package ShowHand;
//import ShowHand.*;
import java.util.*;
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
	}
	
	/**
	 * Who's card is bigger, get the winner
	 */
	
  public void CardsComparison()
	{
    //each player cards'color give to playerCardsSplit1, number give to playerCardsSplit2
    ArrayList<String>[] playerCardsSplit1 = new ArrayList[PLAY_NUM];
    ArrayList<String>[] playerCardsSplit2 = new ArrayList[PLAY_NUM];
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
    
    //compare player cards numbers, firstly
    /**
    switch (int k = playerCardsSplit2.size()){
      case (k =1):
        //compare number only
      case (k=2):
        //see if double is there, otherwise compare number only
      case (k=3):
        //see if triple is there, then see if double exist, other wise compare # only
      case (k=4):
        // see if 4 same # is there, see if triple is there, then see if double exist, other wise compare # only
      case (k=5):
        //see if 5 consecutive # with same color is there, then see if 5 consecutive# is there,see if 4 same # is there, see if triple is there, 
        //then see if double exist, other wise compare # only
    }
    */
      
		//return cardNum;
	}
 
  /**
	public boolean DoubleNumber(ArrayList<int>[] al){
    return True;
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
		sh.CardsComparison();
		sh.showPlayerCards();
		/*
		*
		*/
		//
		//sh.deliverCard("player2");
		//sh.showPlayerCards();
		//sh.CardsComparison();
	}
}
