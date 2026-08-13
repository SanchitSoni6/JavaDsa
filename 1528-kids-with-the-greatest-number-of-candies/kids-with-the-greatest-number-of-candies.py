class Solution(object):
    def kidsWithCandies(self, candies, extraCandies):
        a=[]
        b=[]
        for i in candies:
            a.append(i)
            maxm= max(a)
        for j in range(len(candies)):
            if candies[j]+extraCandies>=maxm:
                result= True
                b.append(result)
            else:
                result= False 
                b.append(result)
        return b    



        """
        :type candies: List[int]
        :type extraCandies: int
        :rtype: List[bool]
        """
        