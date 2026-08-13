class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxm = candies[0];
        List<Boolean> result = new ArrayList<>();
        
        for (int i = 1; i < candies.length; i++) {
            maxm = Math.max(maxm, candies[i]);
        }
        
        for (int j = 0; j < candies.length; j++) {
            if (candies[j] + extraCandies >= maxm) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}