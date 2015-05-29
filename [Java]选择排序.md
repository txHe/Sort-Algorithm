选择排序主要是每一趟从待排序列中选取一个关键码最小的记录，也即第一趟从n个记录中选取关键码最小的记录，第二趟从剩下的n-1个记录中选取关键码最小的记录，直到整个序列的记录选完。这样，由选取记录的顺序，便得到按关键码有序的序列。
####1、简单选择排序
简单选择排序的过程为：第1趟，从n记录中找出关键码最小的记录与第一个记录交换，第2趟，从第二个记录开始的n-1个记录中再选取关键码最小的记录与第2个记录交换；如此，第i趟，则从第i个记录开始的n-i+1个记录中选出关键码最小的记录与第i个记录交换，直到整个序列按关键码有序。
####2、堆排序
堆分为大顶堆和小顶堆。
以大顶堆为例，由堆的特点可知，虽然序列中的记录无序，但在大顶堆中，堆顶记录的关键码最大，因此首先将这n个元素排序表按照关键码建成堆（称为初始堆），将堆顶记录R1输出，再将剩下的n-1个记录调整成堆。为了更多的继承原来堆的特性，不是对R2....Rn进行调整，而是将原堆底元素Rn移入堆顶位置，对R1...Rn-1进行调整。这样，调整背景是：只有R1与其左、右孩子之间可能不满足堆特性，而其他地方均满足堆特性。调整成堆之后，继续问题的重复。如此反复，可以得到一个按关键码有序的序列。这个过程称之为堆排序。
**java代码及运行结果（可直接使用）：**

```

public class SelectSort {
	public static void main(String[] args)
	{
		int number1[] = {36,20,18,10,60,25,30,18,12,56};
		System.out.println("排序的数字表：");
		for(int i=0;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		/*-------------- 简单选择排序---------------*/
		SimpleSort(number1);
		System.out.println("\n简单选择排序：");
		for(int i=0;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		
		int number2[] = {36,20,18,10,60,25,30,18,12,56};
		/*-------------- 堆排序---------------*/
		SimpleSort(number2);
		System.out.println("\n堆排序：");
		for(int i=0;i<number2.length;i++)
		{
			System.out.print(number2[i]);
			System.out.print(" ");
		}
	}
	
	//堆排序
	//时间复杂度：P(nlogn)
	public static void HeaoSort(int[] R)
	{
		int i,j,c;
		for(i=(R.length-1)/2;i>=0;i--)
		{
			HeapAdjust(R,i,R.length-1);
		}
		for(j=R.length-1;j>0;j--)
		{
			c=R[0];
			R[0]=R[j];
			R[j]=c;
			HeapAdjust(R,0,j-1);
		}
	}
	
	//筛选算法
	public static void HeapAdjust(int[] R,int s,int t )
	{
		int c,i,j;
		c=R[s];
		i=s;
		for(j=2*i+1;j<=t;j++)
		{
			if(j<t&&R[j]<R[j+1])
				j=j+1;
			if(c>=R[j])
			{
				break;
			}
			R[i]=R[j];
			i=j;
		}
		R[i]=c;
	}
	
	//简单选择排序
	//空间复杂度：O(1);时间复杂度：O(n^2)
	public static void SimpleSort(int[] R)
	{
		int i,j,k,c;
		for(i=0;i<R.length-1;i++)
		{
			k=i;
			for(j=i+1;j<R.length;j++)
			{
				if(R[j]<R[k])
				{
					k=j;
				}
			}
			if(k!=i)
			{
				c=R[i];
				R[i]=R[k];
				R[k]=c;
			}
		}
	}
}

```
![这里写图片描述](http://img.blog.csdn.net/20150529212227388)