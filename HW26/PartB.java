/* output:
Before: 0
After: 0
The parameter value shadows the instance 
variable value, so value = value; only assigns 
the parameter to itself. The instance variable 
never changes and stays the default int value, 
0. This matches the lesson explanation of using 
this to refer to the object’s instance variable. */

/*fix     class Item {
    private int value;

    public void setValue(int value) {
        this.value = value;  
    }

    public int getValue() {
        return value;
    }
}
}
*/
