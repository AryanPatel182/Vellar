#include <stdio.h>
#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int first_index(int arr[], int idx,int n ,int k)
{   
    if(idx == n){
        return -1;
    }
    if(arr[idx]==k)
    {
        return idx;
    }else{
        idx = first_index(arr, idx+1 , n, k);
        return idx;
    }

}
int last_index(int arr[], int idx,int n ,int k)
{   
    if(idx == -1){
        return -1;
    }
    if(arr[idx]==k)
    {
        return idx;
    }else{
        idx = last_index(arr, idx-1 , n, k);
        return idx;
    }

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
    int k;
    cin>>k;

    int ans = first_index(arr,0,n,k);
    cout<<"First index of "<<k<<" is "<<ans<<endl;
    ans = last_index(arr,n-1,n,k);
    cout<<"last index of "<<k<<" is "<<ans<<endl;
    

    return 0;
}