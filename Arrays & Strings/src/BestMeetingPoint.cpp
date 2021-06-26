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

    int r, c;
    cin>>r;
    cin>>c;
    int arr[r][c];

    vector<int> rx;
    vector<int> cy;

    for(int  i=0; i<r; i++)
    {
        for(int j = 0 ; j< c; j++)
        {
            cin>>arr[i][j];

            if(arr[i][j] == 1)
            {
                
                rx.push_back(i);
            }
        }
    }
    
    
    for(int  j=0; j<c; j++)
    {
        for(int i = 0 ; i< r; i++)
        {            
            if(arr[i][j] == 1)
            {
    
                cy.push_back(j);
            }
        }
    }
    
    int d1 = rx.size()/2;
    int d2 = cy.size()/2;

    int sum  = 0;
    for(int i = 0 ; i < rx.size() ; i++)
    {
 
        sum = sum + abs(rx[d1]-rx[i]);
        sum = sum + abs(cy[d2] - cy[i]);
    }

    cout<<sum;
    return 0;
}