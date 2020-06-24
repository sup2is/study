package me.sup2is;

public class VoltageAdapter implements ConcentricPlug110V{

    private Electronic electronic;

    public VoltageAdapter(Electronic electronic) {
        this.electronic = electronic;
    }

    @Override
    public void apply() {
        if(electronic.is220V()){
            System.out.println("## 110V의 변압기를 사용");
        }
        electronic.use();
    }
}
