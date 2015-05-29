
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
