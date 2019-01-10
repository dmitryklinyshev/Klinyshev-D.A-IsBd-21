package tplabs;

import java.util.ArrayList;

public class MultiLevelDock {
    ArrayList<Dock<Transport>> dockStages;

    private final int countPlaces = 20;

    public MultiLevelDock(int countStages, int pictureWidth, int pictureHeight) {
        dockStages = new ArrayList<Dock<Transport>>();
        for (int i = 0; i < countStages; i++) {
            dockStages.add(new Dock<Transport>(countPlaces, pictureWidth, pictureHeight));
        }
    }

    public Dock<Transport> getDock(int ind) {
        if ((ind > -1) && (ind < dockStages.size())) {
            return dockStages.get(ind);
        }
        return null;
    }
}
