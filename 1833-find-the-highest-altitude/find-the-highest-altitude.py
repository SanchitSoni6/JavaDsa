class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        c=0
        s=[0]
        for i in gain:
            c=c+i
            s.append(c)
        return max(s)    


        