package mid;

/**
 * @author chenz at 13:53 on 2022/3/13 .
 */
public class L393 {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i]&0XFF;
            if ((data[i]&0XF8)==0XF8){
                return false;
            }
            if (data[i]<0X80){
                continue;
            }
            if ((data[i]&0XF0)==0XF0){ //11110
                int t=0;
                while (t<3){
                    i++;
                    if (i>=data.length){
                        return false;
                    }
                    data[i]=data[i]&0XFF;
                    if (data[i]<0X80||data[i]>=0XC0){
                        return false;
                    }
                    t++;
                }

            }else if ((data[i]&0XE0)==0XE0){//11100
                int t=0;
                while (t<2){
                    i++;
                    if (i>=data.length){
                        return false;
                    }
                    data[i]=data[i]&0XFF;
                    if (data[i]<0X80||data[i]>=0XC0){
                        return false;
                    }
                    t++;
                }
            }else if ((data[i]&0XC0)==0XC0){
                i++;
                if (i>=data.length){
                    return false;
                }
                data[i]=data[i]&0XFF;
                if (data[i]<0X80||data[i]>=0XC0){
                    return false;
                }
            }else {
                return false;
            }

        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println(0X80);
        System.out.println(0XC0);
        System.out.println(0XE);
        System.out.println(0XF8);
    }
}
