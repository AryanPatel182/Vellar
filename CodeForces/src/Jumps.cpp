#include <bits/stdc++.h>
using namespace std;
int main()
{
    int t;
    cin>>t;

    while(t--)
    {
        int n;
        cin>>n;
        int sum = 0;
        int count = 0;
        int i = 1;
        while (true)
        {
            if(sum>=n)
            {
                break;
            }
            sum+=i;
            count+=1;
            i+=1;
        }
        
        if(sum - n == 1) count+=1;        
        cout<<count<<endl;
        
    }

    return 0;
}