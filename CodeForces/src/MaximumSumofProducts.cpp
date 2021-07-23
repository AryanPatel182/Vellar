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
    ll n;
    cin >> n;
    ll a[n],b[n];

    for(ll i = 0 ; i<n; i++)
    {
        cin>> a[i];
    }
    for(ll i = 0 ; i<n; i++)
    {
        cin>> b[i];
    }

    ll ldp[n][n];

    ll psum[n];
    psum[0] = a[0]*b[0];
    for(int i=1; i<n; i++)
    {        
        psum[i] = psum[i-1] + (a[i]*b[i]);
    }
    
    ll maxval = 0;

    for (ll g = 0; g < n; g++)
    {
        for (int i = 0, j = g; j < n; i++, j++)
        {
            if (g == 0)
            {
                ldp[i][j] = a[i] * b[i];
            }
            else if (g == 1)
            {
                ldp[i][j] = a[i] * b[j] + a[j] * b[i];
            }
            else
            {
                ldp[i][j] = ldp[i+1][j-1] + a[i] * b[j] + a[j] * b[i];
            }

            maxval = max(maxval, (ldp[i][j]-(psum[j]-(i<1?0:psum[i-1]))));
        }
    }
    
    cout<<psum[n-1]+ maxval<<endl;
    return 0;
}
