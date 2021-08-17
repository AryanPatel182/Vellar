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
    int n ,m;
    cin>>n>>m;

    int freq[n] = {};
    int count = n;
    for (int i = 0; i < m; i++)
    {
        int u ,v;
        cin>>u>>v;        

        freq[min(u, v) - 1] += 1;
        if(freq[min(u, v)- 1] == 1)
        {            
            count--;
        }            
    }    
    int queries;
    cin>>queries;

    for (int i = 0; i < queries; i++)
    {
        int type;
        
        cin>>type;
        if (type == 1)
        {
            int u, v;
            cin >> u >> v;
            freq[min(u, v) - 1] += 1;
            if (freq[min(u, v) - 1] == 1)  count -= 1;
        }
        else if (type == 2)
        {
            int u, v;
            cin >> u >> v;

            freq[min(u, v) - 1] -= 1;
            if (freq[min(u, v) - 1] == 0)  count += 1;
        }
        else if (type == 3)
        {            
            cout<<count<<endl;
        }
    }
}


int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    solve();
    return 0;
}
