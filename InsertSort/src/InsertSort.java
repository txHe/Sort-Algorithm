
public class InsertSort {
	public static void main(String[] args)
	{
		int number1[] = {36,20,18,10,60,25,30,18,12,56};
		System.out.println("排序的数字表：");
		for(int i=0;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		/*------------------直接插入排序-----------------*/
		System.out.println("\n直接插入排序：");
		DirectInsert(number1);
		for(int i=0;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		
		/*------------------折半插入排序-----------------*/
		int number2[] = {36,20,18,10,60,25,30,18,12,56};
		System.out.println("\n折半插入排序：");
		BInsert(number2);
		for(int i=0;i<number2.length;i++)
		{
			System.out.print(number2[i]);
			System.out.print(" ");
		}
		
		/*------------------希尔排序-----------------*/
		int number3[] = {36,20,18,10,60,25,30,18,12,56};
		int d[] = {5,3,1};
		
		System.out.println("\n希尔排序：");
		HillInsert(number3,d);
		for(int i=0;i<number3.length;i++)
		{
			System.out.print(number3[i]);
			System.out.print(" ");
		}
		
	}
	//希尔排序
	/*当n在某个范围内（即排序表数量有限制），希尔排序所需的比较次数和移动次数约为n^1.3
	当然，关键码的比较次数和记录移动次数还依赖于步长因子序列的选取，特定情况下可以准确估算出关键码的比较次数
	和移动次数。*/
	public static void HillInsert(int[] R,int[] d)
	{
		int i,j,k,h,c;
		for(k=0;k<d.length;k++)
		{
			h=d[k]; //本趟的增量
			for(i=h;i<R.length;i++)
			{
				if(R[i]<R[i-h])
				{
					c=R[i];
					for(j=i-h;j>=0&&c<R[j];j=j-h)
					{
						R[j+h]=R[j];
					}
					R[j+h]=c;
				}
			}
		}
	}
	
	//直接插入排序 排序数组：36 20 18 10 60 25 30 18 12 56
	//空间复杂度：O(1);时间复杂度：O(n^2)
	public static void DirectInsert(int[] R)
	{
		int i=0,j=0,c=0;
		for(i=1;i<R.length;i++)
		{
			if(R[i]<R[i-1])
			{
				c=R[i];
				for(j=i-1;c<R[j];j--)
				{
					
					R[j+1]=R[j];
					if(j==0)
					{
						j=-1;
						break;
					}
				}
				R[j+1]=c;
			}
		}
	}
	//折半插入排序
	//空间复杂度：O(1);时间复杂度：O(n^2）
	public static void BInsert(int[] R)
	{
		int i,j,low,high,mid,c;
		for(i=1;i<R.length;i++)
		{
			c=R[i];
			low=0;
			high=i-1;
			while(low<=high)
			{
				mid=(low+high)/2;
				if(c<R[mid])
				{
					high=mid-1;
				}
				else
				{
					low=mid+1;
				}
			}
			for(j=i-1;j>high;j--)
			{
				R[j+1]=R[j];
			}
			R[high+1]=c;
		}
	}
	
}


