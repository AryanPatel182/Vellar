#include <iostream>
#include <iosfwd>
#include <iomanip>
#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <ctime>
#include <cmath>
#include <cassert>
#include <cctype>
#include <climits>
#include <vector>
#include <bitset>
#include <set>
#include <queue>
#include <math.h>
#include <stack>
#include <map>
#include <deque>
#include <string>
#include <list>
#include <iterator>
#include <sstream>
#include <complex>
#include <fstream>
#include <functional>
#include <numeric>
#include <utility>
#include <algorithm>
#include <assert.h>
#include <unordered_map>
#pragma GCC optimize ("-O3")

using namespace std;

#define watch(x) cout << (#x) << " = " << (x) << endl
#define PI double(2 * acos(0.0))
#define LL long long
#define MOD 1000000007
#define all(x) (x).begin(), (x).end()
#define INF 1e15

int main()  {
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
    long long t;
    cin >> t;
    while(t--)	{
    	long long n;
    	cin >> n;
    	long long arr[n];
    	long long growing  = 1;
    	for(long long i = 0; i < n; i++)	{
    		cin >> arr[i];    	
    	}
    
		cout << 0 << " ";
		for(long long i = 1; i < n; i++)	{
			long long ans = arr[i-1] ^ arr[i];
			ans = ans & arr[i-1];
			arr[i] ^= ans;
			cout << ans << " ";
		}
		cout << "\n";
    	
    }
    return 0;
}







































