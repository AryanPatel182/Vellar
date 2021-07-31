#include<bits/stdc++.h>
using namespace std;

string makeString(int n)
{
    string s = "";
    for(int i=0;i<(n/2); i++)
    {
        s += 'a';
    }
    s+= 'b';

    for(int i=0; i<(n/2)-1;i++)
    {
        s+='a';
    }

    return s;
}

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        if(n==1)
        {
            cout<<"a"<<endl;
            continue;
        }
        
        if(n%2 == 0)  // even
        {
            string ans = makeString(n);
            cout<<ans<<endl;
        } 
        else if(n%2 == 1)
        {
            string ans = makeString(n)+'c';
            cout<<ans<<endl;
        }

        
    
    }
    
}