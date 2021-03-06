//Unordered Map(Hash Map) (Time: O(N) Space: O(N))
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> numDict;
        vector<int> ans;
        
        for(int i = 0; i < nums.size(); i++) {
            int compliment = target - nums[i];
            if(numDict.find(compliment) != numDict.end()) {
                // ans.push_back(i);
                // ans.push_back(numDict.at(compliment));
                // return ans;
                return {numDict[compliment], i};
            }
            numDict[nums[i]] = i;
        }
        // return ans;
        return {};
    }
};

//Brute Force (Time: O(N^2) Space: O(1))
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // vector<int> ans;
        
        for(int i = 0; i < nums.size(); i++) {
            for(int j = i + 1; j < nums.size(); j++) {
                if(nums[i] + nums[j] == target) {
                    // ans.push_back(i);
                    // ans.push_back(j);
                    // return ans;
                    return {i, j};
                }
            }
        }
        // return ans;
        return {};
    }
};