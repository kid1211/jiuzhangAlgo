class MyQueue {
  private int pointer;
  private ArrayList<Integer> elements;

  public MyQueue(){
    elements = new ArrayList();
    pointer = 0;
  }

  public Integer poll(){
    //return null if the elements is empty
    if (this.empty()) {
            return null;
        }
    return this.elements.get(pointer++);
  }

  public add(Integer i) {
    this.elements.add(i);
  }

  public int size() {
    return this.elements.size() - pointer;
  }

  public boolean isEmpty() {
    return size == 0;
  }
}
