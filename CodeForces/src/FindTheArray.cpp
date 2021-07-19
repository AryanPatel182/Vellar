#include <bits/stdc++.h>

using namespace std;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
 
  int t;
  cin >> t;
  while(t--)
  {
    int n;
    cin>>n;
    int x=1;
    long long int sum = 0;
    int count=0;

    while(sum<n)
    {
      sum += x;
      x += 2;
      count++;
    }
    cout<<count<<"\n";
  }
 
  return 0;
}