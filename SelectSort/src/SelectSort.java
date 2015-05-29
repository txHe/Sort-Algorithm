
public class SelectSort {
	public static void main(String[] args)
	{
		int number1[] = {36,20,18,10,60,25,30,18,12,56};
		System.out.println("��������ֱ�");
		for(int i=0;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		/*-------------- ��ѡ������---------------*/
		SimpleSort(number1);
		System.out.println("\n��ѡ������");
		for(int i=0;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		
		int number2[] = {36,20,18,10,60,25,30,18,12,56};
		/*-------------- ������---------------*/
		SimpleSort(number2);
		System.out.println("\n������");
		for(int i=0;i<number2.length;i++)
		{
			System.out.print(number2[i]);
			System.out.print(" ");
		}
	}
	
	//������
	//ʱ�临�Ӷȣ�P(nlogn)
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
	
	//ɸѡ�㷨
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
	
	//��ѡ������
	//�ռ临�Ӷȣ�O(1);ʱ�临�Ӷȣ�O(n^2)
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
