import java.util.*;

public class HeapSort{

    
    public static void heapify(int arr[],int i, int size){
        
        int leftChild=2*i+1;
        int rightChild=2*i+2;
        int maxIdx=i;
    
        if(leftChild<size && arr[leftChild]>arr[maxIdx]){
            maxIdx=leftChild;
        }
        if(rightChild<size && arr[rightChild]>arr[maxIdx]){
            maxIdx=rightChild;
        }
        if(maxIdx!=i){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            heapify(arr, maxIdx, size);
        }
    
    }
     
       
public static void heapSort(int arr[]){
//step1: Build max heap
int n =arr.length;
for(int i=n/2-1;i>=0;i--){
heapify(arr,i, n);
}

//step2: push largest at end
for(int i=n-1;i>=0;i--){
    //swap largest with last element in the heap
    int temp=arr[0];
    arr[0]=arr[i];
    arr[i]=temp;


    heapify(arr,0,i);
}

}

public static void main(String[] args){
    int arr[]={1,2,4,5,3};
    heapSort(arr);

    //print
    for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
    }
}

}