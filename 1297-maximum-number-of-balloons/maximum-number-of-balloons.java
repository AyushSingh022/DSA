class Solution {
    public int maxNumberOfBalloons(String text) {
        int b=0;
        int a=0;
        int l=0;
        int o=0;
        int n=0;
        for(char c:text.toCharArray()){
            if(c=='b')
            {
                b++;
            }
            else if(c=='a'){
                a++;
            }
            else if(c=='o'){
                o++;
            }
            else if(c=='n'){
                n++;
            }
            else if(c=='l'){
                l++;
            }
        }
        return Math.min(Math.min(b,a),Math.min(Math.min(l/2,o/2),n));
    }
}