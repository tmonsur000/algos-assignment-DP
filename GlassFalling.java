/**
 * Glass Falling
 * Author: Tayeba Monsur
 */
public class GlassFalling {

  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) {
    //Base cases
    if(floors==1|| floors==0)
        return floors;
    
    if(sheets==1)
        return floors;
    
    int minIMUM= Integer.MAX_VALUE;
    int outPut;
    
    for(int i=1; i<=floors; i++){
        outPut=Math.max(glassFallingRecur(i-1, sheets-1),//case for when glass sheet breaks
                        glassFallingRecur(floors-i, sheets));//case for when glass sheets don't break
        if(outPut<minIMUM) minIMUM=outPut;
    }
    return minIMUM+1;
  }
  

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized(int floors, int sheets, int[][] memoIZE) {
    // Fill in here and change the return
    //checking the table for answer before the call
    //if theres an answer, return the answer
    
            if(memoIZE[floors][sheets]!=0){
                      return memoIZE[floors][sheets];
                }
    
    //base case if the floors are 0th or 1st floor
    //the number of glass sheets wont matter since we can only conduct at most 1 trials
             if(floors==1||floors==0){
                  memoIZE[floors][sheets]=floors;
                  return floors;
                }
    
    //if there is only 1 glass sheet # of trials at most=# of floors
    //in this case we also return the floor #
              if(sheets==1){
                    memoIZE[floors][sheets]=floors;
                    return floors;
                  }
              int ansWER= Integer.MAX_VALUE;
              int worstCase;
    
              for(int i=1; i<=floors; i++){
                      worstCase=Math.max(glassFallingMemoized(i-1, sheets-1, memoIZE),//for when glass sheet breaks
                                         glassFallingMemoized(floors-i, sheets, memoIZE);//for when glass sheet doesn't break
  
                      if(worstCase<ansWER)
                                ansWER=worstCase;
                    }
                int realSolution=ansWER+1;
                memoIZE[floors][sheets]=realSolution;
                return realSolution;
      }

  // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
    // Fill in here and change the return
    int glassBottom[][]=new int[sheets+1][floors+1];
    //check condition for 0 and 1 floors
    for(int i=1; i<sheets; i++){
      glassBottom[i][1]=1;
      glassBottom[i][0]=0;
    }
    //check condition for 1 glass sheet
    for(int j=1; j<floors; j++){
       glassBottom[1][j]=j;
    }
    //solve the remaining subproblems
    for(int k=2; k<=sheets;k++){
      for(int l=2; l<=floors; l++){
            glassBottom[k][l]= Integer.MAX_VALUE;
            
            int trIAL;
            for(int m=1; m<l; m++){
                trIAL=1+Math.max(glassBottom[k-1][m-1], 
                                 glassBottom[k][l-m]);
                                 glassBottom[k][l]=Math.min(trIAL, glassBottom[k][l]);
                             }
                       }
                }
    
      
    return glassBottom[sheets][floors];
  }


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();
      int [][] memoTRY= new int[100+1][3+1];

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Memo = gf.glassFallingMemoized(100, 3, memoTRY);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Memo + " " + minTrials2Bottom);
  }
}
