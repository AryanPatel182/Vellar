#include <stdio.h>
#include <bits/stdc++.h>
#include <iostream>
using namespace std;

vector<int> all_index(int arr[],int idx, int n, int count, int k)
{
    if(idx==n)
    {  
        if(count==0)
        {
            vector<int> temp(1,-1);
            return temp;
        }
        else{// int temp[count];
            vector<int> temp(count);
            return temp;
        }
    }
    if(arr[idx]==k)
    {
        vector<int> tmp = all_index(arr ,idx+1 ,n ,count+1 ,k);
        tmp[count] = idx;
        return tmp;
    }else{
        vector<int> tmp = all_index(arr, idx + 1, n, count, k);
        return tmp;
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

    vector<int> ans = all_index(arr, 0, n, 0, k);
    for(int i=0;i<ans.size();i++)
    {
        cout<<ans[i]<<"  ";
    }
    return 0;
}