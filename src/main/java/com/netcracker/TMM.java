package com.netcracker;

public class TMM {
    private int satelite;
    private double zadPer;
    private double min=1000;
    private double[] minzub=new double[4];

    public TMM(int satelite, double zadPer) {
        this.satelite = satelite;
        this.zadPer = zadPer;
    }

    public boolean sborka(int z1){
        if (z1%satelite==0)
            return true;
            else return false;
    }

    public boolean sosedstvo(int z1, int z2, int z3){
        if (Math.sin(3.14/satelite)>((Math.max(z2,z3)+2)/(z1+z2)))
            return true;
        else return false;
    }

    public void Calculate(){
        int zmin=17;


        for(int z1=zmin;z1<150;z1++){
            for (int z2=zmin;z2<200;z2++){
                for (int z3=zmin;z3<200;z3++){
                    int z4=z1+z2+z3;
                    double per=Math.abs(1-(z2*z4)/(z3*z1));

                    if((Math.abs(zadPer-per)/zadPer<=0.05)&&sosedstvo(z1,z2,z3)&&sborka(z1)&&(z4<=200)){
                        System.out.println("z1="+z1+" z2="+z2+" z3="+z3+" z4="+z4+" передаточное отношение="+per);
                        if (z1+z2<min) {
                            min = z1 + z2;
                            minzub[0]=z1;
                            minzub[1]=z2;
                            minzub[2]=z3;
                            minzub[3]=z4;
                        }
                    }
                }
            }
        }
        System.out.println("min z1="+minzub[0]+" min z2="+minzub[1]+" min z3="+minzub[2]+" min z4="+minzub[3]);
    }
}
