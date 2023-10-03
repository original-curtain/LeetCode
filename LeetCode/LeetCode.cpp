#include <iostream>
#include <vector>
#include <string>
#include <list>
#include <map>
#include <unordered_map>
#include <algorithm>
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
};

struct Node
{
	int key,val,freq;
	Node(int _key,int _val,int _freq):key(_key),val(_val),freq(_freq){}
};
class LFUCache {
public:
	LFUCache(int capacity) {
		minfreq=0;
		this->capacity=capacity;
		key_table.clear();
		freq_table.clear();
	}

	int get(int key) {
		if(capacity==0) return -1;
		auto it=key_table.find(key);
		if(it==key_table.end()) return -1;
		list<Node>::iterator node=it->second;
		int val=node->val,freq=node->freq;
		freq_table[freq].erase(node);
		if (freq_table[freq].size() == 0)
		{
			freq_table.erase(freq);
			if(minfreq==freq) minfreq+=1;
		}
		freq_table[freq+1].push_front(Node(key,val,freq+1));
		key_table[key]=freq_table[freq+1].begin();
		return val;
	}

	void put(int key, int value) {
		if(capacity==0) return;
		auto it=key_table.find(key);
		if (it == key_table.end())
		{
			if (key_table.size() == capacity)
			{
				auto it2=freq_table[minfreq].back();
				key_table.erase(it2.key);
				freq_table[minfreq].pop_back();
				if (freq_table[minfreq].size() == 0)
				{
					freq_table.erase(minfreq);
				}
			}
			freq_table[1].push_front(Node(key,value,1));
			key_table[key]=freq_table[1].begin();
			minfreq=1;
		}
		else
		{
			list<Node>::iterator node=it->second;
			int freq=node->freq;
			freq_table[freq].erase(node);
			if (freq_table[freq].size() == 0)
			{
				freq_table.erase(freq);
				if(minfreq==freq) minfreq+=1;
			}
			freq_table[freq+1].push_front(Node(key,value,freq+1));
			key_table[key]=freq_table[freq+1].begin();
		}
	}

private:
	int minfreq,capacity;
	unordered_map<int,list<Node>::iterator> key_table;
	unordered_map<int,list<Node>> freq_table;
};

int main()
{
	Solution* s = new Solution();

	vector<int> prices={ 3,3,5,0,0,3,1,4 };
	cout<<s->maxProfit(prices)<<endl;
}
