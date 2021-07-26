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
        string s;
        cin>>s;

        int wa=0,wb=0,ra=5,rb=5;
        int ans1,ans2;
        for(int i=0; i<10; i++)
        {                        
            if(i%2==0)
            {
                if(s[i]=='1')
                {
                    wa++;                    
                    ra--;
                }
                else if(s[i]=='?')
                {
                    wa++;
                    ra--;
                }
                else
                {
                    ra--;
                }      
            }
            if (wa > wb + rb)
            {
                break;
            }
            if(i%2!=0)
            {
                if(s[i] == '1')
                {
                    wb++;
                    rb--;
                }
                else if(s[i]=='?')
                {
                    rb--;
                }
                else
                {
                    rb--;
                }
            }
            if (wa > wb + rb)
            {
                break;
            }
        }
        ans1 = 10 - (ra + rb);
        

        wa = 0, wb = 0, ra = 5, rb = 5;        
        for (int i = 0; i < 10; i++)
        {
            // cout << wa << " " << wb << endl;
            if (i % 2 == 0)
            {
                if (s[i] == '1')
                {
                    wa++;
                    ra--;
                }
                else if (s[i] == '?')
                {                    
                    ra--;
                }
                else
                {
                    ra--;
                }
            }
            if (wb > wa + ra)
            {
                break;
            }
            if (i % 2 != 0)
            {
                if (s[i] == '1')
                {
                    wb++;
                    rb--;
                }
                else if (s[i] == '?')
                {
                    wb++;
                    rb--;
                }
                else
                {
                    rb--;
                }
            }
            if (wb > wa + ra)
            {
                break;
            }
        }
        ans2 = 10 - (ra + rb);

        cout<<min(ans1,ans2)<<endl;
    }
    
    return 0;
}
