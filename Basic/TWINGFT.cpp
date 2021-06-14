#include <algorithm>
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

    int t;
    cin >> t;

    for (int i = 0; i < t; i++)
    {
        int n, k;
        cin >> n >> k;
        int arr[n];
        for (int j = 0; j < n; j++)
        {
            cin >> arr[j];
        }
        sort(arr, arr + n);
        int sum1 = 0, sum2 = 0;
        int index = n - 1;
        int temp = k;
        while (k--)
        {
            if (index < 0)
            {
                arr[index] = 0;
            }
            if (index - 1 < 0)
            {
                arr[index - 1] = 0;
            }
            sum1 = sum1 + arr[index];
            // if(k=0)
            // {
            //     sum1 = sum1 + arr[index-1];
            // }

            index = index - 2;
        }
        k = temp;
        index = n - 2;
        while (k--)
        {
            if (index < 0)
            {
                arr[index] = 0;
            }
            if (index - 1 < 0)
            {
                arr[index - 1] = 0;
            }
            sum2 = sum2 + arr[index];
            if (k == 0)
            {
                sum2 = sum2 + arr[index - 1];
            }

            index = index - 2;
        }

        if (sum1 > sum2)
        {
            cout << sum1 << endl;
        }
        else
        {
            cout << sum2 << endl;
        }
    }
    // your code goes here
    return 0;
}
