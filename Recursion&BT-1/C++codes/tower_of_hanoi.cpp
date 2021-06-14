#include <stdio.h>
#include <bits/stdc++.h>
#include <iostream>
using namespace std;

void print_tower_of_hanoi(int n,char A, char B,char C)
{
    if(n==0) 
        return;
    print_tower_of_hanoi(n-1,A,C,B);
    cout<<n<<" tower "<<A<<" to tower "<<B<<endl;
    print_tower_of_hanoi(n - 1, C, B, A);
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
    char A='A',B='B',C='C';
    cin>>n;
    print_tower_of_hanoi(n,A,B,C);
    return 0;
}