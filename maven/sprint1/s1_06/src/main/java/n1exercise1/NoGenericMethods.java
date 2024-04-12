package n1exercise1;

public class NoGenericMethods {
    private Object object1;
    private Object object2;
    private Object object3;

    public NoGenericMethods(Object obj1, Object obj2, Object obj3) {
        object1 = obj1;
        object2 = obj2;
        object3 = obj3;
    }

    public void setObject1(Object obj) {
        object1 = obj;
    }

    public void setObject2(Object obj) {
        object2 = obj;
    }

    public void setObject3(Object obj) {
        object3 = obj;
    }

    public Object getObject1() {
        return object1;
    }

    public Object getObject2() {
        return object2;
    }

    public Object getObject3() {
        return object3;
    }
}
