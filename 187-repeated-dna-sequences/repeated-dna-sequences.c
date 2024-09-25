/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

char** findRepeatedDnaSequences(char* s, int* returnSize) {
    int hash[1048577];
    memset(hash,0,sizeof(hash));
    int n = strlen(s);
    int ptr = 0;
    char **sol = (char **)malloc(10000*sizeof(char *));
    
    for(int i = 0;i<n-9;i++){
        int total = 0;
        for(int j = i;j<i+10;j++){
            if(s[j] == 'A'){
                total = total + 0*pow(4,(j-i));
            }
            if(s[j] == 'C'){
                total = total + 1*pow(4,(j-i));
            }
            if(s[j] == 'G'){
                total = total + 2*pow(4,(j-i));
            }
            if(s[j] == 'T'){
                total = total + 3*pow(4,(j-i));
            }
        }
        hash[total]++;

        if(hash[total] == 2){
            sol[ptr] = (char *)malloc(11*sizeof(char));
            strncpy(sol[ptr],&s[i],10);
            sol[ptr][10] = '\0';
            ptr++;
        }
    }
    
    *returnSize = ptr;
    return sol;

}

