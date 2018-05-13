public class cardClass
{
    private int num;		//holds card's value ex: 1-13
    private String cardPic;	//holds card's file name of picture ex: 2_of_clubs.png

    public cardClass(int value, String picture)	//call this to fill 
    {
        num = value;
        cardPic = picture;
    }
    public String getPic() {	//call this to get file name of pic ex: cardArray[card1].getPic() ->  2_of_clubs.png
    	return cardPic;
    }
    public int getValue() {		//call this to get value of card ex: cardArray[card1].getValue() ->  2
    	return num;
    }
}
