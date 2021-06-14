#include<stdio.h>
#include<iostream>
#include<unordered_map>
using namespace std;

void union_arr(int arr1[] , int arr2[] , int n1 , int n2)
{
    unordered_map<int, int> umap;
    for(int i=0;i<n1;i++)
    {
        umap[arr1[i]] = arr1[i];
    }
    for(int i = 0;i<n2;i++)
    {
        umap[arr2[i]] = arr2[i];
    }
    cout<<"Union : ";
    for (auto x : umap)
        cout << x.second << " ";
    cout<<endl;
}
void intersec_arr(int arr1[],int arr2[] ,int n1 ,int n2)
{
    cout << "Intersection : ";
    unordered_map<int, int> umap;
    for (int i = 0; i < n1; i++)
    {
        int key = arr1[i];
        if (umap.count(key))
            cout << arr1[i] << " ";
        else umap[arr1[i]] = arr1[i];
        
    }
    for (int i = 0; i < n2; i++)
    {
        int key = arr2[i];
        if (umap.count(key))
            cout << arr2[i] << " ";
        else
            umap[arr2[i]] = arr2[i];
    }

    cout << endl;
}

int main()
{
    int arr1[] = {0,1,3,43,44,32};
    int arr2[] = {0,123,4,44,2};
    int size1 = sizeof(arr1)/sizeof(arr1[0]);
    int size2 = sizeof(arr2) / sizeof(arr2[0]);
    
    union_arr(arr1,arr2,size1,size2);
    intersec_arr(arr1,arr2,size1,size2);

}