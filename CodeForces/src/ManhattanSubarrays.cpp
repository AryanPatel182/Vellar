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
#define LL long long
#define MOD 1000000007
#define all(x) (x).begin(), (x).end()
#define INF 1e15

int check(int arr[], int si, int n)
{
    for(int i=si;i<=n-2;i++)
    {
        for(int j=i+1;j<=n-1;j++)
        {
            for(int k=j+1; k<=n;k++)
            {
                if(abs(arr[i]-arr[k]) == abs(arr[i]-arr[j]) + abs(arr[j]-arr[k]))
                {
                    return 0;                    
                }                
            }
        }
    }

    return 1;
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
        int n;        
        cin>>n;

        int arr[n];

        for(int i=0; i<n; i++)
        {
            cin>>arr[i];
        }

        int ans = (n*(n+1))/2;
        // cout<<ans<<endl;
        if(n<3)
        {
            cout<<ans<<endl;
            continue;
        }

        ans = n+n-1;
        int len = 3;
        while(len<=4)
        {
            for(int i=0;i<=n-len;i++)
            {
                if(check(arr,i,i+len-1))
                {
                    ans++;
                }
            }
            len++;
        }
                
        cout<<ans<<endl;
    }
    return 0;
}
