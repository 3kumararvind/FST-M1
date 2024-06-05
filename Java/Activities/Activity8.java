package Activities;
class CustomException extends Exception{
    private String message;
    CustomException(String msg){
        this.message = msg;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
public class Activity8 {
    public static void main(String[] args) {
        try{
            Activity8.exceptionTest("Print to Console");
            Activity8.exceptionTest(null);

        }catch (CustomException ec){
            System.out.println("Inside Catch: " + ec.getMessage());
        }
    }
    static void exceptionTest(String str) throws CustomException{
        if(str == null){
            throw new CustomException("String is null");
        }else {
            System.out.println(str);
        }
    }
}
