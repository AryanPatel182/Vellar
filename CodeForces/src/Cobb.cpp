#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        long long n,k;
        cin>>n>>k;

        long long arr[n];
        for(int i=0; i<n; i++)
        {
            cin>>arr[i];
        }
        long long maxval = LONG_LONG_MIN;
        for(long long i = max(0ll,n-2*k-1); i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                maxval = max(maxval, (((i+1)*(j+1)) - k*(arr[i]|arr[j])));
            }
        }

        cout<<maxval<<endl;
    }
}

