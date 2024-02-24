class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            boolean x = false, y = false, z = false;
            if((a & (1 << i)) != 0){
                x = true;
            }
            if((b & (1 << i)) != 0){
                y = true;
            }
            if((c & (1 << i)) != 0){
                z = true;
            }

            if(z == false){
                if(x == true && y == true){
                    res += 2;
                }else if(x == true || y == true){
                    res++;
                }
            }else{
                if(x == false && y == false){
                    res++;
                }
            }
        }
        return res;
    }
}