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

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    long long t;
    cin >> t;
    while (t--)
    {
        string s;
        cin>>s;
        ll n = s.size();
        ll ans = 0;
        ll temp = 0;
        unordered_map<char, int> umap;
        for(int i=0;i<n;i++)
        {
            if (umap.find(s[i]) == umap.end())
                umap[s[i]] = 1;
            else
                umap[s[i]]+=1;
        }

        for(auto x:umap)
        {
            if(x.second >=2)
            {
                ans+=1;
            }
            else
            {
                temp++;
            }
        }
        ans = ans + temp/2;

        cout<<ans<<endl;
    }

    return 0;
}
