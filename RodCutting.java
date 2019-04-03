/**
 * Rod cutting problem described in Chapter 15 of textbook
 *Author: Tayeba Monsur
 */
public class RodCutting {

  // Do not change the parameters!
  public int rodCuttingRecur(int rodLength, int[] lengthPrices) {
          
          //create an index array with rod length
          int[] memoIZE= new int[rodLength+1];
    
          for(int i=0; i<memoIZE.length; i++){
              memoIZE[i]=-1;
             }
           //call the memoized method for rodcutting
           return rodCuttingMemoized(rodLength, lengthPrices, memoIZE);
      }
          
  public int rodCuttingMemoized(int rodLength, int[] lengthPrices, int[] meMO){
    
        int maxIMUM=Integer.MIN_VALUE;
        
        if(meMO[rodLength]!=0)
            return meMO[rodLength];
        if(rodLength<=0)
            return 0;
        else{
            for(int i=0; i<rodLength; i++){
                  maxIMUM=Math.max(maxIMUM, lengthPrices[i]+rodCuttingMemoized(rodLength-i-1, lengthPrices, meMO));
            }
        }
      meMO[rodLength]=maxIMUM;
      return maxIMUM;
  }
    
    
  // Do not change the parameters!
  public int rodCuttingBottomUp(int rodLength, int[] lengthPrices) {
        int[] rodCuttingBottom= new int[rodLength+1];
        rodCuttingBottom[0]=0;
        for(int j=1; j<i;j++){
          maxIMUM=Math.max(maxIMUM, lengthPrices[j]+rodCuttingBottom[i-(j+1)]);
          rodCuttingBottom[i]=maxIMUM;
        }
      }
    return rodCuttingBottom[rodLength];
}

  public static void main(String args[]){
      RodCutting rc = new RodCutting();

      // In your turned in copy, do not touch the below lines of code.
      // Make sure below is your only output.
      int length1 = 7;
      int[] prices1 = {1, 4, 7, 3, 19, 5, 12};
      int length2 = 14;
      int[] prices2 = {2, 5, 1, 6, 11, 15, 17, 12, 13, 9, 10, 22, 18, 26};
      int maxSell1Recur = rc.rodCuttingRecur(length1, prices1);
      int maxSell1Bottom = rc.rodCuttingBottomUp(length1, prices1);
      int maxSell2Recur = rc.rodCuttingRecur(length2, prices2);
      int maxSell2Bottom = rc.rodCuttingBottomUp(length2, prices2);
      System.out.println(maxSell1Recur + " " + maxSell1Bottom);
      System.out.println(maxSell2Recur + " " + maxSell2Bottom);
  }
}
