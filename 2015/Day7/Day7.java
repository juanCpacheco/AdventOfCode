package Day7;

public class Day7 
{
    //Clase que repreenta un cable.
    private static class Wire
    {
        private String id;
        private Boolean lit;

        public Wire(int x, int y)
        {
            this.lit = false;
        }
        public void setLit()
        {
            this.lit = true;
        }
        public void setOff()
        {
            this.lit = false;
        }
        public boolean getLit()
        {
            return this.lit;
        }
    }

}
