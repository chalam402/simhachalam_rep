package CreationalDesignPattern;
interface Button {
    public void paint();
}
class WindowsButton implements Button {
    @Override
    public void paint() {
        /** add code to paint windows button **/
        System.out.println("painting windows button...");
    }
}
class MacButton implements Button {
    @Override
    public void paint() {
        /** add code to paint MAC OS button **/
        System.out.println("painting MAC OS button...");
    }
}
interface ButtonFactory {
    public Button createButton();
}
class WindowsFactory implements ButtonFactory {
    @Override
    public Button createButton() {
        /**
         * this method creates a button for windows 
         * button
         */
        System.out.println("creating windows button...");
        return new WindowsButton();
    }
}
class MacOsFactory implements ButtonFactory {
    @Override
    public Button createButton() {
        /**
         * this method creates a button for MAC OS 
         * button
         */
        System.out.println("creating mac os button...");
        return new MacButton();
    }
}
class GUIFactory {
    private GUIFactory(){
        //make private constructor..
    }
    public static Button createButton(){
        String os = null;
        /**
         * this method should work based on the operating system
         * it is running on. First we need to decide which operating 
         * system is it.
         * 
         * for the example purpose, i will hardcode OS as windows.
         */
        os = "windows"; //this is hardcoded value. it should be assigned with dynamic logic.
        if("windows".equalsIgnoreCase(os)){
            return new WindowsFactory().createButton();
        } else if("mac".equalsIgnoreCase(os)){
            return new MacOsFactory().createButton();
        }
        return null;
    }
}
public class AbstractFactoryTest_3 {
    public static void main(String a[]){
        Button btn = GUIFactory.createButton();
        btn.paint();
    }
}
