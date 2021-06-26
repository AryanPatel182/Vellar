#include <stdio.h>
#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int n;
    cin>>n;

    bool prime[n+1];
    for(int i = 0; i<= n ; i++)
    {
        prime[i] = true;        
    }

    for(int i = 2 ; i*i<=n ; i++) 
    {
        if(prime[i] != false)
        {        
            int count = 2;
            while(i*count <= n)
            {
                prime[i*count] = false;
                count++;
            }
        }
    }

    for(int i = 2 ; i<= n ; i++)
    {
        if(prime[i] == true)
        {
            cout<<i<<endl;
        }
    }
    return 0;
}