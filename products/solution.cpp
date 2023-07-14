#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(){

    int n;
    cin>>n;

    vector<int> v(n);
    for(auto & i : v)
        cin>>i;

    vector<pair<int, int>> vec;

    int st = n-1;
    vector<int> ones;
    for(int i=n-1; i>=0; i--){
        if(v[i]==1){
            ones.pb(i);
            vec.pb({i+1, st+1});
            st--;
        }
    }

    for(int i=n-1; i>=0; i--){
        if(v[i]==2){
            auto it = upper_bound(ones.begin(), ones.end(), i);
            
        }
    }

    return 0;
}