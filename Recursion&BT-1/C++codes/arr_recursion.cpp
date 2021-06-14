#include <stdio.h>
#include <bits/stdc++.h>
#include <iostream>
using namespace std;


void print_arr_rec(int i, int arr[])
{
    if(i<0) return;
    cout<<arr[i]<<endl;
    print_arr_rec(i-1,arr);
}

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
    int arr[n];
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }

    print_arr_rec(n-1,arr);
    return 0;
}