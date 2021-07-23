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

class Pair
{
public:
    Pair();
    
};



int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    ll n;
    cin >> n;
    
    ll arr[n];
    for(int i=0 ; i<n ; i++)
    {
        cin>>arr[i];
    }

    ll maxval = 0;

    for(ll i=0; i<n; i++)
    {
        ll c= 0;
        ll j = i;
        while(j>=0)
        {
            j = arr[j]-1;
            c++;
        }

        maxval = max(maxval, c);
        
    }

    cout<<maxval<<endl;
    return 0;
}
