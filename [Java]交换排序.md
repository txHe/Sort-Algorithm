**交换排序的基本思想：**通过排序表中两个记录关键码的比较，若与排序要求相逆，则将二者进行交换，直至没有反序的记录为止。交换排序的特点是：排序码值较小的记录向序列的一端移动，排序码值较大的记录向序列的另一端移动。

####1、冒泡排序
设排序表为R[1]....R[n]，对n个记录的排序表进行冒泡排序（Bubble Sort）的过程是：第一趟，从第一个记录开始到第n个记录，对n-1对相邻的两个记录关键字进行比较，若与排序要求相逆，则将二者交换，这样，一趟过后，具有最大关键字的记录交换到R[n]；第2趟，从第1个记录开始到第n-1个记录继续进行第二趟冒泡，两趟过后，具有次最大关键字的记录交换到了R[n-1]……如此重复。n-1趟过后，在R[1]....R[n]中，n个记录按关键字码有序。
####2、快速排序
快速排序的核心操作是划分。以某个记录为标准（也称为支点），通过划分将待排序列分成两组，其中一组中的记录的关键码均大于或等于支点记录的关键码，另一组中的所有记录的关键码小于支点记录的关键码，则支点记录就放在两组之间，这也是该记录最终位置。

**Java代码（可直接使用）：**

```

public class SwapSort {
	public static void main(String[] args)
	{
		int number1[] = {36,20,18,10,60,25,30,18,12,56};
		System.out.println("排序的数字表：");
		for(int i=0;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		/*--------------冒泡排序---------------*/
		BubbleSort(number1);
		System.out.println("\n冒泡排序：");
		for(int i=0;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		
		int number2[] = {36,20,18,10,60,25,30,18,12,56};
		/*--------------快速排序---------------*/
		QuickSort(number2,0,number2.length-1);
		System.out.println("\n快速排序：");
		for(int i=0;i<number2.length;i++)
		{
			System.out.print(number2[i]);
			System.out.print(" ");
		}
	}
	//快速排序
	public static void QuickSort(int[]R,int s,int t)
	{
		int i;
		if(s<t)
		{
			i=Partition(R,s,t);
			QuickSort(R,s,i-1);
			QuickSort(R,i+1,t);
		}
	}
	//划分算法
	public static int Partition(int[] R,int low,int high)
	{
		int c;
		c=R[low];
		while(low<high)
		{
			while(low<high&&R[high]>=c)
			{
				high--;
			}
			if(low<high)
			{
				R[low]=R[high];
				low++;
			}
			while(low<high&&R[low]<c)
			{
				low++;
			}
			if(low<high)
			{
				R[high]=R[low];
				high--;
			}
		}
		R[low]=c;
		return low;
	}
	
	//冒泡排序
	//空间复杂度O(1);时间复杂度O(n^2);
	public static void BubbleSort(int[] R)
	{
		int i,j,c,swap;
		for(i=1;i<R.length;i++)
		{
			swap=0;
			for(j=0;j<R.length-i;j++)
			{
				if(R[j]>R[j+1])
				{
					c=R[j];
					R[j]=R[j+1];
					R[j+1]=c;
					swap=1;
				}
			}
			if(swap==0)
			{
				break;
			}
		}
	}
}

```
![这里写图片描述](http://img.blog.csdn.net/20150529210855415)