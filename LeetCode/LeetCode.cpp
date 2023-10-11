#include <iostream>
#include <vector>
#include <string>
#include <list>
#include <map>
#include <unordered_map>
#include <algorithm>
#include <sstream>
using namespace std;

string convert(string s, int numRows)
{
	int n = s.length(), r = numRows;
	if (r == 1 || r >= n) {
		return s;
	}
	string ans;
	int t = r * 2 - 2;
	for (int i = 0; i < r; ++i) { // 枚举矩阵的行
		for (int j = 0; j + i < n; j += t) { // 枚举每个周期的起始下标
			ans += s[j + i]; // 当前周期的第一个字符
			if (0 < i && i < r - 1 && j + t - i < n) {
				ans += s[j + t - i]; // 当前周期的第二个字符
			}
		}
	}
	return ans;
}

struct ListNode {
	int val;
	ListNode* next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode* next) : val(x), next(next) {}

	static ListNode* makeList(vector<int> nums)
	{
		ListNode* headPre = new ListNode(-1);
		ListNode* p = headPre;
		for (int i = 0; i < nums.size(); i++)
		{
			ListNode* node = new ListNode(nums[i]);
			p->next = node;
			p = node;
		}
		return headPre->next;
	}

	string toString()
	{
		string s;
		ListNode* p = this;
		while (p)
		{
			s += to_string(p->val) + ",";
			p = p->next;
		}
		return s;
	}
};

 struct TreeNode {
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode() : val(0), left(nullptr), right(nullptr) {}
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
	TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

class Tool {
public:
	static string vectorToString(vector<int> nums)
	{
		string str;
		for (int i = 0; i < nums.size(); i++)
		{
			str += to_string(nums[i]) + ",";
		}
		return str;
	}
};

class Solution {
public:
	static bool mycompara(vector<int>& v1, vector<int>& v2)
	{
		if (v1[1] == v2[1]) return v1[0] > v2[0];
		else return v1[1]>v2[1];
	}
	vector<int> filterRestaurants(vector<vector<int>>& restaurants, int veganFriendly, int maxPrice, int maxDistance) {
		sort(restaurants.begin(), restaurants.end(),Solution::mycompara);
		vector<int> ans;
		for (auto res : restaurants)
		{
			if (((veganFriendly&&res[2])||(!veganFriendly)) && res[3] <= maxPrice && res[4] <= maxDistance)
			{
				ans.emplace_back(res[0]);
			}
		}
		return ans;
	}

	int maxProfit(vector<int>& prices) {
		int n = prices.size();
		int buy1 = -prices[0], sell1 = 0;
		int buy2 = -prices[0], sell2 = 0;
		for (int i = 1; i < n; ++i) {
			buy1 = max(buy1, -prices[i]);
			sell1 = max(sell1, buy1 + prices[i]);
			buy2 = max(buy2, sell1 - prices[i]);
			sell2 = max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}

	vector<int> topStudents(vector<string>& positive_feedback, vector<string>& negative_feedback, vector<string>& report, vector<int>& student_id, int k) {
		unordered_map<std::string, int> words;
		for (const auto& word : positive_feedback) {
			words[word] = 3;
		}
		for (const auto& word : negative_feedback) {
			words[word] = -1;
		}
		vector<vector<int>> A;
		for (int i = 0; i < report.size(); i++) {
			stringstream ss;
			string w;
			int score = 0;
			ss << report[i];
			while (ss >> w) {
				if (words.count(w)) {
					score += words[w];
				}
			}
			A.push_back({ -score, student_id[i] });
		}
		sort(A.begin(), A.end());
		vector<int> top_k;
		for (int i = 0; i < k; i++) {
			top_k.push_back(A[i][1]);
		}
		return top_k;
	}
};

int main()
{
	Solution* s = new Solution();

	vector<string> positive_feedback={ "smart","brilliant","studious" };
	vector<string> negative_feedback={ "not" };
	vector<string> report = {
		"this student is not studious",
		"the student is smart"
	};
	vector<int> student_id={1,2};
	cout<<Tool::vectorToString(s->topStudents(positive_feedback,negative_feedback,report,student_id,2))<<endl;
}
