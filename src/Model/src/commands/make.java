//package commands;
//
//import external.ModelTurtle;
//import external.Parse;
//import external.SLogoAbstractExecutable;
//
//import java.util.List;
//import java.util.function.Consumer;
//
//public class make implements SLogoAbstractExecutable {
//    private final static int numParams = 2;
//    private String param1;
//    private double param2;
//    private double result;
//    private Consumer<Parse> c;
//
//
//
//    public make(List params) {
//        if (params.size() != numParams) {
//            throw new IllegalArgumentException("Argument Length Error");
//        }
//        try {
//            param1 = (String) params.get(0);
//            param2 = Double.parseDouble((String) params.get(1));
//        } catch (ClassCastException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void execute(ModelTurtle turtle) {
//        c = (p) -> {
//            p.
//
//        }
//    }
//}
