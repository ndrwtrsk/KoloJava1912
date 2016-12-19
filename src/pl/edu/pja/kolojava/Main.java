package pl.edu.pja.kolojava;

public class Main {

    public static void main(String[] args) throws BadInputException {

//        int c = 3/0;
        Tool tool = new Tool();
        int a = 3;
        int b = 0;
        try {
            System.out.println("W bloku try");
//            return;

            tool.divide(a, b);
//            throw new IOException();
        }
         catch (ArithmeticException e) {
            System.out.println("Zlapalismy wyjatek " + e.getMessage());
             throw new BadInputException("bad input", b, e);
        }
//        catch (IOException e) {
//            e.printStackTrace();
         finally {
            System.out.println("W bloku finally");
        }
//        catch (Exception ex) {
//            System.out.println("Zlapalismy exception" + ex.getMessage());
//        }

        System.out.println("Po bloku catch");
    }
}
