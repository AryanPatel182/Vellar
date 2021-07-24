
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
    int r, c;
    cin >> r >> c;

    char arr[r][c];

    for (int i = 0; i < r; i++)
    {
        string s;
        cin>>s;
        for (int j = 0; j < c; j++)
        {
            arr[i][j] = s[j];
        }
    }
    string ans = "Yes";

    for (int i = 0; i < r; i++)
    {
        for (int j = 0; j < c; j++)
        {
            if (arr[i][j] == 'S')
            {                
                if (j != c - 1 && arr[i][j + 1] == 'W')
                {
                    ans = "No";
                }
                else if (j != c - 1 && arr[i][j + 1] == '.')
                {
                    arr[i][j + 1] = 'D';
                }
                if (j != 0 && arr[i][j - 1] == 'W')
                {
                    ans = "No";
                }
                else if (j != 0 && arr[i][j - 1] == '.')
                {
                    arr[i][j - 1] = 'D';
                }
                if (i != r - 1 && arr[i + 1][j] == 'W')
                {
                    ans = "No";
                }
                else if (i != r - 1 && arr[i + 1][j] == '.')
                {
                    arr[i + 1][j] = 'D';
                }
                if (i != 0 && arr[i - 1][j] == 'W')
                {
                    ans = "No";
                }
                else if (i != 0 && arr[i - 1][j] == '.')
                {
                    arr[i - 1][j] = 'D';
                }
            }
            
        }
    }

    if(ans == "No")
    {
        cout<<ans<<endl;
    }
    else
    {
        cout<<ans<<endl;
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                cout<<arr[i][j];
            }
            cout<<endl;
        }
    }

    return 0;
}
