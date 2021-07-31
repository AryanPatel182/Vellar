#include <bits/stdc++.h>
using namespace std;

#define ll long long

int main()
{
    ll t;
    cin >> t;

    while (t--)
    {
        ll W, H;
        cin >> W >> H;

        ll x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;

        ll w2, h2;
        cin >> w2 >> h2;

        ll w1 = abs(x2 - x1);
        ll h1 = abs(y2 - y1);

        if (w1 + w2 > W && h1 + h2 > H)
        {
            cout << -1 << endl;
        }
        else if (h2 <= y1 || (H - y2) >= h2 || w2 <= x1 || w2 <= (W - x2))
        {
            cout<<0<<endl;
        }
        else if (w1 + w2 > W && h1 + h2 <= H)
        {
            ll yc = min((h2 - y1) < 0 ? 0 : (h2 - y1), (h2 - (H - y2)) < 0 ? 0 : (h2 - (H - y2)));
            // cout<<yc<<endl;
            cout << fixed << setprecision(9) << yc << endl;
        }
        else if( w1 + w2 <= W && h1 + h2 > H)
        {
            ll xc = min((w2 - x1) < 0 ? 0 : (w2 - x1), (w2 - (W - x2)) < 0 ? 0 : (w2 - (W - x2)));            
            // cout<<xc<<endl;
            cout << fixed << setprecision(9) <<xc<< endl;
        }
        else
        {
            ll xc = min((w2 - x1) <  0 ? 0 : (w2 - x1), (w2 - (W - x2)) < 0 ? 0 : (w2 - (W - x2)));
            ll yc = min((h2 - y1) < 0 ? 0 : (h2 - y1), (h2 - (H - y2)) < 0 ? 0 : (h2 - (H - y2)));

            // cout << xc << " " << yc << endl;            
            cout << fixed << setprecision(9) << min(xc,yc) << endl;
        }
    }
}