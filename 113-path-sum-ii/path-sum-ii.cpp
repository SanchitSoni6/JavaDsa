class Solution {
public:
    void solve(TreeNode* root, int targetSum, vector<vector<int>>& ans, vector<int>& temp)
    {
        if(!root)
            return;
        
        temp.push_back(root->val);

        if(!root->left && !root->right && root->val == targetSum)
            ans.push_back(temp);
        else
        {
            targetSum -= root->val;
            solve(root->left, targetSum, ans, temp);
            solve(root->right, targetSum, ans, temp);
        }

        temp.pop_back();
    }

    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> ans;
        vector<int> temp;
        solve(root, targetSum, ans, temp);
        return ans;
    }
};