#define MAX(a, b) ((a) > (b) ? (a) : (b))
int maxScore(char* s) {
    int n = strlen(s); //length of the string
    int ans = 0; // for storing answer

    int prefixArray[n]; // prefix Array
    int suffixArray[n]; // Suffix Array

    //creating prefix Array
    if(s[0]=='0'){
        prefixArray[0] = 1;
    }else{
        prefixArray[0] = 0;
    }

    for(int i = 1;i<n;i++){
        int val = s[i]-'0';
        if(val == 0){
            prefixArray[i] = prefixArray[i-1]+1;
        }else{
            prefixArray[i] = prefixArray[i-1];
        }
    }


    // creating suffix array
    if(s[n-1]=='1'){
        suffixArray[n-1] = 1;
    }else{
        suffixArray[n-1] = 0;
    }

    for(int i = n-2;i>=0;i--){
        int val = s[i]-'0';
        if(val == 1){
            suffixArray[i] = suffixArray[i+1] + 1;
        }
        else{
            suffixArray[i] = suffixArray[i+1];
        }
    }

    //calculating score
    for(int i = 0;i<n-1;i++){
        ans =  MAX(ans,prefixArray[i]+suffixArray[i+1]);
    }
    for (int i = 0; i < n; i++) {
        printf("%d ", prefixArray[i]);
    }
    printf("\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", suffixArray[i]);
    }
    return ans;
}