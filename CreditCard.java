// Credit Card Lab by Brent Tokumi

public class CreditCard
{
  public boolean verify(String num)
  {
    int oddsTotal = 0;
    int evensTotal = 0;
    int cardTotal = 0;
    
    for ( int odds = num.length() - 1; odds >= 0; odds -= 2) // starts on the last number in the string and goes back every other, "odds" is the index its taking
    {
      int oddsTemp = Integer.parseInt(num.substring( odds , odds + 1 )); // parse changes the substring to an int
      oddsTotal += oddsTemp;
    }
    for ( int evens = num.length() - 2; evens >= 0; evens -= 2) // starts on the second to the last number in the string and goes back every other, "evens" is the index its taking
    {
      int evensStepOne = Integer.parseInt(num.substring( evens , evens + 1 ));
      int evensStepTwo = evensStepOne * 2;
      int evensTemp = 0;
      if (evensStepTwo >= 10)
      {
        evensTemp = 1 + evensStepTwo % 10;
      }
      else evensTemp = evensStepTwo;
      evensTotal += evensTemp;
    }
    
    cardTotal = oddsTotal + evensTotal;
    if (cardTotal % 10 == 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  private String[] Diners = {"36", "38", "301", "302", "303", "304", "305"}; 
  
  public int findType(String num) 
  {
    if (num.substring(0,2).equals("51") || num.substring(0,2).equals("52") || num.substring(0,2).equals("53") || num.substring(0,2).equals("54") || num.substring(0,2).equals("55")) return 1;
    else if (num.substring(0,1).equals("4")) return 2;
    else if (num.substring(0,2).equals("34") || num.substring(0,2).equals("37")) return 3;
    else if (num.substring(0,4).equals("6011")) return 4;
    else if (num.substring(0,2).equals("36") || num.substring(0,2).equals("38")) return 5;
    else if (num.substring(0,3).equals("301") || num.substring(0,3).equals("302") || num.substring(0,3).equals("303") || num.substring(0,3).equals("304") || num.substring(0,3).equals("305")) return 5;
    {
      for (String dinernumbers: Diners)
      {
        if (num.indexOf(dinernumbers) == 0 && num.length() == 14) return 5; // If the credit card number starts with any of the numbers defined in the array, return the index of a Diners card
      }
      return 0;
    }
  }
}    
                                       
  