public class BinaryHeap 
{
	private int size;
	private int[] arr;

	public BinaryHeap() 
	{
		arr = new int[10];
		size = 0;
	}

	public int left_child(int parent) 
	{
		return (2 * parent) + 1;
	}

	public int right_child(int parent) 
	{
		return (2 * parent) + 2;
	}

	public int parent(int child) 
	{
		return (child - 1) / 2;
	}

	public void add(int data) 
	{
		if (size >= arr.length) 
		{
			growArr();
		}
		
		int current = size;
		arr[size] = data;
		size++;
		
		while (arr[current] < arr[parent(current)]) 
		{
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public int remove() throws Exception 
	{
		if (size == 0)
			throw new Exception("EMPTY HEAP!");
		
		int current = arr[0];
		size--;
		swap(0, size);
		if (size != 0) 
		{
			shiftdown(0);
		}
		return current;
	}

	private void shiftdown(int index) 
	{
		if (left_child(index) >= size) 
		{
			return;
		}
		int child = left_child(index);
		if (arr[child] > arr[right_child(index)] && right_child(index) < size) 
		{
			child = right_child(index);
		}
		if (arr[index] > arr[child]) 
		{
			swap(child, index);
			shiftdown(child);
		}
	}

	private void swap(int child, int parent) 
	{
		int temp = 0;
		temp = arr[child];
		arr[child] = arr[parent];
		arr[parent] = temp;
	}

	private void growArr() 
	{
		int[] newarr = new int[arr.length * 2];
		System.arraycopy(arr, 0, newarr, 0, arr.length);
		arr = newarr;
	}
}