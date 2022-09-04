package hard;

/**
 * @author chenz at 16:01 on 2022/4/9 .
 */
public class L780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx>sx&&ty>sy&&tx!=ty){
            if (tx>ty){
                tx %=ty;
            }else {
                ty %=tx;
            }
        }
        if (tx==sx&&ty==sy){
            return true;
        }else if (tx == sx){
            return ty>sy&&(ty-sy)%sx==0;
        }else if (ty == sy){
            return tx>sx&&(tx-sx)%sy==0;
        }else {
            return false;
        }
    }
}
