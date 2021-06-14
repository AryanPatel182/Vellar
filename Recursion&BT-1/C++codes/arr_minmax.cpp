#include<stdio.h>
#include<iostream>
using namespace std;

struct Pair{
    int min;
    int max;
};

struct Pair getminmax(int arr[],int n)
{
    struct Pair minmax;
    minmax.min = arr[0];
    minmax.max = arr[0];

    for(int i=1;i<n;i++)
    {
        if(arr[i]>minmax.max){
            minmax.max = arr[i];
        }
        if(arr[i]<minmax.min){
            minmax.min = arr[i];
        }
    }
    return minmax;
    
}

int main(){
    int arr[] = {1,2,3,4,5,6,-4,6,3,5,6,6,7,8,9,0,2,3,4,323,34,345,345,34,34,34,5,5,345,345,345,23,5,6,766,7,46,56,46,47,56,756,756,7,76,5234,52,35,3,6};
    int size = sizeof(arr)/sizeof(arr[0]);
    struct Pair getminmax2 = getminmax(arr , size);

    cout<<size<<endl;
    cout<<getminmax2.min<<endl;
    cout<<getminmax2.max<<endl;
}