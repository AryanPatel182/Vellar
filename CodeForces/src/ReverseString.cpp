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
#pragma GCC optimize("-O3")

using namespace std;

#define watch(x) cout << (#x) << " = " << (x) << endl
#define PI double(2 * acos(0.0))
#define ll long long
#define MOD 1000000007
#define all(x) (x).begin(), (x).end()
#define INF 1e15


void solve()
{
    string s1, s2;
    cin >> s1 >> s2;
    ll n = s1.size();
    for (ll i = 0; i < n; i++)
    {
        if (s1[i] == s2[0])
        {
            ll len = 0, j = i, kk = 0;
            while (j < s1.size() && kk < s2.size() && s1[j] == s2[kk])
            {
                j++;
                kk++;
                len++;
            }
            j -= 2;
            while (j >= 0 && kk < s2.size() && s1[j] == s2[kk])
            {
                j--;
                kk++;
                len++;
            }
            if (len == s2.size())
            {
                cout << "Yes" << endl;
                return;
            }
        }
    }
    cout << "No" << endl;
}
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    long long t;
    cin >> t;
    while (t--)
    {        
        solve();
    }
    
    return 0;
}
