#include <stdio.h>
#include <iostream>
using namespace std;

void printarr(int arr[] ,int n){
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout<<endl;
}

void swap(int &x, int &y)
{
    int temp = x;
    x = y;
    y = temp;
}

int partition(int arr[], int low, int high)
{
    int pivot = high;
    int j = low;

    for (int k = low; k < high; k++)
    {
        printarr(arr,high+1);
        if (arr[k] < arr[pivot])
        {
            swap(arr[k], arr[j]);
            j++;
        }
    }
    swap(arr[j], arr[high]);
    return j;
}

int main()
{
    int arr[] = {-1, 3, -3, 2, 4, 0};
    int size = sizeof(arr) / sizeof(arr[0]);
    
    int max  = -2222, index;
    if(arr[0]<0) {
        max =arr[0];
        index = 0;
    }
    for (int i = 0; i < size; i++)
    {
        
        if(arr[i]<0)
        {
            if(arr[i]>max)
            {
                max = arr[i];
                index = i;
            }            
        }
    }
    printarr(arr,size);
    swap(arr[size-1],arr[index]);

    int point = partition(arr,0,size-1);
    printarr(arr,size);
   
}