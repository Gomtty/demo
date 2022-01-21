package com.myoi.exer5;

/**
 * @author myoi
 * @date 2021/12/9 - 14:28
 */
public class EcmDef {

    public static void main(String[] args) {
        EcmDef ecmDef = new EcmDef();
//        int i=;
//        int j=;
        try {
            int ecm = ecmDef.ecm(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            System.out.println(ecm);
        } catch (EcDef e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("除零异常");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("下标越界异常");
        } catch (NumberFormatException e) {
            System.out.println("数据格式异常");
        }
    }

    public int ecm(int i, int j) throws EcDef, ArithmeticException {
        if (i < 0 || j < 0) {
            throw new EcDef("负数异常");
        }
        return i / j;
    }

}

//负数异常类
class EcDef extends Exception {
    static final long serialVersionUID = -3387516993124456948L;

    public EcDef() {
    }

    public EcDef(String message) {
        super(message);
    }
}