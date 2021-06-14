// { Driver Code Starts
#include<bits/stdc++.h>
#include <cstddef>

using namespace std;


 // } Driver Code Ends
// Function to return minimum number of jumps to end of array

class Solution{
  public:
    int minJumps(int arr[], int n)
    {
        int arr2[n];
        arr2[n-1]=0;
        for(int i=n-2;i<0;i++)
        {   
            int a = arr2[i];
            int min = INT_MAX;
            for(int j=1;j<=a && i+j <n;j++)
            {
                if(arr2[i+j]!= NULL && arr2[i+j] < min)
                {
                    min = arr2[i+j];
                }            
            }
            if(min != INT_MAX)
                arr2[i] = min + 1;
        }
        
        return arr2[0];
        // Your code here
    }
};


// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,i,j;
        cin>>n;
        int arr[n];
        for(int i=0; i<n; i++)
            cin>>arr[i];
        Solution obj;
        cout<<obj.minJumps(arr, n)<<endl;
    }
    return 0;
}