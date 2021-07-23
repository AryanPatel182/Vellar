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

// bool isPrime(ll val)
// {
//     for(ll i = 2; i*i <= val ; i++)
//     {
//         if(val%i == 0)
//         {
//             return false;
//         }
//     }
//     return true;
// }


// int main()
// {
//     ios_base::sync_with_stdio(0);
//     cin.tie(0);
//     cout.tie(0);
//     ll n;
//     cin>>n;

//     if(n==1)
//     {
//         cout<<3<<endl;    
//     }
//     else if(n%2==0)
//     {
//         for(ll i=1; i<=1000; i++)
//         {
//             ll val = n*i + 1;

//             if(isPrime(val))
//             {
//                 continue;
//             }
//             else
//             {
//                 cout<<i<<endl;
//                 break;
//             }
//         }
//     }
//     else
//     {
//         cout<<1<<endl;
//     }

    
//     return 0;
// }








// // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    Second Approach    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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

bool isPrime(ll val)
{
    for (ll i = 2; i * i <= val; i++)
    {
        if (val % i == 0)
        {
            return false;
        }
    }
    return true;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    ll n;
    cin >> n;

    if(n == 1)
    {
        cout << 3 << endl;
    }
    else if(n==2)
    {
        cout<<4<<endl;
    }
    else
    {
        cout<<n-2<<endl;
    }
    return 0;
}

