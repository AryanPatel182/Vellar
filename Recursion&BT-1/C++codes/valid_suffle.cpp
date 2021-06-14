#include<stdio.h>
#include<iostream>

using namespace std ;

int isvalid(string s1, string s2, string s3)
{
    int l1 = s1.length();
    int l2 = s2.length();
    int l3 = s3.length();

    if(l1+l2 != l3) return 0;

    int p1 = 0 ,p2 = 0 , p3 = 0 ;
    while(p3<l3)
    {
        if(s3[p3] == s1[p1]) 
            p1++;
        else if(s3[p3] == s2[p2])
            p2++;
        else break;
        p3++;
    }

    if(p1<l1 || p2<l2) return 0;
    return 1;
    
}


int main()
{
    string s1,s2,res;
    cin>>s1>>s2>>res;

    if(isvalid(s1,s2,res)) cout<<"Yes"<<endl;
    else cout<<"No"<<endl;
    return 0;
}