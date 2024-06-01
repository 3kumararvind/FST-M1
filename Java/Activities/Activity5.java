package Activities;

public class Activity5 {

    public static void main(String []args) {

            String title = "The Moon";
             Book newNovel = new MyBook();

            newNovel.setTitle(title);

           System.out.println("The title is: " + newNovel.getTitle());
        }
}
