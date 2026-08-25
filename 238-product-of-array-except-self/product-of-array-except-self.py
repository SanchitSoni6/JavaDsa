class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        a = [1] * n

        left = 1
        for i in range(n):
            a[i] = left
            left *= nums[i]

        right = 1
        for i in range(n - 1, -1, -1):
            a[i] *= right
            right *= nums[i]

        return a