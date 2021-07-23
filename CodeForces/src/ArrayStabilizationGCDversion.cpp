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

int check(int a[],int n)
{
    int minval = INT_MAX;
    int maxval = INT_MIN;
    for (int i = 0; i < n; i++)
    {        
        minval = min(minval, a[i]);
        maxval = max(maxval, a[i]);
    }
    if (minval == maxval)
    {        
        return 1;
    }
    return 0;
}
int gcd(int a, int b)
{
    // Everything divides 0
    if (a == 0)
        return b;
    if (b == 0)
        return a;

    // base case
    if (a == b)
        return a;

    // a is greater
    if (a > b)
        return gcd(a - b, b);
    return gcd(a, b - a);
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
        cin >> n;
        int a[n];        
        for (int i = 0; i < n; i++)
        {
            cin >> a[i];         
        }        
        int count = 0;

        while(check(a,n) != 1)
        {
            int temp = a[0];
            for (int i = 0; i < n; i++)
            {
                if (i == n - 1)
                {
                    a[i] = gcd(a[i], temp);
                }
                else
                {
                    a[i] = gcd(a[i], a[i + 1]);
                }
            }
            count++;
        }

        cout<<count<<endl;
    }
    return 0;
}
