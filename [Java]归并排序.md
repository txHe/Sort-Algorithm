**归并排序的思想是：**将几个相邻的有序表合成一个总的有序表。
####1、两个有序表合并
二路归并排序的基本操作是将两个相邻的有序表合并成一个有序表。
####2、二路归并排序的迭代算法
二路归并的基本思想是：只有一个元素的表总是有序的，所以将排序表R[1...n]，看做是n个长度为len=1的有序子表，对相邻的两个有序字表两两合并到R1[1..n]，使之生成表长len=2的有序表；再进行两两合并到R[1..n]中，直到最后生成表长len=n的有序表。

**java代码及运行结果（可直接使用）：**

```

public class MergeSort {
	public static void main(String[] args)
	{
		int number1[]={1,3,5,7,9,2,4,6,8};
		System.out.println("排序的两个数字表：");
		System.out.print("(1) ");
		for(int i=0;i<5;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		System.out.print("\n(2) ");
		for(int i=5;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		int length=number1.length;
		int[] RS = new int[length];
		
		/*-------------- 两个有序表归并---------------*/
		System.out.println("\n两个有序表归并");
		Merge(number1,RS,0,4,8);
		for(int i=0;i<RS.length;i++)
		{
			System.out.print(RS[i]);
			System.out.print(" ");
		}
		
		
		int number2[]={1,3,5,7,9,2,4,6,8};
		int[] RX = new int[length];
		/*-------------- 二路归并---------------*/
		System.out.println("\n二路归并");
		Merge_Sort(number2,RX);
		for(int i=0;i<RX.length;i++)
		{
			System.out.print(RX[i]);
			System.out.print(" ");
		}
	}
	
	//归并排序
	//空间复杂度为O(n);时间复杂度为(nlogn)
	public static void Merge_Sort(int[] R,int[] RS)
	{
		int len=1;
		while(len<R.length)
		{
			MergePass(R,RS,len);
			len=2*len;
			MergePass(RS,R,len);
		}
	}
	
	public static void MergePass(int[] R,int[] RS,int len)
	{
		int i;
		for(i=0;i+2*len-1<=R.length-1;i=i+2*len)
		{
			Merge(R,RS,i,i+len-1,i+2*len-1);
		}
		if(i+len-1<R.length-1)
		{
			Merge(R,RS,i,i+len-1,R.length-1);
		}
		else if(i<=R.length-1)
		{
			while(i<=R.length-1)
			{
				RS[i]=R[i];
				i++;
			}
		}
	}
	
	public static void Merge(int[] R,int[] RS,int s,int m,int t)
	{
		int i,j,k;
		i=s;
		j=m+1;
		k=s;
		while(i<=m&&j<=t)
		{
			if(R[i]<R[j])
			{
				RS[k++]=R[i++];
			}
			else
			{
				RS[k++]=R[j++];
			}
		}
		while(i<=m)
		{
			RS[k++]=R[i++];
		}
		while(j<=t)
		{
			RS[k++]=R[j++];
		}
	}
}

```
![这里写图片描述](http://img.blog.csdn.net/20150529213018112)