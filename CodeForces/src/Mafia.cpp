#include<bits/stdc++.h>
using namespace std;

int main()
{

    int n;
    cin>>n;

    long long sum = 0;
    long long maxval = 0;
    for(int i=0; i<n; i++)
    {
        long long temp;
        cin>>temp;
        maxval = max(maxval,temp);
        sum+=temp;
    }

    long long ans = sum/(n-1);
    if(sum%(n-1)>0)
    {
        ans+=1;
    }
    if(ans<maxval)
    {
        ans = maxval;
    }

    cout<<ans<<endl;
    
    return 0;
}
