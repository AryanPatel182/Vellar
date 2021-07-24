// #include <iostream>
// #include <iosfwd>
// #include <iomanip>
// #include <cstdio>
// #include <cstring>
// #include <cstdlib>
// #include <ctime>
// #include <cmath>
// #include <cassert>
// #include <cctype>
// #include <climits>
// #include <vector>
// #include <bitset>
// #include <set>
// #include <queue>
// #include <math.h>
// #include <stack>
// #include <map>
// #include <deque>
// #include <string>
// #include <list>
// #include <iterator>
// #include <sstream>
// #include <complex>
// #include <fstream>
// #include <functional>
// #include <numeric>
// #include <utility>
// #include <algorithm>
// #include <assert.h>
// #include <unordered_map>
// #pragma GCC optimize("-O3")

// using namespace std;

// #define watch(x) cout << (#x) << " = " << (x) << endl
// #define PI double(2 * acos(0.0))
// #define ll long long
// #define MOD 1000000007
// #define all(x) (x).begin(), (x).end()
// #define INF 1e15

// int main()
// {
//     ios_base::sync_with_stdio(0);
//     cin.tie(0);
//     cout.tie(0);
//     long long t;
//     cin >> t;
//     while (t--)
//     {
//         string s1;
//         string s2;
//         cin >> s1 >> s2;
//         ll n1 = s1.length();
//         ll n2 = s2.length();

//         ll chip = -1;
//         char fc = s2[0];

//         for (ll i = 0; i < n1; i++)
//         {
//             if (s1[i] == fc)
//             {
//                 chip = i;
//                 break;
//             }
//         }

//         if (chip == -1)
//         {
//             cout << "No" << endl;
//             continue;
//         }

//         bool right = true;
//         bool left = true;
//         string ans = "Yes";

//         for (int i = 1; i < n2; i++)
//         {            
//             char ch = s2[i];
//             if (chip == 0)
//             {
//                 if (s1[chip + 1] == ch && right == true) /// going right
//                 {
//                     chip++;
//                     continue;
//                 }
//                 else
//                 {
//                     ans = "No";
//                     break;
//                 }
//             }
//             else if (chip == n1 - 1) //// going left
//             {
//                 if (s1[chip - 1] == ch && left == true)
//                 {
//                     chip--;
//                     right = false;
//                     continue;
//                 }
//                 else
//                 {
//                     ans = "No";
//                     break;
//                 }
//             }

//             if (s1[chip + 1] == ch && right == true) /// going right
//             {
//                 chip++;
//                 continue;
//             }
//             if (s1[chip - 1] == ch && left == true) /// going left
//             {
//                 chip--;
//                 right = false;
//                 continue;
//             }
//             else
//             {
//                 ans = "No";
//                 break;
//             }            
//         }
//         cout << ans << endl;
//     }

//     return 0;
// }

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

ll firstindex(string s1, char ch)
{    
    for(ll i=0; i<s1.size(); i++)
    {
        if(s1[i] == ch)
        {
            return i;
        }
    }
    
    return -1;
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
        string s1,s2;
        cin>>s1>>s2;

        ll n1 = s1.size();
        ll n2 = s2.size();


        ll chip = firstindex(s1,s2[0]);

        if(chip==-1)
        {
            cout<<"No"<<endl;
            continue;
        }

        ll j=0;
        ll count=0;
        while(chip<n1 && j<n2)
        {
            // cout<<chip<<endl;
            if(s1[chip] == s2[j])
            {
                chip++;
                j++;
                count++;
            }
            else
            {   
                chip++;
            }
        }
        chip-=2;

        while(chip>=0 && j<n2)
        {
            // cout<<chip<<endl;
            if(s1[chip]==s2[j])
            {
                chip--;
                j++;
                count++;
            }
            else
            {
                chip--;
            }
        }

        if(count == n2)
        {
            cout<<"YES"<<endl;
        }
        else 
        {
            cout<<"NO"<<endl;
        }
    }
    return 0;
}
