
import java.util.List;
import java.util.ArrayList;
class Solution {



	public static void main(String args[]){

		int[] candidates = {10,1,2,7,6,1,5}; 
		int target = 8;

		List<List<Integer>> ans = combinationSum2(candidates , target);	
		printArr(ans);
	}

	static void printArr(List<List<Integer>> ans){
		System.out.println("printArr");
		for(int i = 0 ; i < ans.size() ; i++){
			System.out.print(ans.get(i).toString() + " ");
			System.out.println(i);
		}
		System.out.println("\n");
	}
	

   static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		solve(candidates , target , 0 , 0 , new ArrayList<Integer>() , ans );

		return ans;
    }
    
    //cn -> current number
    
    static public void solve(int[] candidates , int target , int index , int sum , List<Integer> ans , List<List<Integer>> finalAns ){
    
        if(index == candidates.length){
            if(sum == target){


            }
			return;
        }
        
        //not include
        solve(candidates , target , index + 1 , sum  , ans ,  finalAns);
        
        //include 
		ans.add(candidates[index]);
        solve(candidates , target , index + 1 , sum  + candidates[index] , ans , finalAns);
    }
}
