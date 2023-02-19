package leetcode.everyday.commit2023.february;

import java.util.HashSet;
import java.util.Set;

/**
 * 1792. 最大平均通过率
 */
public class Solution_202230219_1792 {

    static long a[]=new long[100001],b[]=new long[100001];static {a[0]=1l<<62;}
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n=classes.length,i=0,j,m;
        long x1,x2,x3,x4,x5;
        for(int c[]:classes){
            x1=c[0];x2=c[1];x1*=10000000;
            x3=(x1+10000000)/(x2+1)-x1/x2;
            x1<<=18;x1+=x2;
            for(m=j=++i;x3>a[j>>=1];a[m]=a[j],b[m]=b[j],m=j);
            a[m]=x3;b[m]=x1;
        }
        for(;--extraStudents>=0;){
            if ((x4=a[i])>(x3=a[1])){a[i]=x3;x1=b[1];b[1]=b[i];b[i]=x1;}
            x1=b[1]+2621440000001l;x2=x1&262143;x3=x1>>18;
            x3=(x3+10000000)/(x2+1)-x3/x2;
            for(j=1,m=2;m<i;m+=m){
                x4=a[m];x5=a[m+1];
                if (x4<x5) {x4=x5;++m;}
                if (x3>=x4) break;
                a[j]=x4;b[j]=b[m];j=m;
            }
            a[j]=x3;b[j]=x1;
        }
        for(x1=j=0;++j<=i;){
            x2=b[j];x3=x2&262143;x2>>=18;x2/=x3;x1+=x2;
        }
        x1/=n;
        return (double)x1*0.0000001;
    }
}
