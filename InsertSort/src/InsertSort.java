
public class InsertSort {
	public static void main(String[] args)
	{
		int number1[] = {36,20,18,10,60,25,30,18,12,56};
		System.out.println("��������ֱ�");
		for(int i=0;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		/*------------------ֱ�Ӳ�������-----------------*/
		System.out.println("\nֱ�Ӳ�������");
		DirectInsert(number1);
		for(int i=0;i<number1.length;i++)
		{
			System.out.print(number1[i]);
			System.out.print(" ");
		}
		
		/*------------------�۰��������-----------------*/
		int number2[] = {36,20,18,10,60,25,30,18,12,56};
		System.out.println("\n�۰��������");
		BInsert(number2);
		for(int i=0;i<number2.length;i++)
		{
			System.out.print(number2[i]);
			System.out.print(" ");
		}
		
		/*------------------ϣ������-----------------*/
		int number3[] = {36,20,18,10,60,25,30,18,12,56};
		int d[] = {5,3,1};
		
		System.out.println("\nϣ������");
		HillInsert(number3,d);
		for(int i=0;i<number3.length;i++)
		{
			System.out.print(number3[i]);
			System.out.print(" ");
		}
		
	}
	//ϣ������
	/*��n��ĳ����Χ�ڣ�����������������ƣ���ϣ����������ıȽϴ������ƶ�����ԼΪn^1.3
	��Ȼ���ؼ���ıȽϴ����ͼ�¼�ƶ������������ڲ����������е�ѡȡ���ض�����¿���׼ȷ������ؼ���ıȽϴ���
	���ƶ�������*/
	public static void HillInsert(int[] R,int[] d)
	{
		int i,j,k,h,c;
		for(k=0;k<d.length;k++)
		{
			h=d[k]; //���˵�����
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
	
	//ֱ�Ӳ������� �������飺36 20 18 10 60 25 30 18 12 56
	//�ռ临�Ӷȣ�O(1);ʱ�临�Ӷȣ�O(n^2)
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
	//�۰��������
	//�ռ临�Ӷȣ�O(1);ʱ�临�Ӷȣ�O(n^2��
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


