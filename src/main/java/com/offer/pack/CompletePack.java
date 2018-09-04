package com.offer.pack;

/**
 * Created by zhangcheng on 2018/8/28.
 */
public class CompletePack {

    public static int w[] = new int[15],n[] = new int[15],f[] = new int[5000000],V;

    static void ZeroOnePack(int cost,int weight)//01背包
    {
        int v;
        for(v=V;v>=cost;v--)
            if(f[v]<f[v-cost]+weight)
                f[v]=f[v-cost]+weight;
    }

    static void CompletePack(int cost,int weight)//完全背包
    {
        int v;
        for(v=cost;v<=V;v++)
            if(f[v]<f[v-cost]+weight)
                f[v]=f[v-cost]+weight;
    }

    static void MultiplePack(int cost,int weight,int amount)//多重背包
    {
        int k;
        if (cost*amount>=V)
        {
            CompletePack(cost,weight);
            return;
        }
        k=1;
        while(k<amount)
        {
            ZeroOnePack(k*cost,k*weight);
            amount=amount-k;
            k=k*2;//分割
        }
        ZeroOnePack(amount*cost,amount*weight);
    }

    public static void main(String[] args)
    {
        int i,j,sum;
        int[] a = {0,5,4,2,4};
        sum=0;j=1;
        for(i=1;i<=4;i++)
        {
            sum+=a[i]*i;
            if(a[i] > 0)
            {
                w[j]=i;
                n[j]=a[i];
                j++;
            }
        }
        V=sum/2;
        for(i=1;i<j;i++)
            MultiplePack(w[i],w[i],n[i]);
    }
}
