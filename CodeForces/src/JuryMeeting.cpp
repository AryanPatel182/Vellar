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
#define mod 998244353
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
        int n;
        cin>>n;

        vector<int> arr(n);
        for (int i = 0; i < n; i++)
        {
            cin>>arr[i];
        }
        

        int mx = *max_element(arr.begin(), arr.end());
        int cmx = count(arr.begin(), arr.end(), mx);
        int k = count(arr.begin(), arr.end(), mx - 1);

        int ans = 1,sub = 1;        
        for (long long i = 1; i <= n; ++i)
        {
            ans = ans * i % mod;
            if (i != k + 1)
                sub = sub * i % mod;
        }
        if (cmx == 1)
            ans = (ans - sub + mod) % mod;
        cout << ans << endl;
    }
    return 0;
}
