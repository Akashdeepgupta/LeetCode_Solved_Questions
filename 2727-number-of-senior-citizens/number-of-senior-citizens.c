int countSeniors(char ** details, int detailsSize){
    int c = 0;
    for(int i=0;i<detailsSize;i++){
        char t[3];
        t[0] = details[i][11];
        t[1] = details[i][12];
        t[2] = '\0';

        int age = atoi(t);
        if(age > 60){
            c++;
        }
    }
    return c;
}