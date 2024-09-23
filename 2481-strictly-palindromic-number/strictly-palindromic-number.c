
char *intToAnyBaseString(int n, int base){
    char *str = (char *)malloc(100001);
    int ptr = 0;
    str[ptr] = '\0';
    while(n > 0){
        int rem = n%base;
        n = n/base;
        str[ptr++] = rem +'0';
    }
    int size = strlen(str);
    int s = 0;
    int e = size-1;
    while(s>e){
        char temp = str[s];
        str[s] = str[e];
        str[e] = temp;
    }
    return str;
}

bool isPalindrome(char *str){
    int n = strlen(str);
    int st = 0;
    int e = n-1;
    while(st < e){
        if(str[st] != str[e]){
            return false;
        }
    }
    return true;
}


bool isStrictlyPalindromic(int n) {
    for(int i =2;i<=n-2;i++){
        char *str = intToAnyBaseString(n,i);
        if(isPalindrome(str) == false ){
            return false;
        }
    }
    return true;
    
}
