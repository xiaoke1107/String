package cfca.paperless.base.logback;

import com.sun.jna.platform.mac.SystemB;

import java.util.ArrayList;
import java.util.Arrays;

public class A {
        public static void main (String[]args){

            String str = "1+2*3+4/2-3";
            String[] split = str.split("\\+");
            int[] nums = new int[split.length];
            for (int i = 0;i<split.length;i++) {
                if (split[i].length() == 1){
                    nums[i] = Integer.parseInt(split[i]);
                }else if (split[i].length()>1 && !split[i].contains("-")){
                    int b = 1;
                    for (int a = 0;a<split[i].length()-1;a++){
                        if (split[i].charAt(a+1) == '*'){
                            b = b * Integer.parseInt(String.valueOf(split[i].charAt(a))) * Integer.parseInt(String.valueOf(split[i].charAt(a+2)));
                        }
                        if (split[i].charAt(a+1) == '/'){
                            b = b * Integer.parseInt(String.valueOf(split[i].charAt(a))) / Integer.parseInt(String.valueOf(split[i].charAt(a+2)));
                        }
                    }
                    nums[i] = b;
                } else {
                    String[] split1 = split[i].split("-");
                    int[] a = new int[split1.length];
                    for (int c = 0;c<split1.length;c++){
                        if (split1[c].length()>1){
                            int d = 1;
                            for (int q = 0;q<split1[c].length()-1;q++){
                                if (split1[c].charAt(q+1) == '*'){
                                    d = d * Integer.parseInt(String.valueOf(split1[c].charAt(q))) * Integer.parseInt(String.valueOf(split1[c].charAt(q+2)));
                                }
                                if (split1[c].charAt(q+1) == '/'){
                                    d = Integer.parseInt(String.valueOf(split1[c].charAt(q))) / Integer.parseInt(String.valueOf(split1[c].charAt(q+2)));
                                }
                            }//同19-26行
                            a[c] = d;
                        }else {
                            a[c] = Integer.parseInt(split1[c]);
                        }
                    }
                    int c = 0;
                    for (int z = 1;z<a.length;z++ ) {
                        c = c + a[z];
                    }
                    nums[i] = a[0] - c;
                }
            }
            int answer = 0;
            for (int num : nums) {
                answer = answer+num;
            }
            System.out.println(answer);

        }

}
