package exercise;
//29. 两数相除
//尝试过
//中等
//相关标签
//相关企业
//给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
//
//整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
//
//返回被除数 dividend 除以除数 divisor 得到的 商 。
//
//注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
//
//
//
//示例 1:
//
//输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
//示例 2:
//
//输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
//
//
//提示：
//
//-231 <= dividend, divisor <= 231 - 1
//divisor != 0
class Solution {
    public static void main(String[] args) {
        int i = -2147483648 >> 1;
        System.out.println(divide(1981445587, 1172010393));
    }
    public static   int divide(int dividend, int divisor) {
        int absDividend = dividend;
        int absDivisor = divisor;
// 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        if (dividend>0){
            absDividend = -dividend;
        }
        if (divisor>0){
            absDivisor = -divisor;
        }
        boolean flag = dividend<0 == divisor<0 ;
        int res = 0;
        while (absDividend<=absDivisor){
            int r = -1;
            int tabsDivisor = absDivisor;
            //1073741824
            while (absDividend<=tabsDivisor){
                if (tabsDivisor<(Integer.MIN_VALUE>>1)){
                    break;
                }
                tabsDivisor += tabsDivisor;
                r += r;
            }

            res = res+(r>>1);
            if (tabsDivisor == absDivisor){
                absDividend = absDividend - tabsDivisor;
            }else {
                absDividend = absDividend - (tabsDivisor >> 1);

            }
        }

        if (flag){
            return -res;
        }else {
            return res;
        }

    }
}