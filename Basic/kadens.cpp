// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
    public:
    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int arr[], int n){
        int maxsum = INT_MIN;
        int itsum = 0;
        
        for(int i=0;i<n;i++)
        {
            itsum = itsum + arr[i];
            if(itsum > maxsum)
            {
                maxsum = itsum;
            }
            if(itsum < 0) 
            {
                itsum = 0;
            }
        }
        
        return maxsum;
        // Your code here
        
    }
};

// { Driver Code Starts.

int main()
{
    int t,n;
    
    cin>>t; //input testcases
    while(t--) //while testcases exist
    {
        
        cin>>n; //input size of array
        
        int a[n];
        
        for(int i=0;i<n;i++)
            cin>>a[i]; //inputting elements of array
            
        Solution ob;
        
        cout << ob.maxSubarraySum(a, n) << endl;
    }
}
  // } Driver Code Ends