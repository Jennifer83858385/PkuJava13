/*Author:李建锋
*Time：10.30
*Question：最小栈的设计与实现
*Tips:最小值的重新选取
*/
class MinStack {
    private int top=-1;
    private ArrayList<Integer>list = new ArrayList<Integer>();
    private int min=Integer.MAX_VALUE;
    public void push(int x) {
        list.add(x);
        top++;
        if(x<min)min=x;
    }

    public void pop() {
        if(top()==min){
          list.remove(top--);
          min=Integer.MAX_VALUE;
           for(int temp:list){
               if (temp<min)min=temp;
           }
        }
        else list.remove(top--);
          
       
    }

    public int top() {
        return list.get(top);
    }

    public int getMin() {
         return min;
    }
}
