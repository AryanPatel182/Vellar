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
    int n, s;
    cin >> n >> s;

    int arr[2][n];

    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> arr[i][j];
        }
    }

    if (arr[0][0] == 0)
    {
        cout<<"NO"<<endl;
        return;
    }
    if(arr[0][s-1] == 1)
    {
        cout<<"YES"<<endl;
        return;
    }
    if(arr[1][s-1] == 0)
    {
        cout<<"NO"<<endl;
        return;
    }


    for(int c=s; c<n; c++)
    {
        if(arr[0][c] == 1 && arr[1][c] == 1)
        {
            cout<<"YES"<<endl;
            return;
        }        
    }

    cout<<"NO"<<endl;
    return;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    solve();
    
    return 0;
}
