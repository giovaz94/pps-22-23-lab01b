package e2.logic;


import e2.logic.state.StateEnum;

public interface Logics {
    void click(int x, int y);

    StateEnum getStatus();
}
