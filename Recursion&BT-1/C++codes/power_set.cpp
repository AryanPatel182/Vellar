
// CPP program for the above approach
#include<stdio.h>
#include <bits/stdc++.h>
#include<iostream>
using namespace std;

// Find all subsequences
void printSubsequence(string input, string output)
{
    // Base Case
    // if the input is empty print the output string
    if (input.empty())
    {
        cout << output << endl;
        return;
    }

    // output is passed with including
    // the Ist characther of
    // Input string
    printSubsequence(input.substr(1), output + input[0]);

    // output is passed without
    // including the Ist character
    // of Input string
    printSubsequence(input.substr(1), output);
}

// Driver code
int main()
{
    // output is set to null before passing in as a
    // parameter
    ios_base::sync_with_stdio(false);
        cin.tie(NULL);

        #ifndef ONLINE_JUDGE
        freopen("input.txt", "r" ,stdin);
        freopen("output.txt", "w" ,stdout);
        #endif

    
    string input , output;
    cin>>input;
    cin>>output;


    printSubsequence(input, output);

    return 0;
}
