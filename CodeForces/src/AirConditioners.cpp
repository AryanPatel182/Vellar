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

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    long long t;
    cin >> t;
    while (t--)
    {     
        long long n;
        long long k;
        cin>>n>>k;
        long long a[k];
        long long t[k];

        long long arr[n];
        for(int i=0; i<n;i++)
        {
            arr[i] = INF;
        }
        for(long long i= 0; i<k ;i++)
        {
            cin>>a[i];
            a[i] = a[i]-1;
        }
        for(long long i= 0; i<k ;i++)
        {
            cin>>t[i];
            arr[a[i]] = t[i];
        }

        for(int i=0;i<k;i++)
        {
            arr[a[i]] = t[i];
        }
        long long mini = INF;
        for(long long i=0;i<n; i++)
        {
            mini = min(mini+1,arr[i]);
            arr[i] = mini;
        }
        
        for(long long i=n-1; i>=0; i--)
        {
            mini = min(mini+1, arr[i]);
            arr[i] = mini;
        }

        for(long long i=0; i<n; i++)
        {
            cout<<arr[i]<<" ";
        }

        cout<<endl;
    }
    return 0;
}
