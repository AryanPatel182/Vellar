#include<bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;

    while (t--)
    {
        long long n;
        cin>>n;

        long long k = n%6;
        long long m = n/6;
        long long ans;

        if(n<=6)
        {
            ans = 15;
        }
        else if(k==0)
        {
            ans = 15*(m);
        }
        else if(k<=2)
        {
            ans = 15*(m) + 5;
        }
        else if(k<=4)
        {
            ans = 15*(m) + 10;
        }
        else
        {
            ans = 15*(++m);
        }

        cout<<ans<<endl;

    }
    
}

