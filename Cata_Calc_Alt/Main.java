import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws LimitExceededException {
        System.out.println("Ввод");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\"" + calcM(scanner.nextLine().replace("\"", "")) + "\"");
    }

    public static String calcM( String s) throws LimitExceededException {
        String splitter = null;
        boolean sign1 = s.contains("-");
        boolean sign2 = s.contains("+");
        boolean sign3 = s.contains("*");
        boolean sign4 = s.contains("/");
        if (sign2) {
            splitter = " \\+ ";
            String[] arPlus = s.split(splitter);
            //System.out.println(Arrays.toString(arPlus));
            String aPlus = arPlus[0];
            String bPlus = arPlus[1];
            String check = aPlus + bPlus;
            if (aPlus.length()>10 ){
                throw new LimitExceededException();
            } else if (bPlus.length()>10) {
                throw new LimitExceededException();

            }
            return aPlus + bPlus;
        } else if (sign3) {
            splitter = " \\* ";
            String[] arPlus = s.split(splitter);
            //System.out.println(Arrays.toString(arPlus));
            String aPlus = arPlus[0];
            String bPlus = arPlus[1];
            try {
                int m = Integer.parseInt(bPlus);
                String check = aPlus.repeat(m);
                String[] sCalcP = new String[40];
                char[] upperThen40 = check.toCharArray();
                if (aPlus.length()>10){
                    throw new LimitExceededException(aPlus);
                } else if (Integer.parseInt(bPlus)>10 || Integer.parseInt(bPlus)<1) {
                    throw new LimitExceededException(bPlus);
                } else if (check.length()>40) {
                    String endCheck = null;
                    for (int t = 0; t < 40; t += 1) {
                        sCalcP[t] = String.valueOf(upperThen40[t]);
                        endCheck = String.join("", sCalcP);
                    }
                    return endCheck + "...";
                }
                return aPlus.repeat(m).replace("\"", "");

            } catch (NumberFormatException e) {
                throw new RuntimeException("Try to use:" + "\"" + bPlus + "\"" + " * " + "\"" + aPlus + "\"");
            }

        } else if (sign1) {
            splitter = " - ";
            String[] arPlus = s.split(splitter);
            //System.out.println(Arrays.toString(arPlus));
            String aPlus = arPlus[0];
            String bPlus = arPlus[1];
            return aPlus.replace(bPlus,"");
        } else if (sign4) {
            splitter = " / ";
            String bPlus = null;
            String aPlus = null;
            String[] arPlus = s.split(splitter);
            char[] chars = null;
            try {

                //System.out.println(Arrays.toString(arPlus));
                bPlus = arPlus[1];
                chars = arPlus[0].toCharArray();
                //System.out.println(chars);
                int pom = chars.length / Integer.parseInt(bPlus);
                String[] sCalc = new String[pom];
                String asd = null;
                for (int i = 0; i < pom; i++) {
                    sCalc[i] = String.valueOf(chars[i]);
                    asd = String.join("", sCalc);
                }

                return asd;
            } catch (NumberFormatException e) {
                throw new RuntimeException("Try to use:" + "\"" + bPlus + "\"" + " / " + arPlus[0] );
            }
        }
        throw new RuntimeException(splitter);
    }
}
//        System.out.println(s);
//        String[] p;
//        p =  s.split(splitter);
//        System.out.println(Arrays.toString(p));
//        String a = p[0];
//        System.out.println(a);
//        String b = p[2];
//        String sign = p[1];
//        if (sign.contains("*")){
//        try {
//            int c = Integer.parseInt(b);
//            return a.repeat(c).replace("\"", "");
//
//        } catch (NumberFormatException e) {
//            throw new RuntimeException(e);
//
//        }
//        } else if (sign.contains("+")) {
//            return a+b;
//        } else if (sign.contains("-")) {
////            String[] d = new String[]{p[0]};
////            String[] g = new String[]{p[2]};
//            return a.replace(b,"");
////            System.out.println(Arrays.toString(d));
////            System.out.println(Arrays.toString(g));
//
//
//        }

//    public static boolean nums(String s) throws NumberFormatException {
//        try{
//            Integer.parseInt(s);
//            return true;
//
//        } catch (NumberFormatException exception) {
//            throw new NumberFormatException(s);
//        }
//
//    }


