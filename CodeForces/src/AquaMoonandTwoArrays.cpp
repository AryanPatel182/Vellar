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
        int n;
        cin>>n;
        int A[n];
        int B[n];

        for(int i = 0 ; i<n; i++)
        {
            cin>>A[i];
        }
        for(int i =0; i<n ; i++)
        {
            cin>>B[i];
        }

        int is=0;
        int js=0;

        vector<int> iarr;
        vector<int> jarr;
        for(int i = 0 ; i<n; i++)
        {
            if(A[i]>B[i])
            {
                is+=(A[i]-B[i]);
                for(int k = 1; k<=(A[i]-B[i]); k++)
                {
                    iarr.push_back(i+1);
                }
            }
            else
            {
                js+=(B[i]-A[i]);
                for (int k = 1; k <= (B[i] - A[i]); k++)
                {
                    jarr.push_back(i+1);
                }
            }
        }

        // cout<<"is = "<< is << "    &    js = "<<js<<endl;

        if(is == js)
        {
            cout<<is<<endl;
            for(int i=0; i<is; i++)
            {
                cout<<iarr[i]<<" "<<jarr[i]<<endl;
            }
        }
        else
        {
            cout<<"-1"<<endl;
        }


    }
    return 0;
}
