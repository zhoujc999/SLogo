package external;


import java.util.Random;

public class SLogoRandom {

    private static SLogoRandom r;
    private Random random;


    private SLogoRandom() {
        random = new Random();
    }

    public static SLogoRandom getInstance() {
        if (r == null)
        {
            synchronized(SLogoRandom.class)
            {
                if (r == null)
                {
                    r = new SLogoRandom();
                }
            }
        }

        return r;
    }
    final synchronized public double nextD() {
        return random.nextDouble();
    }

}
