package tplabs;

import java.util.ArrayList;

public class MultiLevelDock {
    ArrayList<Harbour<Transport>> dockStages;

    private final int countPlaces = 20;

    public MultiLevelDock(int countStages, int pictureWidth, int pictureHeight) {
        dockStages = new ArrayList<Harbour<Transport>>();
        for (int i = 0; i < countStages; i++) {
            dockStages.add(new Harbour<Transport>(countPlaces, pictureWidth, pictureHeight));
        }
    }

    public Harbour<Transport> getDock(int ind) {
        if ((ind > -1) && (ind < dockStages.size())) {
            return dockStages.get(ind);
        }
        return null;
    }
}
