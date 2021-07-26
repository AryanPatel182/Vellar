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
        string s,t;
        cin>>s>>t;

        int n1 = s.size();
        int n2 = t.size();

        if(n2>n1)
        {
            cout<<"No"<<endl;
            continue;
        }
        string ans = "Yes";

        int i = n1-1;        

        int count = 0;
        for(int j = n2-1; j>=0; j--)
        {
            while(i>=0 && s[i]!=t[j])
            {
                i-=2;
            }
            if(i<0)
            {
                ans = "No";
                break;
            }
            i-=1;            
        }


        cout<<ans<<endl;

    }
    return 0;
}
