package ProgramaticInterviewQuestions;
class Immutable {
    private int i;
    public static Immutable create(int i){
        return new Immutable(i);
    }
    private Immutable(int i){
    	this.i = i;
    }
    public int getI(){
    	return i;
    }
}
public class ImmutableMainWithOutFinal {
	public static void main(String[] args) {
		System.out.println(Immutable.create(1));
		System.out.println(Immutable.create(1));
	}
}
