class Solution {

    public static void main(String args[]) {
        System.out.println("car");

        int target = 100;
        int fuel = 10;

        int stations[][] ={{10,60},{20,30},{30,30},{60,40}};


        int ans = minRefuelStops(target, fuel, stations);

        System.out.println(ans);
    }

    static int MAX = Integer.MAX_VALUE;

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        // simple cases

        int ans = solve(-1 , startFuel , target , 0 , stations);

        return ans; // can't reach

    }

    // recursive function will give number of stops required

    static int solve(int idx, int fuel, int target, int pos, int[][] st) {

        if (pos == target)
            return 0;
        // check if we can reach directly to the target from current location
        if (fuel >= target - pos)
            return 1; // we need 0 stations then
        // else if ( pos == target) return 0; //also no need of stations

        // we can't reach directly so use stations
        int min = MAX;

        for (int i = idx + 1; i < st.length; i++) {

            int stationPos = st[i][0];
            int stationFuel = st[i][1];

            // calculate the distance to that station
            int dist = stationPos - pos; // the distance to reach that stations

            if (fuel >= dist) {
                // then new fuel will be (fuel - dist + stationFuel)
                fuel = fuel - dist + stationFuel;

                int ans = 1 + solve(i, fuel, target, stationPos, st);

                // check

                // this means we can reach from the station
                min = Math.min(min, ans);

            } else {
                // System.out.println("can't reach station =>" + stationPos);
                break;
            }

        }
        // check
        return min == MAX ? -1 : min;
    }
}