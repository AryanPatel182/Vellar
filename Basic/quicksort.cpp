#include<stdio.h>
#include<iostream>
using namespace std;

void swap(int &x, int &y)
{
    int temp = x;
    x = y;
    y = temp;
}

int partition(int arr[] ,int low,int high){
    int pivot = high;
    int j=low;

    for(int k=low;k<high;k++)
    {
        if(arr[k]<arr[pivot])
        {
            swap(arr[k],arr[j]);
            j++;
        }
    }
    swap(arr[j] , arr[high]);
    return j;
}


void quicksort(int arr[] ,int low, int high)
{
    if(low<high){
        int pivot_index =partition(arr,low,high);

        quicksort(arr,low,pivot_index-1);
        quicksort(arr,pivot_index+1,high);
    }
}

int main(){
    int arr[]={-1,-2,-3,2,4,0};
    int size = sizeof(arr)/sizeof(arr[0]);
    quicksort(arr,0,size-1);

    for(int i=0;i<size;i++)
    {
        cout<<arr[i]<<" "<<endl;
    }
}