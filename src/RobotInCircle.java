public class RobotInCircle {
    static int x=0,y=0;
    static int d=0;
    public static void main(String[] args) {
        String s="GLLRG";
        if(checkIfMovesInCircle(s)){
            System.out.println("in circle");
        }
        else{
            System.out.println("Not in circle");
        }
    }

    public static boolean checkIfMovesInCircle(String s){
        for(int i=0; i<s.length(); i++){
            checkMove(s.charAt(i));
        }
        return (x==0 && y==0);
    }

    public static void checkMove(Character c){
        if(c=='R'){
            d=(d+1)%4;
        }
        if(c=='L'){
            d=(4+d-1)%4;
        }
        else{
            if(d==0){
                y++;
            }else if(d==1){
                x++;
            }else if(d==2){
                y--;
            }else if(d==3){
                x--;
            }
        }
    }
}
