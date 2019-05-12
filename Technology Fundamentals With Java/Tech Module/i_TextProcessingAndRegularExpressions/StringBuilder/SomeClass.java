package i_TextProcessingAndRegularExpressions.StringBuilder;

public class SomeClass {
    private StringBuilder sb;

    public SomeClass(StringBuilder sb){
        this.sb = sb;
    }

    public String getContent(){
        return this.sb.toString();
    }

    public StringBuilder getSb() {
        return sb;
    }
}
