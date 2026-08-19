class Solution(object):
    def reverseWords(self, s):
        words=s.split()
        words=words[::-1]
        s=" ".join(words)
        return s    

        """
        :type s: str
        :rtype: str
        """
        