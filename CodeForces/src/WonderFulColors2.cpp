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
        ll n;
        ll k;
        cin>>n>>k;

        vector<int> arr(n);
        vector<int> ans(n);
        for(int i=0; i<n; i++)
        {
            cin>>arr[i];
        }
        vector<int> freq(n+1);
        for(int i=0; i<=n; i++)
        {
            freq[i] = 0;
        }
        vector<vector<int>> occ(n+1,vector<int>());

        for(int i=0; i<n;i++)
        {
            freq[arr[i]] = freq[arr[i]]+1;
            // cout<<freq[i]<<endl;
            occ[arr[i]].push_back(i);
            
        }

        vector<int> remaincolor;
        for(int i=0; i<=n ; i++)
        {
            if(freq[i]>=k)
            {
                for(int j=0; j<k; j++)
                {
                    ans[occ[i][j]] = j+1;
                    // cout<<ans[occ[i][j]]<<endl;
                }
            }
            else
            {
                for(int j=0; j<freq[i]; j++)
                {
                    remaincolor.push_back(occ[i][j]);
                    // cout << occ[i][j] << endl;
                }
            }
            // cout<<i<<endl;
        }

        // cout<<remaincolor.size()<<endl;
        
        if(remaincolor.size()>=k)
        {
            for(int i=0; i<=remaincolor.size()-k ; i+=k)
            {
                for(int j=0;j<k; j++)
                {
                    ans[remaincolor[i+j]] = j+1;
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            cout<<ans[i]<<" ";
        }
        cout<<endl;

    }
    return 0;
}
