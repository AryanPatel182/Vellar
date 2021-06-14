#include <stdio.h>
#include <bits/stdc++.h>
#include <iostream>
using namespace std;


void zigzag_tree(int n)
{
    if(n==0)
    {
        return;
    }
    cout<<"pre "<<n <<endl;
    zigzag_tree(n-1);
    cout << "In " << n << endl;
    zigzag_tree(n-1);
    cout << "post " << n << endl;
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

    zigzag_tree(n);
    return 0;
}